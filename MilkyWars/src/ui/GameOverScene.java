package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import gamestate.Gamestate;
import gamestate.Play;
import main.Game;

public class GameOverScene {

	private Play play;

	public GameOverScene(Play play) {
		this.play = play;
	}

	public void draw(Graphics g) {
		g.setColor(new Color(0, 0, 0, 200));
		g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);

		g.setColor(Color.white);
		g.drawString("Game Over", Game.GAME_WIDTH / 2, Game.GAME_HEIGHT / 2 - 25);
		g.drawString("Press ENTER to Main Menu!", Game.GAME_WIDTH / 2, Game.GAME_HEIGHT / 2 + 25);
	}

	public void keyPres(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//			play.resetAll();
			Gamestate.state = Gamestate.MENU;
		}
	}
}
