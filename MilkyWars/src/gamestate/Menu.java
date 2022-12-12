package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import main.Game;
import ui.MenuButton;
import util.Load;

public class Menu extends State implements Statemethod {

	private MenuButton[] button = new MenuButton[3];
	private BufferedImage backgroundImgBlack;
	private Play play;

	public Menu(Game game, Play play) {
		super(game);
		this.play = play;
		loadButton();
		backgroundImgBlack = Load.GetSprite(Load.MENU_BACKGROUND);
	}

	private void loadButton() {
		button[0] = new MenuButton(Game.GAME_WIDTH / 2, (int) (150 * Game.SCALE), 0, Gamestate.PLAY);
		button[1] = new MenuButton(Game.GAME_WIDTH / 2, (int) (220 * Game.SCALE), 1, Gamestate.HIGHSCORE);
		button[2] = new MenuButton(Game.GAME_WIDTH / 2, (int) (290 * Game.SCALE), 2, Gamestate.QUIT);
	}

	@Override
	public void update() {
		for (MenuButton menuButton : button) {
			menuButton.update();
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(backgroundImgBlack, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
		for (MenuButton menuButton : button) {
			menuButton.draw(g);
		}
	}

	@Override
	public void mouseClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePress(MouseEvent e) {
		for (MenuButton menuButton : button) {
			if (isInButton(e, menuButton)) {
				menuButton.setMousePress(true);
				break;
			}
		}
	}

	@Override
	public void mouseRelease(MouseEvent e) {
		for (MenuButton menuButton : button) {
			if (isInButton(e, menuButton)) {
				if (menuButton.isMousePress()) {
					menuButton.applyGamestate();
					break;
				}
			}
		}
		resetButtons();
	}

	private void resetButtons() {
		for (MenuButton menuButton : button) {
			menuButton.resetBoolean();
		}
	}

	@Override
	public void mouseMove(MouseEvent e) {
		for (MenuButton menuButton : button) {
			menuButton.setMouseHover(false);
		}
		for (MenuButton menuButton : button) {
			if (isInButton(e, menuButton)) {
				menuButton.setMouseHover(true);
				break;
			}
		}

	}

	@Override
	public void keyPress(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			play.resetAll();
			Gamestate.state = Gamestate.PLAY;
		}

	}

	@Override
	public void keyRelease(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
