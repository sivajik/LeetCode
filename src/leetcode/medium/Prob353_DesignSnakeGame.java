package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Prob353_DesignSnakeGame {

	public static void main(String[] args) {
		SnakeGame snakeGame = new SnakeGame(3, 2, new int[][] { { 1, 2 }, { 0, 1 } });
		snakeGame.move("R"); // return 0
		snakeGame.move("D"); // return 0
		snakeGame.move("R"); // return 1, snake eats the first piece of food. The second piece of food
								// appears
								// at (0, 1).
		snakeGame.move("U"); // return 1
		snakeGame.move("L"); // return 2, snake eats the second food. No more food appears.
		snakeGame.move("U"); // return -1, game over because snake collides with border

	}

	static class SnakeGame {
		int r;
		int c;
		int rows;
		int cols;
		int index;
		int score;
		Queue<int[]> snake;
		int[][] foods;

		public SnakeGame(int width, int height, int[][] food) {
			r = 0;
			c = 0;
			rows = height;
			cols = width;
			foods = food;
			score = 0;
			snake = new LinkedList<>();
			index = 0; // pointer to food array
		}

		public int move(String direction) {
			switch (direction) {
			case "U":
				r--;
				break;
			case "D":
				r++;
				break;
			case "L":
				c--;
				break;
			case "R":
				c++;
				break;
			}
			if (!isValid(r, c)) {
				return -1;
			}
			return process(r, c);
		}

		private boolean isValid(int x, int y) {
			return (x >= 0 && x < rows && y >= 0 && y < cols);
		}

		private int process(int r, int c) {
			if (index == foods.length) {
				snake.poll();
			} else if (foods[index][0] == r && foods[index][1] == c) {
				score++;
				index++;
			} else {
				snake.poll();
			}

			for (int[] s : snake) {
				if (s[0] == r && s[1] == c) {
					return -1; // snake colliding itself with new r , c values.
				}
			}
			snake.add(new int[] { r, c });
			return score;
		}
	}
}
