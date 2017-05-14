import javax.swing.JFrame;

public class LeagueInvaders {
	 final static int bheight = 800;
	final static int bwidth = 500;
	JFrame scen;
	GamePanel pan;

	public static void main(String[] args) {
		LeagueInvaders object = new LeagueInvaders();
	}

	LeagueInvaders() {
		
		scen = new JFrame();
		pan = new GamePanel();
	      
		setup();
		
	}

	void setup() {
		scen.add(pan);
		scen.addKeyListener(pan);
		scen.setVisible(true);
		scen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scen.setSize(500,800);
		pan.startGame();
	}
}
