package main;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

	public GameWindow(GamePanel gamePanel) {

//		setSize(1366, 768);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(gamePanel);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
