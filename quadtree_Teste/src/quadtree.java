import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class quadtree {
	
	int limit;
	
	rect size;
	
	quadtree northeast;
	quadtree northwest;
	quadtree southeast;
	quadtree southwest;
	
	particle particle;
	
	ArrayList<particle> particleCount = new ArrayList();
	
	boolean isDivided;
	
	public quadtree (rect _size , int _limit) {
		this.isDivided = false;
		
		this.limit = _limit;
		this.size = _size;	
	}
	
	
	public void divide () {
		
		int qx = size.x;
		int qy = size.y;
		int qh = size.h;
		int qw = size.w;
		
		rect ne = new rect(qx + qw/2, qy, qw/2, qh/2);
		rect nw = new rect(qx, qy, qw/2, qh/2);	
		rect se = new rect(qx + qw/2, qy + qh/2, qw/2, qh/2);
		rect sw = new rect(qx, qy + qh/2, qw/2, qh/2);
		
		this.northeast = new quadtree(ne, limit);
		this.northwest = new quadtree(nw, limit);
		this.southeast = new quadtree(se, limit);
		this.southwest = new quadtree(sw, limit);
		
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
			this.northeast.addParticle(particle);
			this.northwest.addParticle(particle);
			this.southeast.addParticle(particle);
			this.southwest.addParticle(particle);
		}		
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		g2d.drawRect(this.size.x, this.size.y, this.size.w, this.size.h);

		if(this.isDivided) {
			this.northeast.draw(g);
			this.northwest.draw(g);
			this.southeast.draw(g);
			this.southwest.draw(g);
		}
	}
	
}
