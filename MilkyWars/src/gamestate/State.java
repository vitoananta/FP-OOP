package gamestate;

import java.awt.event.MouseEvent;
import main.Game;
import ui.MenuButton;

public class State {

	protected Game game;

	public State(Game game) {
		this.game = game;
	}

	public boolean isInButton(MouseEvent e, MenuButton menuButton) {
		return menuButton.getBounds().contains(e.getX(), e.getY());
	}

	public Game getGame() {
		return game;
	}
}
