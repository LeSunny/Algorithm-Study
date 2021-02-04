package swea;

import java.io.*;

class SWEA1873 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] info = br.readLine().split("\\s");
			int H = Integer.parseInt(info[0]);
			int W = Integer.parseInt(info[1]);

			// map 입력
			String[][] map = new String[H][W];
			int x = 0, y = 0;
			for (int i = 0; i < H; i++) {
				String line = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.substring(j, j + 1);
					if (map[i][j].equals("^") || map[i][j].equals("v") || map[i][j].equals("<")
							|| map[i][j].equals(">")) {
						x = j;
						y = i;
					}
				}
			}

			// 사용자 입력
			int n = Integer.parseInt(br.readLine());
			String input = br.readLine();

			for (int i = 0; i < n; i++) {
				int tmpX = 0, tmpY = 0;
				switch (input.substring(i, i + 1)) {
				case "U":
					map[y][x] = "^";
					tmpY = y - 1;
					if (tmpY < 0 || tmpY >= H || !map[tmpY][x].equals("."))
						continue;
					map[tmpY][x] = "^";
					map[y][x] = ".";
					y = tmpY;
					break;
				case "D":
					map[y][x] = "v";
					tmpY = y + 1;
					if (tmpY < 0 || tmpY >= H || !map[tmpY][x].equals("."))
						continue;
					map[tmpY][x] = "v";
					map[y][x] = ".";
					y = tmpY;
					break;
				case "L":
					map[y][x] = "<";
					tmpX = x - 1;
					if (tmpX < 0 || tmpX >= W || !map[y][tmpX].equals("."))
						continue;
					map[y][tmpX] = "<";
					map[y][x] = ".";
					x = tmpX;
					break;
				case "R":
					map[y][x] = ">";
					tmpX = x + 1;
					if (tmpX < 0 || tmpX >= W || !map[y][tmpX].equals("."))
						continue;
					map[y][tmpX] = ">";
					map[y][x] = ".";
					x = tmpX;
					break;
				case "S":
					switch (map[y][x]) {
					case "^":
						for (int j = y - 1; j >= 0; j--) {
							if (map[j][x].equals("*")) {
								map[j][x] = ".";
								break;
							} else if (map[j][x].equals("#")) {
								break;
							}
						}
						break;
					case "v":
						for (int j = y + 1; j < H; j++) {
							if (map[j][x].equals("*")) {
								map[j][x] = ".";
								break;
							} else if (map[j][x].equals("#")) {
								break;
							}
						}
						break;
					case "<":
						for (int j = x - 1; j >= 0; j--) {
							if (map[y][j].equals("*")) {
								map[y][j] = ".";
								break;
							} else if (map[y][j].equals("#")) {
								break;
							}
						}
						break;
					case ">":
						for (int j = x + 1; j < W; j++) {
							if (map[y][j].equals("*")) {
								map[y][j] = ".";
								break;
							} else if (map[y][j].equals("#")) {
								break;
							}
						}
						break;
					}
					break;
				}
			}
			StringBuilder result = new StringBuilder();
			result.append("#");
			result.append(test_case);
			result.append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					result.append(map[i][j]);
				}
				result.append("\n");
			}
			System.out.print(result);
		}
	}
}