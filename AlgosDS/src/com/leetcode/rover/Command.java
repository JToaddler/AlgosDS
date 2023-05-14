package com.leetcode.rover;

import java.util.Arrays;

public class Command {

	private int[] initPosition = new int[2];
	private char orientation;
	private String commands;

	public Command(String instruction, int[] plateau) throws Exception {
		// 1 2 N LMLMLMLMM
		initPosition[0] = Integer.valueOf("" + instruction.charAt(0));
		initPosition[1] = Integer.valueOf("" + instruction.charAt(2));
		this.orientation = instruction.charAt(4);
		commands = instruction.substring(6, instruction.length());
		validate(plateau, orientation, plateau);
	}

	public int[] getIntiPosition() {
		return this.initPosition;
	}

	public char getOrientation() {
		return this.orientation;
	}

	public String getCommands() {
		return this.commands;
	}

	public void validate(int[] initPosition, char orientation, int[] plateau) throws Exception {
		if (initPosition[0] > plateau[0] || initPosition[1] > plateau[1] || initPosition[0] < 0
				|| initPosition[0] < 0) {
			throw new Exception("Robot's coordinates can't be negative or outside of Plateau ");
		}
		if (plateau[0] < 0 || plateau[1] < 0) {
			throw new Exception("Plateau coordinates can't be negative");
		}
		switch (this.orientation) {
		case 'N':
		case 'E':
		case 'S':
		case 'W':
			break;
		default:
			throw new Exception("Robots orientation is not correct. Not in N E  S W");
		}

	}

	@Override
	public String toString() {
		return "Command [initPosition=" + Arrays.toString(initPosition) + ", orientation=" + orientation + ", commands="
				+ commands + "]";
	}
}