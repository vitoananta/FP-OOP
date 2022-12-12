package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import entity.Player;
import level.LevelController;
import level.LevelController;
import main.Game;
import util.Load;

public class Play extends State implements Statemethod {
	private Player player;
	private LevelController levelController;
	private BufferedImage backgroundImg;

	public Play(Game game) {
		super(game);
		initClasses();
		backgroundImg = Load.GetSprite(Load.PLAY_BACKGROUND1);
	}

	private void initClasses() {
		levelController = new LevelController(game);
		player = new Player(200, 200, (int) (109 * Game.SCALE), (int) (116 * Game.SCALE));
		player.loadLevelData(levelController.getCurrentLevel().getLevelData());
	}

	@Override
	public void update() {
		levelController.update();
		player.update();

	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(backgroundImg, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
		levelController.draw(g);
		player.render(g);

	}

	@Override
	public void mouseClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePress(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseRelease(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMove(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPress(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			player.setUp(true);
			break;
		case KeyEvent.VK_A:
			player.setLeft(true);
			break;
		case KeyEvent.VK_D:
			player.setRight(true);
			break;
		case KeyEvent.VK_ESCAPE:
			Gamestate.state = Gamestate.MENU;
		}

	}

	@Override
	public void keyRelease(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			player.setUp(false);
			break;
		case KeyEvent.VK_A:
			player.setLeft(false);
			break;
		case KeyEvent.VK_D:
			player.setRight(false);
			break;
		}

	}

	public void windowFocusLost() {
		player.resetDirBooleans();
	}

	public Player getPlayer() {
		return player;
	}
}
