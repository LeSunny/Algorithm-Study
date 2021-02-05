package swea;

import java.io.*;

public class SWEA1861 {

	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] d;

	private static int goAroundRooms(int y, int x, int n) {

		int posY = y, posX = x;
		int moveCnt = 0;

		while (true) {
			boolean flag = false;
			for (int i = 0; i < 4; i++) {
				int tmpY = posY + dy[i], tmpX = posX + dx[i];
				if (tmpY < 0 || tmpX < 0 || tmpY >= n || tmpX >= n)
					continue;
				if (map[tmpY][tmpX] - map[posY][posX] != 1)
					continue;

				++moveCnt;
				if(d[map[tmpY][tmpX]] > 0)
					return moveCnt + d[map[tmpY][tmpX]];
				
				posY = tmpY;
				posX = tmpX;
				flag = true;
				break;
			}

			if (!flag)
				break;
		}

		return moveCnt + 1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			d = new int[n*n+1];
			for (int i = 0; i < n; i++) {
				String[] line = br.readLine().split("\\s");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}

			int pos = 1000000;
			int max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					
					d[map[i][j]] = goAroundRooms(i, j, n);
					// System.out.print(move + " ");
					if (max < d[map[i][j]]) {
						max = d[map[i][j]];
						pos = map[i][j];
					} else if (max == d[map[i][j]]) {
						if (pos > map[i][j]) {
							pos = map[i][j];
						}
					}
				}
				// System.out.println();
			}

			System.out.println("#" + t + " " + pos + " " + max);
		}
		br.close();
	}
}
