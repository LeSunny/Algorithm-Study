package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ17406 {

	static int row;
	static int col;
	static int rotation;
	static int[][] map;
	static int[][] originMap;
	static String[][] operations;
	static int min = Integer.MAX_VALUE;

	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] info = br.readLine().split("\\s");
		row = Integer.parseInt(info[0]);
		col = Integer.parseInt(info[1]);
		rotation = Integer.parseInt(info[2]);
		map = new int[row][col];
		originMap = new int[row][col];

		for (int i = 0; i < row; i++) {
			String[] line = br.readLine().split("\\s");
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				originMap[i][j] = map[i][j];
			}
		}

		operations = new String[rotation][3];
		for (int i = 0; i < rotation; i++) {
			String[] posInfo = br.readLine().split("\\s");
			operations[i] = new String[3];
			operations[i][0] = posInfo[0];
			operations[i][1] = posInfo[1];
			operations[i][2] = posInfo[2];
		}

		// permutation
		makePermutation(0, new int[operations.length], new boolean[operations.length]);
		System.out.println(min);
		br.close();
	}

	private static void makePermutation(int cnt, int[] permArr, boolean[] visited) {
		if (cnt == operations.length) {
			for (int i = 0; i < cnt; i++) {
				rotation(Integer.parseInt(operations[permArr[i]][0]) - 1,
						Integer.parseInt(operations[permArr[i]][1]) - 1, Integer.parseInt(operations[permArr[i]][2]));
			}
			calculateMin();
			recoverMap();
			return;
		}

		for (int i = 0; i < operations.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				permArr[cnt] = i;
				makePermutation(cnt + 1, permArr, visited);
				visited[i] = false;
			}
		}

	}

	private static void recoverMap() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j] = originMap[i][j];
			}
		}
	}

	private static void calculateMin() {
		for (int i = 0; i < row; i++) {
			int sum = 0;
			for (int j = 0; j < col; j++) {
				sum += map[i][j];
			}
			min = Math.min(min, sum);
		}
	}

	private static void rotation(int r, int c, int num) {

		for (int i = 0; i < num; i++) {
			int tmp = map[r - num + i][c - num + i];

			int ly = r - num + i;
			int lx = c - num + i;
			int edgeCnt = 0;
			while (edgeCnt < 4) {
				int ny = ly + dy[edgeCnt];
				int nx = lx + dx[edgeCnt];

				if (ny >= r - num + i && nx >= c - num + i && ny <= r + num - i && nx <= c + num - i) {
					map[ly][lx] = map[ny][nx];
					ly = ny;
					lx = nx;
				} else {
					edgeCnt++;
				}
			}
			map[r - num + i][c - num + i + 1] = tmp;
		}

	}

}
