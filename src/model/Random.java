package model;

public class Random {

	private int min;
	private int max;
	
	public Random(int min, int max) {
		this.min=min;
		this.max=max;
	}
	
	public int getRandom() {
		return (int) Math.floor(Math.random()*(max-min+1)+min);
	}
}
