package com.ssafy.hw11;

import java.io.*;

public class BOJ1992 {

	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = (int) line.charAt(j) - '0';
			}
		}

		divideNconquer(0, 0, n);
		System.out.println(sb);

		br.readLine();
	}

	private static void divideNconquer(int y, int x, int r) {
		if (r == 1) {
			sb.append(map[y][x]);
			return;
		}

		boolean flag = true;
		int piv = map[y][x];

		for (int i = y; i < y + r; i++) {
			for (int j = x; j < x + r; j++) {
				if (piv != map[i][j]) {
					flag = false;
					break;
				}
			}
			if (!flag)
				break;
		}

		if (flag) {
			sb.append(piv == 0 ? 0 : 1);
		} else {
			int nextR = r/2;
			sb.append("(");
			divideNconquer(y, x, nextR);
			divideNconquer(y, x + nextR, nextR);
			divideNconquer(y + nextR, x, nextR);
			divideNconquer(y + nextR, x + nextR, nextR);
			sb.append(")");
		}

	}

}
