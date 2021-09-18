import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class particle  {

	Random random = new Random();
	
		screen screen;
		int x;
		int y;
		int h = 4;
		int w = 4;
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
		
		if (this.x >= screen.screenSize || this.x <= screen.screenSize - screen.screenSize) {
			this.speedX *= -1;
		}
		if (this.y >= screen.screenSize || this.y <= screen.screenSize - screen.screenSize) {
			this.speedY *= -1;
		}				
		
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.cyan);
		g2d.fillOval(this.x - w/2, this.y - h/2, h, w);
	}
	
	
}
