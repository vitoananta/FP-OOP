package entity;

import static util.Constant.PlayerConstants.GetSpriteAmount;
import static util.Constant.PlayerConstants.*;
import static util.TestMethod.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;

import gamestate.Play;
import main.Game;
import util.Load;

public class Player extends Object implements EntityMethod {

	private float x, y;
	private int width, height;
	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed = 1;
	private int playerAction = STOP;
	private boolean moving = false;
	private boolean left, right, up, stop;
	private float maxPlayerSpeed = 0.5f;
	private float speed = 0f;
	private float angle = 0f;
	private Area playerShape;
	private int[][] levelData;
	private Play play;
	private boolean alive = true;

	public Player(float x, float y, int width, int height, Play play) {
		super(new Health(100, 100));
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.play = play;
		loadAnimations();
		initHitbox();
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
		tran.rotate(Math.toRadians(angle + 90), 32, 35);
		g2.drawImage(animations[playerAction][aniIndex], tran, null);
		g2.setTransform(olTransform);

		// check hitbox
//		g2.setColor(Color.green);
//		g2.draw(getHitbox());
		hpRenderPlayer(g2, getHitbox(), x);
//		drawHealth(g2);
	}

	public void updateAnimationTick() {
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= GetSpriteAmount(playerAction)) {
				aniIndex = 0;
			}
		}
	}

	public void setAnimation() {
		if (moving) {
			playerAction = SPEED;
		} else {
			playerAction = STOP;
		}
	}

	public void loadAnimations() {
		BufferedImage img = Load.GetSprite(Load.PLAYER_SPRITE);

		animations = new BufferedImage[2][1];
		for (int j = 0; j < animations.length; j++) {
			for (int i = 0; i < animations[j].length; i++) {
				animations[j][i] = img.getSubimage(i * 64, j * 68, 64, 68);
			}
		}
	}

	public void initHitbox() {
		Path2D p = new Path2D.Double();
		p.moveTo(19, 35);
		p.lineTo(19, 29);
		p.lineTo(26, 25);
		p.lineTo(28, 7);
		p.lineTo(48, 5);
		p.lineTo(41, 12);
		p.lineTo(49, 27);
		p.lineTo(64, 31);
		p.lineTo(64, 40);
		p.lineTo(48, 43);
		p.lineTo(42, 57);
		p.lineTo(47, 64);
		p.lineTo(28, 62);
		p.lineTo(25, 43);
		p.lineTo(19, 39);
		playerShape = new Area(p);
	}

	public Area getHitbox() {
		AffineTransform afx = new AffineTransform();
		afx.translate(x, y);
		afx.rotate(Math.toRadians(angle), 32, 35);
		return new Area(afx.createTransformedShape(playerShape));
	}

	public void changeAngle(float angle) {
		if (angle < 0) {
			angle = 359;
		} else if (angle > 359) {
			angle = 0;
		}
		this.angle = angle;
	}

	public void speedUp() {
		if (speed > maxPlayerSpeed) {
			speed = maxPlayerSpeed;
		} else {
			speed += 0.003f;
		}
	}

	public void speedDown() {
		if (speed <= 0) {
			speed = 0;
		} else {
			speed -= 0.002f;
		}
	}

	public void resetSpeed() {
		if (speed >= 0) {
			speed = 0;
		}
	}

	private void updatePosition() {

		stop = true;
		moving = false;
		float rotateSpeed;

		if (stop) {
			rotateSpeed = 0.2f;
			if (left && !right) {
				angle -= rotateSpeed;
			} else if (right && !left) {
				angle += rotateSpeed;
			}
		}

		if (up) {
			moving = true;
			stop = false;
			speedUp();
			rotateSpeed = 0.3f;
			if (left && !right) {
				angle -= rotateSpeed;
			} else if (right && !left) {
				angle += rotateSpeed;
			}
		} else {
			speedDown();
		}

		if (!CanMoveHere(getHitbox().getBounds(), levelData)) {
			resetSpeed();
			moving = false;
		}

	}

	public void loadLevelData(int[][] levelData) {
		this.levelData = levelData;
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
		return x;
	}

	public float getY() {
		return y;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void reset() {
		resetDirBooleans();
		resetHp();
		alive = true;
	}
}
