package leetcode.matrix;

public class FloodFill {

	public static void main(String[] args) {

	}

	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int x = image[sr][sc];
		if (x == color) {
			return image;
		}
		markVisited(image, sr, sc, color, x);
		return image;
	}

	public void markVisited(int[][] image, int sr, int sc, int color, int x) {

		if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[sr].length || image[sr][sc] != x) {
			return;
		}
		image[sr][sc] = color;
		markVisited(image, sr + 1, sc, color, x);
		markVisited(image, sr - 1, sc, color, x);
		markVisited(image, sr, sc + 1, color, x);
		markVisited(image, sr, sc - 1, color, x);
	}

	// TODO
	public void floodFill_BFS() {

	}

}
