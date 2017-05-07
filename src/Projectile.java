import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	int speed;
	int direction;
	Projectile() {
		width = 10;
		height = 10;
		x = 250;
		y = 700;		
		speed = 10;
	}
	Projectile(int x, int y, int width, int height,int direction) {
		super();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		speed = 10;
		this.direction = direction;
	}
	void update() {
		super.update(); 
		
		if (direction == 1) {
			y = y - speed;
		} else if (direction == 2) {
			y = y - speed;
			x = x - speed;
		} else if (direction == 3) {
			y = y - speed;
			x = x - speed;
		}
		if(y < 0) {
			isAlive = false;
		}
				
	}

	void draw(Graphics g) {
g.setColor(Color.RED);
g.drawImage(GamePanel.bulletImg, x, y, width, height, null);

	}
}
