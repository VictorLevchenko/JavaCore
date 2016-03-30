package w6_1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.*;

import javax.swing.*;

/*54. Модифицировать лекционный пример SimpleFrameTest.java следующим образом:
	a. При достижении шариком границы окна он должен зеркально отталкиваться и продолжать движении по полю
	b. Нарисовать и анимировать несколько шариков
	import javax.swing.*;
*/
public class SimpleFrameTest {

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
	private static  final double DELTA_X = 1.0;
    private static final double DELTA_Y = 1.0;
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
		
		//TODO: Not work correctly butSlow, butFast
		butSlow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(Ball b: p.ballList) {
					double dx = b.getDeltaX();
					if(dx >= DELTA_X) dx -= DELTA_X;
					double dy = b.getDeltaY();
					if(dy >= DELTA_Y) dy -= DELTA_Y;
					b.setSpeed(dx, dy);
				}
					
			}
			
		});
		butFast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(Ball b: p.ballList) {
					b.setSpeed(b.getDeltaX() + DELTA_X
							, b.getDeltaY() + DELTA_Y);
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
		for(Ball b : ballList) {
			b.setxMax(this.getWidth());
			b.setyMax(this.getHeight());
			g.fillOval((int)b.getCurrentX(),(int) b.getCurrentY(), (int)b.getRadius(),(int) b.getRadius());
		}
	}
	
}
class Ball  {
	private double x, xMax;
	private double y, yMax;
	private double radius;
	private double deltaX, deltaY;
	Ball(double r) {
		this.radius = r;
	}
	Ball setBound(int x, int y) {
		xMax = x;
		yMax = y;
		return this;
	}
	Ball setSpeed(double deltaX, double deltaY) {
		this.deltaX = deltaX;
		this.deltaY = deltaY;
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
	double getCurrentX() {
		double x = this.x - deltaX;
		if(x < radius) {
			deltaX = - deltaX;
			x = radius;
		} else if((x +deltaX + radius) > xMax) {
			deltaX = - deltaX;
			x = xMax - radius;
		}
		this.x = x;
		return x;
	}
	double getCurrentY() {
		double y = this.y - deltaY;
		if(y < radius) {
			deltaY = - deltaY;
			y = radius;
		} else if((y + deltaY + radius) > yMax) {
			deltaY = - deltaY;
			y = yMax - radius;
		}
		this.y = y;
		return y;
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
}