import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class quadtree {

	
	int qx;
	int qy;
	int qh;
	int qw;
	int limit;
	
	rect size;
	
	quadtree northeast;
	quadtree northwest;
	quadtree southeast;
	quadtree southwest;
	
	particle particle;
	ArrayList<particle> particleCount = new ArrayList();
	
	boolean isDivided = false;
	
	public quadtree (rect _size , int _limit) {
		limit = _limit;
		size = _size;
		this.qx = size.x;
		this.qy = size.y;
		this.qh = size.h;
		this.qw = size.w;
	}
	
	
	public void divide () {
		
		rect ne = new rect(this.qx + this.qw/2, this.qy, this.qw/2, this.qh/2);
		northeast = new quadtree(ne, limit);
		
		rect nw = new rect(this.qx, this.qy, this.qw/2, this.qh/2);
		northwest = new quadtree(nw, limit);
		
		rect se = new rect(this.qx + this.qw/2, this.qy + this.qh/2, this.qw/2, this.qh/2);
		southeast = new quadtree(se, limit);
		
		rect sw = new rect(this.qx, this.qy + this.qy/2, this.qw/2, this.qh/2);
		southwest = new quadtree(sw, limit);
		
		this.isDivided = true;
		
	}
	

	public void addParticle (particle particle) {
		
		if(!this.size.locate(particle)) {
			return;
		}
		
		if(this.particleCount.size() < this.limit) {
			this.particleCount.add(particle);
		} else {
			if (!this.isDivided) {
				this.divide();				
			}			
			northeast.addParticle(particle);
			northwest.addParticle(particle);
			southeast.addParticle(particle);
			southwest.addParticle(particle);
		}		
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		g2d.drawRect(this.qx, this.qy, this.qw, this.qh);

		if(this.isDivided) {
			northeast.draw(g);
			northwest.draw(g);
			southeast.draw(g);
			southwest.draw(g);
		}
	}
	
}
