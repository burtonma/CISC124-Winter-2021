package ca.queensu.cs.cisc124.notes.basics.geometry;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import princeton.introcs.StdDraw;

public class BouncingBall implements ActionListener {

	static {
		StdDraw.setCanvasSize(20 * 40, 20 * 40);
		StdDraw.setXscale(0.0, 20.0);
		StdDraw.setYscale(0.0, 20.0);
		Color c = new Color(0, 0, 255, 128);
		StdDraw.setPenColor(c);
	}

	private Timer timer;
	private Projectile ball;
	private final double radius = 1.0;
	private static final double X_LEFT = 0.0;
	private static final double X_RIGHT = 20.0;

	public BouncingBall() {
		this.timer = new Timer(30, this);
		this.ball = new Projectile();
		Point2 p = new Point2();
		p.set(10.0, 15.0);
		this.ball.setPosition(p);
		
		Vector2 v = new Vector2();
		v.set(2.3, 0.0);
		this.ball.setVelocity(v);
	}

	private void drawBall() {
		double x = this.ball.getPosition().x();
		double y = this.ball.getPosition().y();
		StdDraw.filledCircle(x, y, this.radius);
	}

	public void run() {
		this.timer.start();

		while (true) {
			StdDraw.show(0);
			StdDraw.clear();
			this.drawBall();
			StdDraw.show(0);
			if (StdDraw.hasNextKeyTyped()) {
				char c = StdDraw.nextKeyTyped();
				if (c == 'q') {
					this.timer.stop();
					break;
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.ball.move(0.1);
		if (this.ball.getPosition().y() <= 0.0) {
			Vector2 v = this.ball.getVelocity();
			v.y(-v.y());
			this.ball.setVelocity(v);
		}
		if (this.ball.getPosition().x() <= BouncingBall.X_LEFT
				|| this.ball.getPosition().x() >= BouncingBall.X_RIGHT) {
			Vector2 v = this.ball.getVelocity();
			v.x(-v.x());
			this.ball.setVelocity(v);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BouncingBall test = new BouncingBall();
		test.run();
		StdDraw.close();
	}

}
