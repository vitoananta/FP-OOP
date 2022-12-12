package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class HpRender {

	private Health hp;

	public HpRender(Health hp) {
		this.hp = hp;
	}

	protected void hpRender(Graphics2D g2, Shape shape, double x) {
		double hpY = (shape.getBounds().getY() - 15);
		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(x+3, hpY, 64, 3));
		g2.setColor(Color.red);
		double hpNow = hp.getCurrentHealth() / hp.getMaxHealth() * 64;
		g2.fill(new Rectangle2D.Double(x+3, hpY, hpNow, 3));
	}

	public boolean updateHp(float hpLoss) {
		hp.setCurrentHealth(hp.getCurrentHealth() - hpLoss);
		return hp.getCurrentHealth() > 0;
	}

	public double getHp() {
		return hp.getCurrentHealth();
	}

	public void resetHp() {
		hp.setCurrentHealth(hp.getMaxHealth());
	}
}
