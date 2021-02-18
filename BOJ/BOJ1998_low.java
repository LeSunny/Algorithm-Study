package com.ssafy.hw12;

import java.io.*;
import java.util.StringTokenizer;

/* 알파벳 사용 여부만 */
public class BOJ1987_2 {

	static int r;
	static int c;
	static char[][] map;
	static boolean[] alphabet = new boolean[26];
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		dfs(0, 0, 1);
		System.out.println(max);
		br.close();
	}

	private static void dfs(int y, int x, int cnt) {
		if (alphabet[map[y][x] - 'A'])
			return;

		alphabet[map[y][x] - 'A'] = true;

		boolean flag = false;

		for (int i = 0; i < 4; i++) {
			int tmpy = y + dy[i];
			int tmpx = x + dx[i];

			if (tmpy < 0 || tmpy >= r || tmpx < 0 || tmpx >= c || alphabet[map[tmpy][tmpx] - 'A'])
				continue;

			flag = true;
			dfs(tmpy, tmpx, cnt + 1);
			alphabet[map[tmpy][tmpx] - 'A'] = false;
		}

		if (!flag) {
			max = Math.max(max, cnt);
		}

	}

}
