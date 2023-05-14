package com.leetcode.rover;

import java.util.ArrayList;
import java.util.List;

public class CommandReceiver {

	private String commands; // 5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM
	private int[] plateau;
	private int start = 0;

	public CommandReceiver(String input) {
		this.commands = input;
		this.createPlateau();
	}

	public int[] getPlateau() {
		return plateau;
	}

	public void createPlateau() {
		int x = Integer.parseInt("" + commands.charAt(0));
		int y = Integer.parseInt("" + commands.charAt(2));
		start = 4;
		this.plateau = new int[] { x, y };
	}

	public List<Command> createCommand() throws Exception {

		List<Command> cmdList = new ArrayList<Command>();
		int commandlength = commands.indexOf(" ", start + 6);
		while (commandlength >= 0) {
			String command = commands.substring(start, commandlength);
			System.out.println(command);
			cmdList.add(new Command(command, plateau));
			start = commandlength + 1;
			commandlength = commands.indexOf(" ", start + 6);
		}
		if (start < commands.length()) {
			System.out.println(commands.substring(start));
			cmdList.add(new Command(commands.substring(start), plateau));
		}
		cmdList.stream().forEach(System.out::println);
		return cmdList;
	}

}
