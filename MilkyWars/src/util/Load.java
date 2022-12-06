package util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Load {

	public static final String PLAYER_SPRITE = "player1_sprite.png";
	public static final String LEVEL_SPRITE = "out_sprite.png";

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
}
