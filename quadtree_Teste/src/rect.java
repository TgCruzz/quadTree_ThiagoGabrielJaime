
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
		return(particle.x > this.x && particle.x < this.x + this.w 
			&& particle.y > this.y && particle.y < this.y + this.h);
		
	}
	
}
