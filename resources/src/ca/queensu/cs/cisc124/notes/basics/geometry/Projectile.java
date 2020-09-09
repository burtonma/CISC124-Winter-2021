package ca.queensu.cs.cisc124.notes.basics.geometry;


/**
 * A particle moving with approximate projectile motion in two 
 * dimensions. It is assumed that the only force acting on 
 * the projectile is gravity.
 * 
 */
public class Projectile {

	/**
	 * The current position of the projectile.
	 */
	private Point2 pos;
	
	/**
	 * The current velocity of the projectile.
	 */
	private Vector2 vel;
	
	/**
	 * Initialize this projectile to start.
	 *  
	 */
	public Projectile() {
		this.pos = new Point2();
		this.vel = new Vector2();
	}
	
	/**
	 * Returns a reference to the position of this projectile.
	 * 
	 * @return a reference to the position of this projectile
	 */
	public Point2 getPosition() {
		return this.pos;
	}
	
	/**
	 * Returns a reference to the velocity of this projectile.
	 * 
	 * @return a reference to the velocity of this projectile
	 */
	public Vector2 getVelocity() {
		return this.vel;
	}
	
	/**
	 * Set the position of this projectile to the specified position.
	 * Returns the old position of this projectile.
	 * 
	 * @param p the new position of this projectile
	 * @return the old position of this projectile
	 */
	public Point2 setPosition(Point2 p) {
		Point2 oldPos = this.pos;
		this.pos = p;
		return oldPos;
	}
	
	/**
	 * Set the position of this projectile to the specified velocity.
	 * Returns the old velocity of this projectile.
	 * 
	 * @param p the new velocity of this projectile
	 * @return the old velocity of this projectile
	 */
	public Vector2 setVelocity(Vector2 v) {
		Vector2 oldVel = this.vel;
		this.vel = v;
		return oldVel;
	}
	
	/**
	 * Updates the position and velocity of this projectile after
	 * the projectile has moved {@code dt} seconds from its previous
	 * position.
	 * 
	 * @param dt the time period over which the projectile has moved
	 */
	public void move(double dt) {
		// acceleration due to gravity
		Vector2 g = new Vector2();
		g.set(0.0, -9.81);
		
		this.pos.add(Vector2.multiply(dt, this.vel)).
				 add(Vector2.multiply(0.5 * dt * dt, g));
		this.vel.add(Vector2.multiply(dt, g));
	}
	
	public static void main(String[] args) {
		Projectile p = new Projectile();
		Vector2 v = new Vector2();
		v.set(1, 10);
		p.setVelocity(v);
		for (int i = 0; i < 100; i++) {
			System.out.println(p.getPosition());
			p.move(0.1);
		}
	}
}
