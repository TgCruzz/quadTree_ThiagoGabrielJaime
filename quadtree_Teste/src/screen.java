import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.ArrayList;

public class screen extends JFrame { 
	
   ArrayList<particle> particles = new ArrayList();
   int particleTotal = 50;
   
   int screenSize = 1000;
   private Image bufferImg;
   private Graphics dBuffer;
   
   rect size = new rect( screenSize - screenSize, screenSize - screenSize, screenSize, screenSize);
   quadtree quadTree = new quadtree(size, 4);
   
	public screen () {
		for(int i = 0; i < particleTotal; i++) {
			particles.add(new particle(screenSize, screenSize));
		}
		
		for(particle part : particles) {
			quadTree.addParticle(part);
		}
		
		setSize (screenSize,screenSize);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		ActionListener loop = new ActionListener()   
		{
		    public void actionPerformed(ActionEvent event)
		    {   
		    	for(particle part : particles) {
		    		//part.Update(screenSize, part);	
		    	}		    	
		    }
		};  
		new Timer(1, loop).start();
	}
	
	
	public void paint(Graphics g) {
		bufferImg = createImage (getWidth(), getHeight());
		dBuffer = bufferImg.getGraphics();
		paintComponent(dBuffer);
		g.drawImage(bufferImg, 0, 0, this);
	}
	
	public void paintComponent (Graphics g) {
		
		g.setColor(Color.gray);
		g.fillRect(screenSize - screenSize, screenSize - screenSize, screenSize, screenSize);
		
		for(int i = 0; i < particleTotal; i++) {
			particles.get(i).draw(g);
			
		}
		quadTree.draw(g);
		
	    repaint();
	}
	
	
	public static void main(String args[]) {
		
		new screen();
	}
	
}
