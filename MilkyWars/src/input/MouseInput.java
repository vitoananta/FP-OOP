package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import gamestate.Gamestate;
import main.GamePanel;

public class MouseInput implements MouseListener, MouseMotionListener {

	private GamePanel gamePanel;

	public MouseInput(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		switch (Gamestate.state) {
		case MENU:
			gamePanel.getGame().getMenu().mouseMove(e);
			break;
		case PLAY:
			gamePanel.getGame().getPlay().mouseMove(e);
			break;
		default:
			break;

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (Gamestate.state) {
		case PLAY:
			gamePanel.getGame().getPlay().mouseClick(e);
			break;
		default:
			break;

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch (Gamestate.state) {
		case MENU:
			gamePanel.getGame().getMenu().mousePress(e);
			break;
		case PLAY:
			gamePanel.getGame().getPlay().mousePress(e);
			break;
		default:
			break;

		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch (Gamestate.state) {
		case MENU:
			gamePanel.getGame().getMenu().mouseRelease(e);
			break;
		case PLAY:
			gamePanel.getGame().getPlay().mouseRelease(e);
			break;
		default:
			break;

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
