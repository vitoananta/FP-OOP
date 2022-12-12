package entity;

import static util.Constant.PlayerConstants.GetSpriteAmount;
import static util.Constant.PlayerConstants.SPEED;
import static util.Constant.PlayerConstants.STOP;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

import gamestate.Play;
import main.Game;
import util.Load;

public class Invader implements EntityMethod {

	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed = 144;
	private int enemyState = STOP;
	private boolean moving = false;
	private Area enemyShape;

	private double x, y;
	private final float speed = 0.5f;
	private float angle = 0f;
	private Play play;

	public Invader() {
		loadAnimations();
		initHitbox();
	}

	public void update() {
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
		g2.drawImage(animations[enemyState][aniIndex], tran, null);
		g2.setTransform(olTransform);

		// check hitbox
//		g2.setColor(Color.red);
//		g2.draw(getHitbox());
	}

	public void updateAnimationTick() {
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= GetSpriteAmount(enemyState)) {
				aniIndex = 0;
			}
		}
	}

	public void setAnimation() {
		if (moving) {
			enemyState = SPEED;
		} else {
			enemyState = STOP;
		}
	}

	public void loadAnimations() {
		BufferedImage img = Load.GetSprite(Load.ENEMY1_SPRITE);

		animations = new BufferedImage[2][1];
		for (int j = 0; j < animations.length; j++) {
			for (int i = 0; i < animations[j].length; i++) {
				animations[j][i] = img.getSubimage(i * 64, j * 68, 64, 68);
			}
		}

	}

	public void initHitbox() {
		Path2D p = new Path2D.Double();
		p.moveTo(24, 35);
		p.lineTo(24, 29);
		p.lineTo(16, 29);
		p.lineTo(10, 17);
		p.lineTo(27, 5);
		p.lineTo(64, 20);
		p.lineTo(62, 32);
		p.lineTo(50, 27);
		p.lineTo(50, 42);
		p.lineTo(62, 39);
		p.lineTo(64, 51);
		p.lineTo(27, 66);
		p.lineTo(10, 54);
		p.lineTo(16, 42);
		p.lineTo(24, 39);
		enemyShape = new Area(p);
	}

	public Area getHitbox() {
		AffineTransform afx = new AffineTransform();
		afx.translate(x, y);
		afx.rotate(Math.toRadians(angle), 32, 35);
		return new Area(afx.createTransformedShape(enemyShape));
	}

	public void changeLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void changeAngle(float angle) {
		if (angle < 0) {
			angle = 359;
		} else if (angle > 359) {
			angle = 0;
		}
		this.angle = angle;
	}

	public boolean checkOutside(int width, int height) {
		Rectangle enemyHitbox = getHitbox().getBounds();
		if (x <= -enemyHitbox.getWidth() || y < -enemyHitbox.getHeight() || x > width || y > height) {
			return false;
		} else {
			moving = true;
			return true;
		}
	}

	public float getAngle() {
		return angle;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
}
