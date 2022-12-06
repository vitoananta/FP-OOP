package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface Statemethod {

	public void update();

	public void draw(Graphics g);

	public void mouseClick(MouseEvent e);

	public void mousePress(MouseEvent e);

	public void mouseRelease(MouseEvent e);

	public void mouseMove(MouseEvent e);

	public void keyPress(KeyEvent e);

	public void keyRelease(KeyEvent e);
}
