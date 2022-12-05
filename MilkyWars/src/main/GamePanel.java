package main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import input.KeyboardInput;
import input.MouseInput;

public class GamePanel extends JPanel {

	private MouseInput mouseInput;
	private Game game;

	public GamePanel(Game game) {

		requestFocus();
		addKeyListener(new KeyboardInput(this));
		this.game = game;
		mouseInput = new MouseInput(this);
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
		setPanelSize();
	}

	private void setPanelSize() {
		Dimension sizeDimension = new Dimension(1366, 768);
		setPreferredSize(sizeDimension);
	}

	public void updateGame() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		game.update();
		game.render(g);
	}

	public Game getGame() {
		return game;
	}

}
