package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import gamestate.Gamestate;
import util.Load;
import static util.Constant.UI.Buttons.*;

public class MenuButton {

	private int x, y, rowIndex, index;
	private int xOffsetCenter = B_WIDTH / 2;
	private Gamestate state;
	private BufferedImage[] img;
	private boolean mouseHover, mousePress;
	private Rectangle bounds;

	public MenuButton(int x, int y, int rowIndex, Gamestate state) {
		this.x = x;
		this.y = y;
		this.rowIndex = rowIndex;
		this.state = state;
		loadImg();
		initShape();
	}

	private void initShape() {
		bounds = new Rectangle(x - xOffsetCenter, y, B_WIDTH, B_HEIGHT);

	}

	private void loadImg() {
		img = new BufferedImage[3];
		BufferedImage temp = Load.GetSprite(Load.MENU_BUTTON);
		for (int i = 0; i < img.length; i++) {
			img[i] = temp.getSubimage(i * B_WIDTH_DEFAULT, rowIndex * B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT,
					B_HEIGHT_DEFAULT);
		}

	}

	public void draw(Graphics g) {
		g.drawImage(img[index], x - xOffsetCenter, y, B_WIDTH, B_HEIGHT, null);
	}

	public void update() {
		index = 0;
		if (mouseHover) {
			index = 1;
		}
		if (mousePress) {
			index = 2;
		}
	}

	public boolean isMouseHover() {
		return mouseHover;
	}

	public void setMouseHover(boolean mouseHover) {
		this.mouseHover = mouseHover;
	}

	public boolean isMousePress() {
		return mousePress;
	}

	public void setMousePress(boolean mousePress) {
		this.mousePress = mousePress;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}

	public void applyGamestate() {
		Gamestate.state = state;
	}

	public void resetBoolean() {
		mouseHover = false;
		mousePress = false;
	}
}
