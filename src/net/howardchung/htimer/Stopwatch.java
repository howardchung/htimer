package net.howardchung.htimer;

public class Stopwatch {

	private long startTime = 0;
	private long stopTime = 0;
	private long savedTime = 0;
	private boolean running = false;
	


	public boolean isRunning() {
		return running;
	}

	public void start() {
		this.startTime = System.currentTimeMillis();
		this.running = true;
	}

	public void stop() {
		this.stopTime = System.currentTimeMillis();
		this.running = false;
		savedTime += (stopTime - startTime);
	}

	// elapsed time in milliseconds
	public long getElapsedTime() {
		long elapsed;
		if (running) {
			elapsed = (System.currentTimeMillis() - startTime);
		} else {
			elapsed = (stopTime - startTime);
		}
		return savedTime + elapsed;
	}

	public void reset() {
		running = false;
		savedTime = 0;
		startTime = 0;
		stopTime = 0;
	}

}
