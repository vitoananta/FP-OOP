package entity;

import static util.Constant.EenemyConstants.*;

import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

public class Enemy1 extends Enemy {
	
	private Area enemy1Shape;
	
	public Enemy1(float x, float y) {
		super(x, y, ENEMY1_WIDTH, ENEMY1_HEIGHT, ENEMY1);

	}
	
	private void initEnemy1Hitbox() {
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
		enemy1Shape = new Area(p);
	}

	public Area getHitbox() {
		AffineTransform afx = new AffineTransform();
		afx.translate(x, y);
		afx.rotate(Math.toRadians(0), 32, 35);
		return new Area(afx.createTransformedShape(enemy1Shape));
	}
}
