package w6_1;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.MalformedURLException;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

/*54. Модифицировать лекционный пример SimpleFrameTest.java следующим образом:
	a. При достижении шариком границы окна он должен зеркально отталкиваться и продолжать движении по полю
	b. Нарисовать и анимировать несколько шариков
	import javax.swing.*;
*/
//!! To whom it may concern: balls are small round circles, filled with color
public class Bouncing {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				createGui();
			}
		});
	}
	public static void createGui() {
		SimpleFrame mainFrame= new SimpleFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}
}

class SimpleFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 500; 
	private static final int HEIGHT = 400;
	private static final double RADIUS = 15;
	private static  final double DELTA_X = 0.5;
    private static final double DELTA_Y = 0.5;
    public static final double DELTA_SPEED = 0.1;
	private SimplePanel p;
	private JPanel buttonPanel;
	private JButton butAdd, butDel, butSlow, butFast ;
	
	SimpleFrame() {
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("Bouncing ball");
		
		p = new SimplePanel();
		
		butAdd = new JButton("Add ball");
		butDel = new JButton("Delete ball");
		butSlow = new JButton("Speed -");
		butFast = new JButton("Spreed +");
		
		butDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p.ballList.remove(p.ballList.size()-1);
			}
			
		});
		butAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ball b = new Ball(RADIUS).setSpeed(DELTA_X, DELTA_Y).setBound(WIDTH, HEIGHT);
				//TODO: fix funny collisions on start
				boolean isCollision = false;
				for(Ball bl: p.ballList) {
					if(b.collision(bl)) {
						isCollision = true;
						break;
					}
				}
				if(!isCollision) 
					p.ballList.add(b);
			}
			
		});
		
		butSlow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(Ball b: p.ballList) {
					double sp = b.getSpeed() - DELTA_SPEED;
					b.setSpeed((sp < 0) ? 0 : sp);
				}
			}
		});
		butFast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(Ball b: p.ballList) {
					b.setSpeed(b.getSpeed() + DELTA_SPEED);
				}
			}
		});
		this.add(p, BorderLayout.CENTER);
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		buttonPanel.add(butAdd, c);
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 0;
		buttonPanel.add(butDel, c);
		c.weightx = 1;
		c.gridx = 2;
		c.gridy = 0;
		buttonPanel.add(butSlow, c);
		c.weightx = 1;
		c.gridx = 3;
		c.gridy = 0;
		buttonPanel.add(butFast, c);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
}

class SimplePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final long FRAME_RATE = 10;
	ArrayList<Ball> ballList = new ArrayList<>();
	AudioClip bounceClip = null;
	SimplePanel() {
		try {
			bounceClip = Applet.newAudioClip(new File("BallCollision1.wav").toURI().toURL());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				
				repaint();
			}
		}, 0, FRAME_RATE);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g;
		HashSet<Ball> ballSet = new HashSet<>(ballList);
		for(Ball b : ballList) {
			b.setxMax(this.getWidth());
			b.setyMax(this.getHeight());
			b.move();
			ballSet.remove(b);
			//check for collision with other balls
			//TODO: remove funny collisions on start
			for(Ball bs: ballSet){
				if(b.collision(bs)) {
					(new Thread() {
						@Override
						public void run() {
							bounceClip.play();
						}
					}).start();;
					
					b.setColor(new Color((int)(Math.random() * 0xffffff)));
					bs.setColor(new Color((int)(Math.random() * 0xffffff)));
					b.setDeltaX(-b.getDeltaX());
					b.setDeltaY(-b.getDeltaY());
					b.undoMove();
					bs.setDeltaX(-bs.getDeltaX());
					bs.setDeltaY(-bs.getDeltaY());
					bs.undoMove();
				}
			}
			
			g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2D.setColor(b.getColor());
			g2D.fillOval((int)b.getX(),(int) b.getY(), (int)(b.getRadius() * 2),(int)(b.getRadius() * 2));
		}
	}
	
}
class Ball   {
	private double x, xMax;
	private Color color = Color.black;
	private double y, yMax;
	private double radius;
	private double deltaX, deltaY;
	private double oldX, oldY;
	private double speed = 1;
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getOldX() {
		return oldX;
	}
	public void setOldX(double oldX) {
		this.oldX = oldX;
	}
	public double getOldY() {
		return oldY;
	}
	public void setOldY(double oldY) {
		this.oldY = oldY;
	}
	
	Ball(double r) {
		this.radius = r;
	}
	Ball setBound(double x, double y) {
		xMax = x;
		yMax = y;
		return this;
	}
	Ball setSpeed(double deltaX, double deltaY) {
		setDeltaX(deltaX);
		setDeltaY(deltaY);
		return this;
	}
	public void setxMax(double xMax) {
		this.xMax = xMax;
	}
	public void setyMax(double yMax) {
		this.yMax = yMax;
	}
	public void setDeltaX(double deltaX) {
		this.deltaX = deltaX;
	}
	public void setDeltaY(double deltaY) {
		this.deltaY = deltaY;
	}
	public boolean collision(Ball b) {
		boolean result = false;
		double x1, x2, y1, y2; //centers of circles
		double r1, r2;
		r1 = this.getRadius();
		r2 = b.getRadius();
		x1 = this.x + r1;
		y1 = this.y + r1;
		x2 = b.x + r2;
		y2 = b.y + r2;
		
		if(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) < 
				(b.getRadius() + this.getRadius())) 
			result = true;
		return result;
	}
	public void undoMove() {
		this.setX(oldX);
		this.setY(oldY);
	}
	//TODO: add collision  mass dependency
	public void move() {
		
		double x = this.x + getDeltaX() * this.speed;
		if(x < radius) {
			this.setDeltaX(-this.getDeltaX());
			x = radius;
		} else if((x + getDeltaX() + radius) > xMax) {
			this.setDeltaX(-this.getDeltaX());
			x = xMax - radius;
		}
		double y = this.y + getDeltaY() * this.speed;
		if(y < radius) {
			this.setDeltaY(-this.getDeltaY());
			y = radius;
		} else if((y + getDeltaY() + radius) > yMax) {
			this.setDeltaY(-this.getDeltaY());
			y = yMax - radius;
		}
		this.setOldX(this.x);
		this.setOldY(this.y);
		this.y = y;
		this.x = x;
	}
	double getRadius() {
		return this.radius;
	}
	double getXMax() {
		return xMax;
	}
	double getYMax() {
		return yMax;
	}
	double getDeltaX() {
		return deltaX;
	}
	double getDeltaY() {
		return deltaY;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}