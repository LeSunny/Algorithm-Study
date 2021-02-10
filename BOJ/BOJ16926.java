package boj;

import java.io.*;

public class BOJ16926 {

	static int r, c, rotation, num;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] info = br.readLine().split("\\s");
		r = Integer.parseInt(info[0]);
		c = Integer.parseInt(info[1]);
		rotation = Integer.parseInt(info[2]);

		map = new int[r][c];

		for (int i = 0; i < r; i++) {
			String[] line = br.readLine().split("\\s");
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		num = Math.min(r, c) / 2; // 회전할 레이어 수
		for (int i = 0; i < rotation; i++) {
			rotateMap();
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
		br.close();
	}

	private static void rotateMap() {
		for (int n = 0; n < num; n++) {
			int tmp = map[n][n];

			int edgeCnt = 0;
			int lx = n, ly = n;
			while (edgeCnt < 4) {
				// 한 칸 이동
				int ny = ly + dy[edgeCnt]; // 우하좌상
				int nx = lx + dx[edgeCnt]; // 우하좌상 의 숫자를 덮어씀

				// 다음 칸 좌표 확인
				if (ny >= n && nx >= n && ny < r - n && nx < c - n) {
					map[ly][lx] = map[ny][nx]; // 이전 점의 값을 다음 점의 값으로 치환
					ly = ny; // 현재 점을 다음 점의 값으로 바꾸고 while문을 다시 돌린다
					lx = nx;
				} else {
					edgeCnt++; // 다음 점이 범위를 벗어났으므로 꺾는다.
				}

			}
			
			map[n+1][n] = tmp;
		}
	}

}
