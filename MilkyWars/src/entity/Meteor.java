package entity;

import static util.Constant.MeteorConstants.GetSpriteAmount;
import static util.Constant.MeteorConstants.SPEED;
import static util.Constant.MeteorConstants.STOP;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import util.Load;

public class Meteor extends Object implements EntityMethod {

	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed = 60;
	private int meteorState = STOP;
	private boolean moving = false;
	private Area meteorShape;

	private double x, y;
	private final float speed = 0.6f;
	private float angle = 0f;

	public Meteor() {
		super(new Health(75, 75));
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
		g2.drawImage(animations[meteorState][aniIndex], tran, null);
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
			if (aniIndex >= GetSpriteAmount(meteorState)) {
				aniIndex = 0;
			}
		}
	}

	public void setAnimation() {
		if (moving) {
			meteorState = SPEED;
		} else {
			meteorState = STOP;
		}
	}

	public void loadAnimations() {
		BufferedImage img = Load.GetSprite(Load.METEOR_SPRITE);

		animations = new BufferedImage[2][6];
		for (int j = 0; j < animations.length; j++) {
			for (int i = 0; i < animations[j].length; i++) {
				animations[j][i] = img.getSubimage(i * 64, j * 68, 64, 68);
			}
		}

	}

	public void initHitbox() {
		Path2D p = new Path2D.Double();
		p.moveTo(10, 18);
		p.lineTo(24, 8);
		p.lineTo(50, 6);
		p.lineTo(64, 29);
		p.lineTo(57, 56);
		p.lineTo(36, 67);
		p.lineTo(4, 52);
		meteorShape = new Area(p);
	}

	public Area getHitbox() {
		AffineTransform afx = new AffineTransform();
		afx.translate(x, y);
		afx.rotate(Math.toRadians(angle), 32, 35);
		return new Area(afx.createTransformedShape(meteorShape));
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
		Rectangle meteorHitbox = getHitbox().getBounds();
		if (x <= -meteorHitbox.getWidth() || y < -meteorHitbox.getHeight() || x > width || y > height) {
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
	
	public String printEnemyDetail() {
		return ("This enemy is meteor! It gives more damage than invader when collding.");
	}
}
