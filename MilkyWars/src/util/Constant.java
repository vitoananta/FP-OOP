package util;

import main.Game;

public class Constant {

	public static class UI {
		public static class Buttons {
			public static final int B_WIDTH_DEFAULT = 140;
			public static final int B_HEIGHT_DEFAULT = 56;
			public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
			public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
		}
	}

	public static class Directions {
		public static final int LEFT = 0;
		public static final int RIGHT = 1;
		public static final int FORWARD = 2;
	}

	public static class PlayerConstants {
		public static final int STOP = 0;
		public static final int SPEED = 1;

		public static int GetSpriteAmount(int player_action) {
			switch (player_action) {
			case STOP:
			case SPEED:
				return 1;
			default:
				return 1;
			}
		}
	}
}