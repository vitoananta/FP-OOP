package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.AttributeSetUtilities;

import entity.Invader;
import entity.Laser;
import entity.Meteor;
import entity.Player;
import level.LevelController;
import main.Game;
import util.Load;

public class Play extends State implements Statemethod {
	private Player player;
	private Invader invader;
	private List<Invader> invaders;
	private Meteor meteor;
	private List<Meteor> meteors;
	private Laser laser;
	private List<Laser> lasers;
	private int shotTime;
	private LevelController levelController;
	private BufferedImage backgroundImg;
	private boolean shooting;

	public Play(Game game) {
		super(game);
		initClasses();
		backgroundImg = Load.GetSprite(Load.PLAY_BACKGROUND1);
	}

	private void initClasses() {
		levelController = new LevelController(game);
		player = new Player(Game.GAME_WIDTH / 2 - 35, 500, 64, 68);
		player.changeAngle(270);
		player.loadLevelData(levelController.getCurrentLevel().getLevelData());
		initEnemies();
		initLaser();
	}

	@Override
	public void update() {
		levelController.update();
		player.update();
		updateEnemies();
		updateLaser();
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(backgroundImg, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
		levelController.draw(g);
		renderLaser(g);
		player.render(g);
		renderEnemies(g);
	}

	private void initEnemies() {
		invaders = new ArrayList<>();
		meteors = new ArrayList<>();
		new Thread(new Runnable() {

			@Override
			public void run() {
				long timeInSecond = 7;
				int phaseCounter = 0;
				boolean phaseMax = false;
				while (true) {
					phaseCounter++;
					spawnInvader();
					try {
						TimeUnit.SECONDS.sleep(timeInSecond);
					} catch (InterruptedException e) {
						System.out.println("Cannot delay the enemy, please contact the programmer");
						e.printStackTrace();
					}
					System.out.println("The enemy delay is: " + timeInSecond);
					System.out.println("phase: " + phaseCounter);
					if (!phaseMax) {
						if (phaseCounter % 5 == 0) {
							timeInSecond -= 1;
							if (timeInSecond == 1) {
								phaseMax = true;
							}
						}
					}
					if (phaseCounter % 3 == 0) {
						spawnMeteor();
					}
				}
			}
		}).start();
	}

	private void updateEnemies() {
		for (int i = 0; i < invaders.size(); i++) {
			Invader invader = invaders.get(i);
			if (invader != null) {
				invader.update();
				if (!invader.checkOutside(Game.GAME_WIDTH, Game.GAME_HEIGHT)) {
					invaders.remove(invader);
				} else {
					if (player.isAlive()) {
						collidePlayer(invader);
					}
				}
			}
		}
		for (int i = 0; i < meteors.size(); i++) {
			Meteor meteor = meteors.get(i);
			if (meteor != null) {
				meteor.update();
				if (!meteor.checkOutside(Game.GAME_WIDTH, Game.GAME_HEIGHT)) {
					meteors.remove(meteor);
				}
			}
		}
	}

	private void renderEnemies(Graphics g) {
		for (int i = 0; i < invaders.size(); i++) {
			Invader invader = invaders.get(i);
			if (invader != null) {
				invader.render(g);
			}
		}
		for (int i = 0; i < meteors.size(); i++) {
			Meteor meteor = meteors.get(i);
			if (meteor != null) {
				meteor.render(g);
			}
		}
	}

	private void initLaser() {
		lasers = new ArrayList<>();
	}

	private void updateLaser() {
		for (int i = 0; i < lasers.size(); i++) {
			Laser laser = lasers.get(i);
			if (laser != null) {
				laser.update();
				collideLaser(laser);
				if (!laser.checkOutside(Game.GAME_WIDTH, Game.GAME_HEIGHT)) {
					lasers.remove(laser);
				}
			} else {
				lasers.remove(laser);
			}
		}
	}

	private void renderLaser(Graphics g) {
		for (int i = 0; i < lasers.size(); i++) {
			Laser laser = lasers.get(i);
			if (laser != null) {
				laser.render(g);
			}
		}
	}

	private void collideLaser(Laser laser) {
		for (int i = 0; i < invaders.size(); i++) {
			Invader invader = invaders.get(i);
			if (invader != null) {
				Area laserHitbox = new Area(laser.getHitbox());
				laserHitbox.intersect(invader.getHitbox());
				if (!laserHitbox.isEmpty()) {
					if (!invader.updateHp(laser.getDamage())) {
						invaders.remove(invader);
					}
					lasers.remove(laser);
				}
			}
		}
	}

	private void collidePlayer(Invader invader) {
		if (invader != null) {
			Area playerHitbox = new Area(player.getHitbox());
			playerHitbox.intersect(invader.getHitbox());
			if (!playerHitbox.isEmpty()) {
				double invaderHp = invader.getHp();
				if (!invader.updateHp((float) player.getHp())) {
					invaders.remove(invader);
				}
				if (!player.updateHp((float) invaderHp)) {
					player.setAlive(false);
				}
			}
		}
	}

	private void spawnInvader() {
		Random ran = new Random();
		int spawnY = ran.nextInt(Game.GAME_HEIGHT + 100) - 50;
		Invader invader = new Invader();
		invader.changeLocation(0, spawnY);
		invader.changeAngle(0);
		invaders.add(invader);
		int spawnY2 = ran.nextInt(Game.GAME_HEIGHT + 100) - 50;
		Invader invader2 = new Invader();
		invader2.changeLocation(Game.GAME_WIDTH, spawnY2);
		invader2.changeAngle(180);
		invaders.add(invader2);
	}

	private void spawnMeteor() {
		Random ran = new Random();
		Meteor meteor1 = new Meteor();
		int spawnX = ran.nextInt(Game.GAME_WIDTH + 100) - 50;
		meteor1.changeLocation(spawnX, 0);
		meteor1.changeAngle(90);
		meteors.add(meteor1);
		Meteor meteor2 = new Meteor();
		int spawnX2 = ran.nextInt(Game.GAME_WIDTH + 100) - 50;
		meteor2.changeLocation(spawnX2, Game.GAME_HEIGHT);
		meteor2.changeAngle(270);
		meteors.add(meteor2);
	}

	@Override
	public void mouseClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePress(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseRelease(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMove(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPress(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			player.setUp(true);
			break;
		case KeyEvent.VK_A:
			player.setLeft(true);
			break;
		case KeyEvent.VK_D:
			player.setRight(true);
			break;
		case KeyEvent.VK_SPACE:
			if (shotTime == 0) {
				lasers.add(0, new Laser(player.getX(), player.getY(), player.getAngle(), 10, 2f));
			}
			shotTime++;
			if (shotTime == 5) {
				shotTime = 0;
			}
			break;
		case KeyEvent.VK_ESCAPE:
			Gamestate.state = Gamestate.MENU;
			break;
		}

	}

	@Override
	public void keyRelease(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			player.setUp(false);
			break;
		case KeyEvent.VK_A:
			player.setLeft(false);
			break;
		case KeyEvent.VK_D:
			player.setRight(false);
			break;
		case KeyEvent.VK_SPACE:
			shotTime = 0;
			break;
		}

	}

	public void windowFocusLost() {
		player.resetDirBooleans();
	}

	public Player getPlayer() {
		return player;
	}

	public List<Invader> getInvaders() {
		return invaders;
	}

}