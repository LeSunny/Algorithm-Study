package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA2001 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] nm = br.readLine().split("\\s");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = 0;
			for (int i = 0; i <= n - m; i++) {
				for (int j = 0; j <= n - m; j++) {
					int sum = 0;
					for (int h = i; h < i + m; h++) {
						for (int w = j; w < j + m; w++) {
							sum += map[h][w];
						}
					}
					max = Math.max(max, sum);
				}
			}

			System.out.println("#" + t + " " + max);
		}
	}
}
