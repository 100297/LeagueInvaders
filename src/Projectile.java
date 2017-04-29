import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	int speed;
	
	Projectile() {
		width = 10;
		height = 10;
		x = 250;
		y = 700;		
		speed = 10;
	}
	Projectile(int x, int y, int width, int height) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		speed = 10;
	}
	void update() {
		y = y - speed;
		if(y < 0) {
			isAlive = false;
		}
				
	}

	void draw(Graphics g) {
g.setColor(Color.RED);
g.fillRect(x, y, width, height);

	}
}
