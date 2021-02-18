package com.ssafy.hw12;

import java.io.*;
import java.util.StringTokenizer;

/* 비트 연산 사용 */
public class BOJ1987 {

	static int r;
	static int c;
	static char[][] map;
	static int[][] alphabet;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		alphabet = new int[r][c];

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		dfs(0, 0, 1, 1 << (map[0][0] - 'A'));
		System.out.println(max);
		br.close();
	}

	private static void dfs(int y, int x, int cnt, int visited) {
		if (alphabet[y][x] == visited)
			return;

		alphabet[y][x] = visited;
		max = Math.max(max, cnt);

		for (int i = 0; i < 4; i++) {
			int tmpy = y + dy[i];
			int tmpx = x + dx[i];

			if (tmpy < 0 || tmpy >= r || tmpx < 0 || tmpx >= c || (visited & 1 << (map[tmpy][tmpx] - 'A')) != 0)
				continue;

			dfs(tmpy, tmpx, cnt + 1, visited | 1 << (map[tmpy][tmpx] - 'A'));
		}
	}

}
