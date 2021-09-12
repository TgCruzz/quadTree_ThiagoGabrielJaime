import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class screen extends JFrame {

   ArrayList<particle> particles = new ArrayList();
   int particleCount = 100;
   int screenSize = 1000;
	
	public screen () {
		for(int i = 0; i < particleCount; i++) {
			particles.add(new particle(screenSize, screenSize));
		}
		setSize (screenSize,screenSize);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void paint (Graphics g) {
		for(int i = 0; i < particleCount; i++) {
			particles.get(i).draw(g);
		}
	}
	
	public static void main(String args[]) {
		
		new screen();
	}
	
}
