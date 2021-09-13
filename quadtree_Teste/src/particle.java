import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class particle  {

	Random random = new Random();
	
		int x;
		int y;
		int h = 6;
		int w = 6;
		int speedX;
		int speedY;
	
	public particle (int _x, int _y) {
		
		this.x = random.nextInt(_x);
		this.y = random.nextInt(_y);
		
		while (speedX == 0 && speedY == 0) {
		this.speedX = random.nextInt(3)-1;
		this.speedY = random.nextInt(3)-1;		
		}
	}
	
	public void Update () {
		
		this.x += this.speedX;
		this.y += this.speedY;
		
		if (this.x >= 1000 || this.x <= 31) {
			this.speedX *= -1;
		}
		if (this.y >= 1000 || this.y <= 31) {
			this.speedY *= -1;
		}	
		
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		g2d.fillOval(this.x - w/2, this.y - h/2, h, w);
	}
	
	
}
