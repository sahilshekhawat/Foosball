package foosball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;




@SuppressWarnings("serial")
public class BouncingBall extends JFrame{
	private ImageIcon field;
	private MyPanel panel;
	private ArrayList<Ball> Balls=new ArrayList<Ball>();
	private JTextField message;

	public BouncingBall(){
		super("BouncingBalls");
		//field = new ImageIcon("foosball.png");
		add(panel, BorderLayout.NORTH);

		message=new JTextField();
		message.setEditable(false);
		add(message, BorderLayout.SOUTH);

		setSize(450, 450);
		setVisible(true);

	} 


	private class Ball extends Thread{
		private Ellipse2D.Double ball;
		private boolean isMoving;
		private int size, speed;             
		private int dx, dy;          
		private Color color;
		
		public Ball(){
			isMoving = true;   
			size= 50;
			speed=20 + (int)(Math.random()*100);
			int startx=(int)(Math.random()*350);
			int starty=(int)(Math.random()*335);
			dx=-10 + (int)(Math.random()*21);
			dy=-10 + (int)(Math.random()*21);
			if(dx==0 && dy==0)  
				dy=1;
			ball=new Ellipse2D.Double(startx, starty, size, size);
			Random rand = new Random();
			color=new Color(rand.nextFloat(),rand.nextFloat(), rand.nextFloat());
		}


		public void draw(Graphics2D g2d){
			if (ball!= null){
				g2d.setColor(color.BLACK);
				g2d.fill(ball);
			}
		}

		public void run(){
			while(isMoving){
				try {
					Thread.sleep(speed);
				}
				catch (InterruptedException e){
					e.printStackTrace();}

				// calculate new position and move ball
				int oldx=(int) ball.getX();
				int oldy=(int) ball.getY();
				int newx=oldx + dx;
				if(newx+size>panel.getWidth()||newx<0) 
					dx=-dx;
				int newy=oldy+dy;
				if(newy+size>panel.getHeight()||newy<0) 
					dy=-dy;            
				ball.setFrame(newx, newy, size, size);
				panel.repaint();
			}
		}
	}


	private class MyPanel extends JPanel  {
		private int width, height;

		public MyPanel (int width, int height){
			this.width = width;
			this.height = height;

			// adding ball on mouse click
			addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					Ball nextBall = new Ball();
					Balls.add(nextBall);
					nextBall.start();
				}
			});
		}

		public Dimension getPreferredSize(){
			return new Dimension(width, height);
		}

		public void paintComponent (Graphics g){
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D)g;
			for (int i=0;i< 1;i++){ 
				(Balls.get(i)).draw(g2d);
			}
		}
	}
} 
