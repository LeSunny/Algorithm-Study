package boj;

import java.io.*;
import java.util.Arrays;

public class BOJ16935 {

	static int n, m, r;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] info = br.readLine().split("\\s");
		n = Integer.parseInt(info[0]);
		m = Integer.parseInt(info[1]);
		r = Integer.parseInt(info[2]);
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split("\\s");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		String[] commands = br.readLine().split("\\s");
		for (int i = 0; i < r; i++) {
			switch (Integer.parseInt(commands[i])) {
			case 1:
				upsideDown();
				break;
			case 2:
				reverseLeftNRight();
				break;
			case 3:
				rotateRight();
				break;
			case 4:
				rotateLeft();
				break;
			case 5:
				divideNRotate();
				break;
			case 6:
				divideNRotate2();
				break;
			}
		}
		printMap();

		br.close();
	}

	private static void upsideDown() {
		int mid = n / 2;
		for (int i = 0; i < mid; i++) {
			int[] tmp = map[i];
			map[i] = map[n - 1 - i];
			map[n - 1 - i] = tmp;
		}
	}

	private static void reverseLeftNRight() {
		int mid = m / 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				int tmp = map[i][j];
				map[i][j] = map[i][m - 1 - j];
				map[i][m - 1 - j] = tmp;
			}
		}
	}

	private static void rotateRight() {
		int[][] map2 = new int[m][n];
		for (int i = 0; i < n; i++) {
			int[] tmp = map[i];
			for (int j = 0; j < m; j++) {
				map2[j][n - 1 - i] = tmp[j];
			}
		}
		map = map2;
		swap();
	}

	private static void rotateLeft() {
		int[][] map2 = new int[m][n];
		for (int i = 0; i < n; i++) {
			int[] tmp = map[i];
			for (int j = 0; j < m; j++) {
				map2[m - 1 - j][i] = tmp[j];
			}
		}
		map = map2;
		swap();
	}

	private static void swap() {
		int tmp = n;
		n = m;
		m = tmp;
	}

	private static void divideNRotate() {
		/*
		 * 1 2 4 3
		 */
		int tmp[][] = new int[n / 2][m / 2];
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				tmp[i][j] = map[i][j];
			}
		}

		// 1 <- 4
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				map[i][j] = map[i + n / 2][j];
			}
		}
		// 4 <- 3
		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				map[i][j] = map[i][j + m / 2];
			}
		}
		// 3 <- 2
		for (int i = n / 2; i < n; i++) {
			for (int j = m / 2; j < m; j++) {
				map[i][j] = map[i - n / 2][j];
			}
		}
		// 2 <- 1
		for (int i = 0; i < n / 2; i++) {
			for (int j = m / 2; j < m; j++) {
				map[i][j] = tmp[i][j - m / 2];
			}
		}
	}

	private static void divideNRotate2() {
		int tmp[][] = new int[n / 2][m / 2];
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				tmp[i][j] = map[i][j];
			}
		}

		// 1 <- 2
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				map[i][j] = map[i][j + m / 2];
			}
		}
		// 2 <- 3
		for (int i = 0; i < n / 2; i++) {
			for (int j = m / 2; j < m; j++) {
				map[i][j] = map[i + n / 2][j];
			}
		}
		// 3 <- 4
		for (int i = n / 2; i < n; i++) {
			for (int j = m / 2; j < m; j++) {
				map[i][j] = map[i][j - m / 2];
			}
		}
		// 4 <- 1
		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				map[i][j] = tmp[i - n / 2][j];
			}
		}
	}

	private static void printMap() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j]);
				if (j == m - 1)
					break;
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
