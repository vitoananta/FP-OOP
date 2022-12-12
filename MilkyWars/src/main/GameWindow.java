package main;

import javax.swing.JFrame;

import entity.Player;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameWindow extends JFrame {
	
	private Player player;

	public GameWindow(GamePanel gamePanel) {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(gamePanel);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		addWindowFocusListener(new WindowFocusListener() {

			@Override
			public void windowLostFocus(WindowEvent e) {
				gamePanel.getGame().windowFocusLost();
			}

			@Override
			public void windowGainedFocus(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
}
