package swea;

import java.io.*;

class SWEA1954 {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		boolean[][] mark = null;

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			mark = new boolean[n][n];
			int[][] map = new int[n][n];
			int start = 1;
			int x = 0, y = 0;
			int dir = 3;
			while (start <= n * n) {
				mark[y][x] = true;
				map[y][x] = start;

				// 막혔을 때 방향 전환
				if ((y + dy[dir] < 0 || y + dy[dir] >= n || x + dx[dir] < 0 || x + dx[dir] >= n)
						|| mark[y + dy[dir]][x + dx[dir]] == true) {
					switch (dir) {
					case 0:
						dir = 3;
						break;
					case 1:
						dir = 2;
						break;
					case 2:
						dir = 0;
						break;
					case 3:
						dir = 1;
						break;
					}
				}
				x += dx[dir];
				y += dy[dir];
				start++;
			}

			StringBuilder result = new StringBuilder();
			result.append("#");
			result.append(test_case);
			result.append("\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					result.append(map[i][j]);
					if (j != n - 1)
						result.append(" ");
				}
				result.append("\n");
			}
			System.out.print(result);
		}

		br.close();
	}
}