package com.leetcode.rover;

import java.util.List;

/**
 * 
 * https://github.com/AlbertSuarez/mars-rover
 * 
 * 
 * @author Anto
 *
 */
class RoverMarsMain {

	public static void main(String[] args) throws Exception {

		String input = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
		// String input = "5 5 3 3 E MMRMMRMRRM";

		CommandReceiver receiver = new CommandReceiver(input);
		int[] plateau = receiver.getPlateau();
		List<Command> cmdList = receiver.createCommand();

		for (Command cmd : cmdList) {
			BotController bc = new BotController(cmd, plateau);
			bc.operateBots();
		}
	}

}

class Test {
	public static void main(String[] args) throws Exception {

	}
}