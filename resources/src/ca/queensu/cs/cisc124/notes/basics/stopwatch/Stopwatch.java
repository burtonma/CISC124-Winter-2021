package lectures.basics.stopwatch;

/**
 * A simple stopwatch for recording elapsed time.
 *
 */
public class Stopwatch { 

	/**
	 * Raw time (from nanoTime) when the stopwatch is started
	 */
	private long rawStartTime;

	/**
	 * Raw time (from nanoTime) when the stopwatch is stopped
	 */
	private long rawStopTime;

	/**
	 * True if stopwatch is started and not stopped, false
	 * otherwise
	 */
	private boolean isRunning;

	/**
	 * Number of nanoseconds in one second
	 */
	private final static double BILLION = 1e9;

	/**
	 * Initializes this stopwatch so that the elapsed time is zero seconds.
	 */
	public Stopwatch() {
		this.rawStartTime = 0L;
		this.rawStopTime = 0L;
		this.isRunning = false;
	}

	/**
	 * Starts this stopwatch running. Does nothing if this stopwatch is already
	 * running.
	 * 
	 */
	public void start() {
		if (!this.isRunning) {
			this.rawStartTime = System.nanoTime();
			this.isRunning = true;
		}
	}

	/**
	 * Stops this stopwatch and returns the elapsed time in seconds since the
	 * watch was started. If the stopwatch is already stopped then the elapsed
	 * time in seconds (as computed by {@code elapsed}) is returned.
	 * 
	 * @return the elapsed time in seconds
	 */
	public double stop() {
		if (this.isRunning) {
			this.rawStopTime = System.nanoTime();
			this.isRunning = false;
		}
		return this.elapsed();
	}

	/**
	 * For a running stopwatch, this method returns the total amount of time
	 * in seconds that have elapsed since the stopwatch was started.
	 * 
	 * <p>
	 * For a stopped stopwatch, this method returns the total amount of time
	 * in seconds that elapsed between starting and stopping the stopwatch.
	 * 
	 * @return the elapsed time recorded by this stopwatch
	 */
	public double elapsed() {
		long currentTime = System.nanoTime();
		if (!this.isRunning) {
			currentTime = this.rawStopTime;
		}
		return (0.0 + currentTime - this.rawStartTime) / BILLION;
	}
	
	
	/**
	 * Simulates a method that does something for approximately the
	 * specified number of milliseconds.
	 * 
	 * @param milliseconds 
	 *           the approximate amount of time this method runs for
	 */
	public static void doSomething(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		}
		catch (InterruptedException x) {
		}
	}
	
	public static void main(String[] args) {
		Stopwatch w = new Stopwatch();
		w.start();
		doSomething(2500);
		w.stop();
		System.out.println(w.elapsed() + " seconds elapsed");
		
		w.start();
		doSomething(1200);
		doSomething(1700);
		w.stop();
		System.out.println(w.elapsed() + " seconds elapsed");
	}
	
}

