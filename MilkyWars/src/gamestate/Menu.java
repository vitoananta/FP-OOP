package gamestate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.Game;

public class Menu extends State implements Statemethod {

	public Menu(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawString("MILKY WARS", Game.GAME_WIDTH / 2, Game.GAME_HEIGHT / 2-10);
		g.drawString("Game Menu", Game.GAME_WIDTH / 2, Game.GAME_HEIGHT / 2 + 10);
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
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Gamestate.state = Gamestate.PLAY;
		}

	}

	@Override
	public void keyRelease(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
