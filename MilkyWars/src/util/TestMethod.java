package util;

import java.awt.Rectangle;
import main.Game;

public class TestMethod {

	private static boolean isSolid(Rectangle playerHitbox, double x, double y, int[][] levelData) {
		if (playerHitbox.getX() < 0 || playerHitbox.getMaxX() >= Game.GAME_WIDTH) {
			return true;
		}
		if (playerHitbox.getY() < 0 || playerHitbox.getMaxY() >= Game.GAME_HEIGHT) {
			return true;
		}

		double xIndex = x / Game.TILES_SIZE;
		double yIndex = y / Game.TILES_SIZE;

		int value = levelData[(int) yIndex][(int) xIndex];
		if (value >= 48 || value <= 0 || value != 11)
			return true;
		return false;
	}

	public static boolean CanMoveHere(Rectangle playerHitbox, int[][] lvlData) {
		if (isSolid(playerHitbox, playerHitbox.getX(), playerHitbox.getY(), lvlData) // top left
				|| isSolid(playerHitbox, playerHitbox.getMaxX(), playerHitbox.getMaxY(), lvlData) // bottom right
				|| isSolid(playerHitbox, playerHitbox.getMaxX(), playerHitbox.getY(), lvlData) // top right
				|| isSolid(playerHitbox, playerHitbox.getX(), playerHitbox.getMaxY(), lvlData) // bottom left
				|| isSolid(playerHitbox, playerHitbox.getCenterX(), playerHitbox.getY(), lvlData) // top center
				|| isSolid(playerHitbox, playerHitbox.getCenterX(), playerHitbox.getMaxY(), lvlData) // bottom center
				|| isSolid(playerHitbox, playerHitbox.getX(), playerHitbox.getCenterY(), lvlData) // left center
				|| isSolid(playerHitbox, playerHitbox.getMaxX(), playerHitbox.getCenterY(), lvlData)) // right center
			return false;
		return true;
	}
}
