import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;
	Rocketship() {
		super(); 
		x = 250;
		 y = 700;
	 width = 50;
	 height = 50;
	speed = 25;
	}

	void update() {
		super.update();
	}

	void draw(Graphics g) {
g.setColor(Color.BLUE);
g.drawImage(GamePanel.rocketImg, x, y, width, height, null);

	}
}
