
public class rect {

	int x;
	int y;
	int h;
	int w;
	particle particle;
	
	public rect (int _x, int _y, int _h, int _w) {
		x = _x;
		y = _y;
		h = _h;
		w = _w;
	}
	
	public boolean locate (particle particle) {
		return(particle.x - particle.w/2 > this.x && particle.x - particle.w/2 < this.x + this.w 
			&& particle.y - particle.h/2 > this.y && particle.y - particle.h/2 < this.y + this.h);
		
	}
	
}
