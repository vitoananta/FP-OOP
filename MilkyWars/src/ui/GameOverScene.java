package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import gamestate.Gamestate;
import gamestate.Play;
import main.Game;
import util.Load;

public class GameOverScene {

	private Play play;
	private BufferedImage backgroundImgGameOver;

	public GameOverScene(Play play) {
		this.play = play;
		backgroundImgGameOver = Load.GetSprite(Load.GAME_OVER_BG);
	}

	public void draw(Graphics g) {
		g.drawImage(backgroundImgGameOver, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
		g.setColor(Color.white);
		g.setFont(new Font("Verdana", Font.BOLD, 50));
		g.drawString("Game Over", Game.GAME_WIDTH / 2 - 145, Game.GAME_HEIGHT / 2 - 75);
		g.drawString("Press ENTER to Main Menu!", Game.GAME_WIDTH / 2 - 345, Game.GAME_HEIGHT / 2 + 75);
	}

	public void keyPres(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//			play.resetAll();
			Gamestate.state = Gamestate.MENU;
		}
	}
}
