package util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.Game;

public class Load {

	public static final String PLAYER_SPRITE = "player1_sprite.png";
	public static final String LEVEL_SPRITE = "building_sprite.png";
	public static final String LEVEL_ONE = "level_clear.png"; // testing enemy
	public static final String MENU_BUTTON = "menu_button.png";
	public static final String MENU_BACKGROUND = "black_background.png";
	public static final String PLAY_BACKGROUND1 = "blue_background.png";
	public static final String ENEMY1_SPRITE = "enemy1_sprite.png";
	public static final String METEOR_SPRITE = "meteor_sprite.png";

	public static BufferedImage GetSprite(String fileName) {
		BufferedImage img = null;
		InputStream is = Load.class.getResourceAsStream("/" + fileName);

		try {
			img = ImageIO.read(is);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	}

	public static int[][] GetLevelData() {
		int[][] levelData = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];
		BufferedImage img = GetSprite(LEVEL_ONE);

		for (int j = 0; j < img.getHeight(); j++) {
			for (int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getRed();
				if (value >= 48) {
					value = 0;
				}
				levelData[j][i] = color.getRed();
			}
		}
		return levelData;
	}
}
