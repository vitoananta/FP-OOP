package level;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.Game;
import util.Load;

public class LevelController {

	private Game game;
	private BufferedImage levelSprite;

	public LevelController(Game game) {
		this.game = game;
		levelSprite = Load.GetSprite(Load.LEVEL_SPRITE);
	}

	public void draw(Graphics g) {
		g.drawImage(levelSprite, 0, 0, null);
	}

	public void update() {

	}
}
