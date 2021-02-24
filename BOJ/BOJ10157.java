import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int C, R;
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		map = new int[R + 1][C + 1];

		if (K > C * R)
			System.out.println(0);
		else
			check(K);

		br.close();
	}

	private static void check(int k) {
		int dir = 0;

		int x = 1, y = 1;
		int num = 1;

		while (num <= C * R) {

			map[y][x] = num++;
			if (num - 1 == k) {
				System.out.println(x + " " + y);
				return;
			}

			if (x + dx[dir] < 1 || x + dx[dir] > C || y + dy[dir] < 1 || y + dy[dir] > R
					|| map[y + dy[dir]][x + dx[dir]] != 0) {
				dir++;
				if (dir == 4)
					dir = 0;
			}
			x = x + dx[dir];
			y = y + dy[dir];

		}
	}
}
