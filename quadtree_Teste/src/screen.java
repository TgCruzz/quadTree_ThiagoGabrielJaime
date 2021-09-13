import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		ActionListener loop = new ActionListener() 
		{
		    public void actionPerformed(ActionEvent ev)
		    {   
		    	for(particle part : particles) {
		    		part.Update();
		    	}
		       repaint();		    	
		    }
		};  
		new Timer(1, loop).start();
	}
	
	
	@Override
	public void paint (Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, 0, screenSize, screenSize);
		for(int i = 0; i < particleCount; i++) {
			particles.get(i).draw(g);
		}
	}
	
	
	public static void main(String args[]) {
		
		new screen();
	}
	
}
