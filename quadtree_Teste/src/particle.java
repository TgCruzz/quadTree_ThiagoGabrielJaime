import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class particle  {

	Random random = new Random();
	
	int x;
	int y;
	int h = 10;
	int w = 10;
	
	public particle (int _x, int _y) {
		
		this.x = random.nextInt(_x);
		this.y = random.nextInt(_y);
		
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.fillOval(this.x - w/2, this.y - h/2, h, w);
	}
	
	
}
