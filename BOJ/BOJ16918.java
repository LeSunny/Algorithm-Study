import java.io.*;
import java.util.*;

public class Main {

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static char[][] map;
	static int[][] boomTime;
	static int time = 0;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int R, C, N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		boomTime = new int[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'O') {
					boomTime[i][j] = 3;
				}
			}
		}

		time = 2;
		bomb();
		print();

		br.close();

	}

	private static void print() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		System.out.print(sb);

	}

	private static void bomb() {
		while (time <= N) {
			if (time % 2 == 0) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (map[i][j] == '.') {
							map[i][j] = 'O';
							boomTime[i][j] = time + 3;
						}
					}
				}
			} else {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (boomTime[i][j] == time) {
							for (int k = 0; k < 4; k++) {
								if (i + dy[k] < 0 || i + dy[k] >= R || j + dx[k] < 0 || j + dx[k] >= C)
									continue;
								if (boomTime[i + dy[k]][j + dx[k]] == time)
									continue;
								boomTime[i + dy[k]][j + dx[k]] = 0;
								map[i + dy[k]][j + dx[k]] = '.';
							}
							boomTime[i][j] = 0;
							map[i][j] = '.';
						}
					}
				}
			}
			time++;
		}
	}
}
