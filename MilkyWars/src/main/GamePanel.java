package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import input.KeyboardInput;
import input.MouseInput;
import static util.Constant.PlayerConstants.*;
import static util.Constant.Directions.*;

public class GamePanel extends JPanel {

	private MouseInput mouseInput;
	private float xPlayer = 100, yPlayer = 100;
	private BufferedImage img;
	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed = 144;
	private int playerAction = STOP;
	private int playerDir = -1;
	private boolean moving = false;

	public GamePanel() {
		importImg();
		loadAnimations();
		mouseInput = new MouseInput(this);
		addKeyListener(new KeyboardInput(this));
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
		setPanelSize();
	}

	private void loadAnimations() {
		animations = new BufferedImage[2][1];

		for (int j = 0; j < animations.length; j++) {
			for (int i = 0; i < animations[j].length; i++) {
				animations[j][i] = img.getSubimage(i * 109, j * 116, 109, 116);
			}
		}
	}

	private void importImg() {
		InputStream is = getClass().getResourceAsStream("/player1sprite.png");

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
	}

	private void setPanelSize() {
		Dimension sizeDimension = new Dimension(1366, 768);
		setPreferredSize(sizeDimension);
	}

	public void setDirection(int direction) {
		this.playerDir = direction;
		moving = true;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	private void updateAnimationTick() {
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= GetSpriteAmount(playerAction)) {
				aniIndex = 0;
			}
		}
	}

	private void setAnimation() {
		if (moving) {
			playerAction = SPEED;
		} else {
			playerAction = STOP;
		}
	}

	private void updatePosition() {
		if (moving) {
			switch (playerDir) {
			case LEFT:
				xPlayer -= 5;
				break;
			case RIGHT:
				xPlayer += 5;
				break;
			case FORWARD:
				yPlayer -= 5;
				break;
			case BACKWARD:
				yPlayer += 5;
				break;
			}
		}
	}

	public void updateGame() {
		updateAnimationTick();
		setAnimation();
		updatePosition();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(animations[playerAction][aniIndex], (int) xPlayer, (int) yPlayer, 100, 100, null);
//		g.drawImage(img, 1266 / 2, 768 / 2, null);
	}

}
