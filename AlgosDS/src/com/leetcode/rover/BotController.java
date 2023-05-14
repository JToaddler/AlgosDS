package com.leetcode.rover;

public class BotController {

	Command commands;
	Robot bot;
	int[] plateau;

	public BotController(Command inst, int[] plateau) {
		this.commands = inst;
		this.plateau = plateau;
		this.bot = new Robot();
	}

	public void operateBots() throws Exception {

		this.deployBot(bot, commands);
		this.followCommands();
	}

	public void followCommands() throws Exception {

		for (char inst : commands.getCommands().toCharArray()) {

			switch (inst) {
			case 'L':
				rotateLeft();
				break;
			case 'R':
				rotateRight();
				break;
			case 'M':
				if (canMove()) {
					move(bot);
				}
				break;
			default:
				System.out.println("Received Invalid command : last know position of bot" + bot);
				throw new Exception("Invalid instruction found :" + inst);
			}
		}
		System.out.println("Exploration complete! last know position of bot" + bot);
	}

	public void rotateLeft() {
		if (this.bot.getOrientation() == 'N') {
			this.bot.setOrientation('W');
		} else if (this.bot.getOrientation() == 'E') {
			this.bot.setOrientation('N');
		} else if (this.bot.getOrientation() == 'W') {
			this.bot.setOrientation('S');
		} else if (this.bot.getOrientation() == 'S') {
			this.bot.setOrientation('E');
		}
	}

	public void rotateRight() {
		if (this.bot.getOrientation() == 'N') {
			this.bot.setOrientation('E');
		} else if (this.bot.getOrientation() == 'E') {
			this.bot.setOrientation('S');
		} else if (this.bot.getOrientation() == 'W') {
			this.bot.setOrientation('N');
		} else if (this.bot.getOrientation() == 'S') {
			this.bot.setOrientation('W');
		}
	}

	public boolean canMove() {
		if ((bot.getOrientation() == 'E' && plateau[0] == bot.getX())
				|| (0 == bot.getX() && bot.getOrientation() == 'W')) {
			return false;
		}
		if ((bot.getOrientation() == 'N' && plateau[1] == bot.getY())
				|| (0 == bot.getY() && bot.getOrientation() == 'S')) {
			return false;
		}
		return true;
	}

	public void move(Robot bot) {

		switch (bot.getOrientation()) {
		case 'N':
			bot.setY(bot.getY() + 1);
			break;
		case 'E':
			bot.setX(bot.getX() + 1);
			break;
		case 'S':
			bot.setY(bot.getY() - 1);
			break;
		case 'W':
			bot.setX(bot.getX() - 1);
			break;
		}

	}

	public void deployBot(Robot bot, Command cmd) {

		bot.setOrientation(cmd.getOrientation());
		bot.setX(cmd.getIntiPosition()[0]);
		bot.setY(cmd.getIntiPosition()[1]);

	}

}
