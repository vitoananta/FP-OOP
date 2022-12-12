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

import gamestate.Play;
import util.Load;

public class Laser implements EntityMethod {

	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed = 144;
	private int laserState = STOP;
	private boolean moving = false;
	private Area laserShape;

	private double x, y;
	private final float angle;
	private float damage;
	private float speed = 0.5f;

	public Laser(double x, double y, float angle, float size, float speed) {
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.damage = size;
		this.speed = speed;
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
		g2.drawImage(animations[0][0], tran, null);
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
			if (aniIndex >= GetSpriteAmount(laserState)) {
				aniIndex = 0;
			}
		}
	}

	public void setAnimation() {
		if (moving) {
			laserState = SPEED;
		}
	}

	public void loadAnimations() {
		BufferedImage img = Load.GetSprite(Load.LASER_SPRITE);

		animations = new BufferedImage[1][1];
		for (int j = 0; j < animations.length; j++) {
			for (int i = 0; i < animations[j].length; i++) {
				animations[j][i] = img.getSubimage(i * 64, j * 68, 64, 68);
			}
		}

	}

	public void initHitbox() {
		Path2D p = new Path2D.Double();
		p.moveTo(21, 34);
		p.lineTo(27, 34);
		p.lineTo(28, 33);
		p.lineTo(29, 32);
		p.lineTo(53, 32);
		p.lineTo(54, 33);
		p.lineTo(54, 37);
		p.lineTo(53, 38);
		p.lineTo(29, 38);
		p.lineTo(28, 37);
		p.lineTo(27, 36);
		p.lineTo(21, 36);
		laserShape = new Area(p);
	}

	public Area getHitbox() {
		AffineTransform afx = new AffineTransform();
		afx.translate(x, y);
		afx.rotate(Math.toRadians(angle), 32, 35);
		return new Area(afx.createTransformedShape(laserShape));
	}

	public boolean checkOutside(int width, int height) {
		Rectangle laserHitbox = getHitbox().getBounds();
		if (x <= -laserHitbox.getWidth() || y < -laserHitbox.getHeight() || x > width || y > height) {
			return false;
		} else {
			moving = true;
			return true;
		}
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public float getDamage() {
		return damage;
	}

	public double getcenterx() {
		return x + damage / 2;
	}

	public double getcentery() {
		return y + damage / 2;
	}

}
