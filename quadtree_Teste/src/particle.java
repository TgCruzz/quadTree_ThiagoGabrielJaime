import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class particle  {

	Random random = new Random();

		int x;
		int y;
		int h = 4;
		int w = 4;
		int speedX;
		int speedY;
		int border;
	
	public particle (int _x, int _y) {
		
		this.x = random.nextInt(_x);
		this.y = random.nextInt(_y);
		
		while (speedX == 0 && speedY == 0) {
		this.speedX = random.nextInt(3)-1;
		this.speedY = random.nextInt(3)-1;		
		}
	}
	
	public void Update (int _border, particle particle) {
		
		border = _border;
		this.x += this.speedX;
		this.y += this.speedY;
		
		if (this.x >= border || this.x <= border - border) {
			this.speedX *= -1;
		}
		if (this.y >= border || this.y <= border - border) {
			this.speedY *= -1;
		}	
		
		if((this.x <= particle.x + particle.w && this.x + this.w >= particle.x + particle.w) ||
		   (this.x + this.w >= particle.x && this.x + this.w <= particle.x + particle.w)) {
			this.speedX *= -1;
			particle.speedX *= -1;
		}
		
		if((this.y <= particle.y + particle.h && this.y + this.h >= particle.y + particle.h) ||
		   (this.y + this.h >= particle.x && this.y + this.h <= particle.y + particle.h)) {
			this.speedY *= -1;
			particle.speedY *= -1;
		}
		
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.cyan);
		g2d.fillOval(this.x - w/2, this.y - h/2, h, w);
	}
	
	
}
