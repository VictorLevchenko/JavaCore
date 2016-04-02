package w6_1;

import java.awt.*;
import java.awt.event.*;
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
	private SimplePanel p;
	private JPanel buttonPanel;
	private JButton butAdd, butDel, butSlow, butFast ;
	private static final int WIDTH = 500; 
	private static final int HEIGHT = 400;
	private static final double RADIUS = 15;
	private static  final double DELTA_X = 0.5;
    private static final double DELTA_Y = 0.5;
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
				p.ballList.add(b);
			}
			
		});
		
		butSlow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(Ball b: p.ballList) {
					double sp = b.getSpeed() - Ball.DELTA_SPEED;
					b.setSpeed((sp < 0) ? 0 : sp);
				}
			}
		});
		butFast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(Ball b: p.ballList) {
					b.setSpeed(b.getSpeed() + Ball.DELTA_SPEED);
				}
			}
		});
		this.add(p, BorderLayout.CENTER);
		buttonPanel = new JPanel();
		buttonPanel.add(butAdd);
		buttonPanel.add(butDel);
		buttonPanel.add(butSlow);
		buttonPanel.add(butFast);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
}

class SimplePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	ArrayList<Ball> ballList = new ArrayList<>();
	SimplePanel() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				
				repaint();
			}
		}, 0, 10);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g;
		HashSet<Ball> ballSet = new HashSet<>(ballList);
		for(Ball b : ballList) {
			b.move();
			ballSet.remove(b);
			//check for collision with other balls
			//TODO: remove funny collisions
			for(Ball bs: ballSet){
				if(b.collision(bs)) {
						b.setDeltaX(-b.getDeltaX());
						b.setDeltaY(-b.getDeltaY());
						bs.setDeltaX(-bs.getDeltaX());
						bs.setDeltaY(-bs.getDeltaY());
					b.setColor(new Color((int)(Math.random() * 0x1000000)));
					bs.setColor(new Color((int)(Math.random() * 0x1000000)));
					
				}
			}
			
			b.setxMax(this.getWidth());
			b.setyMax(this.getHeight());
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
	private double y, yMax;
	private double radius;
	private double deltaX, deltaY;
	private double speed = 1;
	public static final double DELTA_SPEED = 0.1;
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
	public void move() {
		
		double x = this.x + getDeltaX() * this.speed;
		if(x < radius) {
			this.setDeltaX(-this.getDeltaX());
			x = radius;
		} else if((x +getDeltaX() + radius) > xMax) {
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