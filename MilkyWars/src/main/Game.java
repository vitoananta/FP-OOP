package main;

import java.awt.Graphics;
import entity.Player;
import gamestate.Gamestate;
import gamestate.Menu;
import gamestate.Play;
import level.LevelController;

public class Game implements Runnable {

	private GameWindow gameWindow;
	private GamePanel gamePanel;
	public Thread gameThread;
	private final int TARGET_FPS = 144;
	private final int TARGET_UPS = 200;
	private Player player;
	private LevelController levelController;
	public final static int TILES_DEFAULT_SIZE = 32;
	public final static float SCALE = 1.5f;
	public final static int TILES_IN_WIDTH = 26;
	public final static int TILES_IN_HEIGHT = 14;
	public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
	public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
	public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
	private Play play;
	private Menu menu;

	public Game() {
		initClasses();
		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		startGameLoop();
	}

	private void initClasses() {
		play = new Play(this);
		menu = new Menu(this, play);
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void update() {
		switch (Gamestate.state) {
		case MENU:
			menu.update();
			break;
		case PLAY:
			play.update();
			break;
		case HIGHSCORE:
		case QUIT:
		default:
			System.exit(0);
			break;

		}
	}

	public void render(Graphics g) {
		switch (Gamestate.state) {
		case MENU:
			menu.draw(g);
			break;
		case PLAY:
			play.draw(g);
			break;
		default:
			break;

		}
	}

	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / TARGET_FPS;
		double timePerUpdate = 1000000000.0 / TARGET_UPS;

		long previousTime = System.nanoTime();

		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();

		double deltaU = 0;
		double deltaF = 0;

		while (true) {

			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			if (deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}

			if (deltaF >= 1) {
				gamePanel.repaint();
				frames++;
				deltaF--;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
			}

		}
	}

	public void windowFocusLost() {
		player.resetDirBooleans();
	}

	public Menu getMenu() {
		return menu;
	}

	public Play getPlay() {
		return play;
	}
}
