package com.leetcode.rover;

/*

//Phase 1:
//We’re working on a robotic vacuum cleaner, a small machine designed to navigate around a house cleaning floors. We call our model EVA (Electronic Vacuum Assistant). We are tasked with writing the software to control it. It’s up to you to build a system to represent EVA that will evolve in complexity over time.

//A limited set of commands can be sent to EVA as single letters telling the robot how to move; “F” and “B” would tell EVA to move one position forwards or one position backwards. “L” and “R” would tell EVA to move one position left or one position right. Create a function to take a move command (F, B, L, R), process the move command appropriately, and report the new position.

//Sample interaction:
//eva_move(‘B’) #=> (0, -1)
//eva_move(‘B’) #=> (0, -2)
//eva_move(‘L’) #=> (-1, -2)
//eva_move(‘R’) #=> (0, -2)

//Phase 2:
//Now that EVA is moving around, we are going to introduce a few new concepts; Walls, Obstacles, and Chargers.

//- Walls (w) define the absolute edges of the available space. Our rectangular room will be expressed as four integers, each representing the maximum / minimum coordinate in that direction.
//- Obstacles (x) represent coordinates which EVA cannot occupy, such as table legs, shoe racks, or kitchen islands. Each obstacle will fully occupy a single coordinate, and will be represented as a collection of coordinates.
//- Chargers (c) are EVA’s home point and recharge the battery the moment EVA enters the charger. EVA will have to keep track of the location of the home charging station and remaining battery life, and will report its level of charge after every move. Once the battery is depleted, EVA can no longer move.

//Suppose our room looked like this:
//w w w w w w w
//w . . . . . w
//w . c x . . w
//w . x . . . w
//w . . . . . w
//w . . . . x w
//w . . . x . w
//w w w w w w w

//We could use this structure to define the room:
//room_description = {
//walls: {
//  min_x: 0,
//  min_y: 0,
//  max_x: 5,
//  max_y: 6,
//},
//obstacles: [
//  [1, 3],
//  [2, 4],
//  [3, 0],
//  [4, 1]
//],
//chargers: [[1, 4]]
//}

//Sample interaction:
//sequence = [                    # phase 2
//'R', 'B', 'L', 'L', 'F', 'F', # check top corner
//'R', 'B',                     # return to charge
//'F', 'R', 'R', 'B', 'L',      # check first obstacle from other side
//'B', 'B', 'B', 'B', 'R',      # get stuck in a corner
//'F', 'R', 'B', 'L'            # confirm battery depletion
//]

//eva_move('R') #=> OBSTACLE - position [1, 4] charge 9
//eva_move('B') #=> OBSTACLE - position [1, 4] charge 8
//eva_move('L') #=> success  - position [0, 4] charge 7
//eva_move('L') #=> WALLED   - position [0, 4] charge 6
//eva_move('F') #=> success  - position [0, 5] charge 5
//eva_move('F') #=> WALLED   - position [0, 5] charge 4
//eva_move('R') #=> success  - position [1, 5] charge 3
//eva_move('B') #=> charging - position [1, 4] charge 10
//eva_move('F') #=> success  - position [1, 5] charge 9
//eva_move('R') #=> success  - position [2, 5] charge 8
//eva_move('R') #=> success  - position [3, 5] charge 7
//eva_move('B') #=> success  - position [3, 4] charge 6
//eva_move('L') #=> OBSTACLE - position [3, 4] charge 5
//eva_move('B') #=> success  - position [3, 3] charge 4
//eva_move('B') #=> success  - position [3, 2] charge 3
//eva_move('B') #=> success  - position [3, 1] charge 2
//eva_move('B') #=> OBSTACLE - position [3, 1] charge 1
//eva_move('R') #=> OBSTACLE - position [3, 1] charge 0
//eva_move('F') #=> DEPLETED - position [3, 1] charge 0
//eva_move('R') #=> DEPLETED - position [3, 1] charge 0
//eva_move('B') #=> DEPLETED - position [3, 1] charge 0
//eva_move('L') #=> DEPLETED - position [3, 1] charge 0


*/

public class WealthSimple {

	public static void main(String[] args) {

		String commands = "BBLR";

		int[] wall = { 5, 6 };
		int[][] obstacles = { { 1, 3 }, { 2, 4 }, { 3, 0 }, { 4, 1 } };
		int[][] charger = { { 1, 4 } };

		operateBot(commands, wall, obstacles, charger);

	}

	public static void operateBot(String commands, int[] wall, int[][] obstacles, int[][] charger) {
		int x = 0;
		int y = 0;
		int battery = 10;

		for (char c : commands.toCharArray()) {

			switch (c) {
			case 'F':
				if (isWithInWall(x, y + 1, wall) && isObstacleFound(x, y, obstacles) && battery > 0) {
					y = y + 1;
					battery--;
					battery = reCharge(x, y, charger, battery);
				}
				logBotCoordinate(x, y);
				break;
			case 'B':
				if (isWithInWall(x, y - 1, wall) && isObstacleFound(x, y, obstacles) && battery > 0) {
					y = y - 1;
					battery--;
					battery = reCharge(x, y, charger, battery);
				}
				logBotCoordinate(x, y);
				break;
			case 'L':
				if (isWithInWall(x - 1, y, wall) && isObstacleFound(x, y, obstacles) && battery > 0) {
					x = x - 1;
					battery--;
					battery = reCharge(x, y, charger, battery);
				}
				logBotCoordinate(x, y);
				break;
			case 'R':
				if (isWithInWall(x + 1, y, wall) && isObstacleFound(x, y, obstacles) && battery > 0) {
					x = x + 1;
					battery--;
					battery = reCharge(x, y, charger, battery);
				}
				logBotCoordinate(x, y);
				break;
			default:
				System.out.println("Invalid command received");
				break;
			}
		}
	}

	public static void logBotCoordinate(int x, int y) {
		System.out.println("Current position of the bot is X:" + x + " Y:" + y);
	}

	public static boolean isWithInWall(int x, int y, int[] wall) {
		if (x <= wall[0] - 1 && y <= wall[1] - 1) {
			return true;
		}
		return false;
	}

	public static boolean isObstacleFound(int x, int y, int[][] obstacles) {
		for (int i = 0; i < obstacles.length; i++) {
			int obstX = obstacles[i][0];
			int obstY = obstacles[i][1];
			if (x == obstX && y == obstY) {
				return false;
			}
		}
		return true;
	}

	public static int reCharge(int x, int y, int[][] chargerPoints, int batteryLevel) {
		for (int i = 0; i < chargerPoints.length; i++) {
			int chargeX = chargerPoints[i][0];
			int chargeY = chargerPoints[i][1];
			if (x == chargeX && y == chargeY) {
				return 10;
			}
		}
		return batteryLevel;
	}

}
