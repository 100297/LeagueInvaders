import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;
	Rocketship() {
		 x = 250;
		 y = 700;
	 width = 50;
	 height = 50;
	speed = 15;
	}

	void update() {

	}

	void draw(Graphics g) {
g.setColor(Color.BLUE);
g.fillRect(x, y, width, height);

	}
}
