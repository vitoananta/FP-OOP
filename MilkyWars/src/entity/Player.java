package entity;

import static util.Constant.PlayerConstants.GetSpriteAmount;
import static util.Constant.PlayerConstants.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Player extends Entity {

	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed = 144;
	private int playerAction = STOP;
	private boolean moving = false;
	private boolean left, right, up;
	private float maxPlayerSpeed = 0.7f;
	private float speed = 0f;
	private boolean speedUp;
	private float angle = 0f;

	public Player(float x, float y) {
		super(x, y);
		loadAnimations();
	}

	public void update() {
		updatePosition();
		updateAnimationTick();
		setAnimation();
		x += Math.cos(Math.toRadians(angle)) * speed;
		y += Math.sin(Math.toRadians(angle)) * speed;
	}

	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform olTransform = g2.getTransform();
		g2.translate(x, y);
		AffineTransform tran = new AffineTransform();
		tran.rotate(Math.toRadians(angle + 90), 54.5, 55);
		g2.drawImage(animations[playerAction][aniIndex], tran, null);
		g2.setTransform(olTransform);
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

	private void loadAnimations() {
		InputStream is = getClass().getResourceAsStream("/player1sprite.png");

		try {
			BufferedImage img = ImageIO.read(is);

			animations = new BufferedImage[2][1];
			for (int j = 0; j < animations.length; j++) {
				for (int i = 0; i < animations[j].length; i++) {
					animations[j][i] = img.getSubimage(i * 109, j * 116, 109, 116);
				}
			}
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

	// ROTATE TEST
	public void changeAngle() {
		if (angle < 0) {
			angle = 359;
		} else if (angle > 359) {
			angle = 0;
		}
		this.angle = angle;
	}

	public void speedUp() {
		speedUp = true;
		if (speed > maxPlayerSpeed) {
			speed = maxPlayerSpeed;
		} else {
			speed += 0.0085f;
		}
	}

	public void speedDown() {
		speedUp = false;
		if (speed <= 0) {
			speed = 0;
		} else {
			speed -= 0.003f;
		}
	}

	private void updatePosition() {

		moving = false;
		float rotateSpeed = 0.3f;

		if (left && !right) {
			angle -= rotateSpeed;
		} else if (right && !left) {
			angle += rotateSpeed;
		}
		if (up) {
			speedUp();
			moving = true;
		} else if (!up) {
			speedDown();
		}
	}

	public void resetDirBooleans() {
		left = false;
		right = false;
		up = false;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public float getAngle() {
		return angle;
	}

	public float getX() {
		return super.x;
	}

	public float getY() {
		return super.y;
	}
}
