package com.leetcode.rover;

public class Robot {

	private int x;
	private int y;
	private char orientation;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getOrientation() {
		return orientation;
	}

	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}

	@Override
	public String toString() {
		return "Robot [x=" + x + ", y=" + y + ", orientation=" + orientation + "]";
	}

}
