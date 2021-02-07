package swea;

import java.util.Scanner;

class SWEA1210 {
	public static int[][] map;
	public static boolean visit[][];
	public static int result;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int num;
		for (int test_case = 1; test_case <= T; test_case++) {
			num = sc.nextInt();
			map = new int[101][101];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < 100; i++) {

				if (map[0][i] == 1) {
					visit = new boolean[101][101];
					sadari(0, i, i);
				}

			}
			System.out.println("#" + num + " " + result);

		}
		sc.close();
	}

	public static void sadari(int y, int x, int start) {

		if (y == 99) {
			if (map[y][x] == 2)
				result = start;
			return;
		}

		visit[y][x] = true;

		if ((x + 1 <= 99) && map[y][x + 1] == 1 && !visit[y][x + 1]) { // 오른쪽
			sadari(y, x + 1, start);
		} else if ((x - 1 >= 0) && map[y][x - 1] == 1 && !visit[y][x - 1]) { // 왼쪽
			sadari(y, x - 1, start);
		} else { // 아래
			sadari(y + 1, x, start);
		}
	}
}
