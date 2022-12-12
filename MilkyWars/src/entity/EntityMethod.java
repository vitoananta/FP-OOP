package entity;

import java.awt.Graphics;
import java.awt.geom.Area;

public interface EntityMethod {

	public void update();

	public void render(Graphics g);

	public void updateAnimationTick();

	public void setAnimation();

	public void loadAnimations();

	public void initHitbox();

	public Area getHitbox();
}
