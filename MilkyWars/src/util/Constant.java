package util;

public class Constant {

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