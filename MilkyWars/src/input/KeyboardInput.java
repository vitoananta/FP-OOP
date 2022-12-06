package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gamestate.Gamestate;
import main.GamePanel;
import static util.Constant.Directions.*;

public class KeyboardInput implements KeyListener {

	private GamePanel gamePanel;

	public KeyboardInput(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (Gamestate.state) {
		case MENU:
			gamePanel.getGame().getMenu().keyPress(e);
			break;
		case PLAY:
			gamePanel.getGame().getPlay().keyPress(e);
			break;
		default:
			break;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (Gamestate.state) {
		case MENU:
			gamePanel.getGame().getMenu().keyRelease(e);
			break;
		case PLAY:
			gamePanel.getGame().getPlay().keyRelease(e);
			break;
		default:
			break;

		}
	}

}
