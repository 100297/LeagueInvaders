import javax.swing.JFrame;

public class LeagueInvaders {
	final int bheight;
	final int bwidth;
	JFrame scen;
	GamePanel pan;

	public static void main(String[] args) {
		LeagueInvaders object = new LeagueInvaders();
	}

	LeagueInvaders() {
		bheight = 800;
		bwidth = 500;
		scen = new JFrame();
		setup();
		pan = new GamePanel();
	}

	void setup() {
		scen.setVisible(true);
		scen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
