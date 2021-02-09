package boj;

import java.io.*;

public class BOJ2563 {
	static boolean[][] map = new boolean[100][100];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			String[] info = br.readLine().split("\\s");
			int x = Integer.parseInt(info[0]);
			int y = Integer.parseInt(info[1]);

			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					map[i][j] = true;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j])
					++cnt;
			}
		}
		System.out.println(cnt);

		br.close();
	}
}
