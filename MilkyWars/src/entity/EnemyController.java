package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gamestate.Play;
import util.Load;
import static util.Constant.EenemyConstants.*;

public class EnemyController {

	private Play play;
	private BufferedImage[][] enemy1Arr;
	private ArrayList<Enemy1> enemy1s = new ArrayList<>();

	public EnemyController(Play play) {
		this.play = play;
		loadEnemyImg();
	}

	public void update() {
		for (Enemy1 e : enemy1s) {
			e.update();
		}
	}

	public void draw(Graphics g) {
		drawEnemy1(g);
	}

	private void drawEnemy1(Graphics g) {
		for (Enemy1 e : enemy1s) {
			g.drawImage(enemy1Arr[e.getEnemyState()][e.getAniIndex()], (int) e.getHitbox().getBounds().getX(),
					(int) e.getHitbox().getBounds().getY(), ENEMY1_WIDTH, ENEMY1_HEIGHT, null);
		}
	}

	private void loadEnemyImg() {
		enemy1Arr = new BufferedImage[2][1];
		BufferedImage temp = Load.GetSprite(Load.ENEMY1_SPRITE);
		for (int j = 0; j < enemy1Arr.length; j++) {
			for (int i = 0; i < enemy1Arr[j].length; i++) {
				enemy1Arr[j][i] = temp.getSubimage(i * ENEMY1_WIDTH_DEFAULT, j * ENEMY1_HEIGHT_DEFAULT,
						ENEMY1_WIDTH_DEFAULT, ENEMY1_HEIGHT_DEFAULT);
			}
		}
	}

}
