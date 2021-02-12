package boj;

import java.io.*;
import java.util.*;

class Node {
	int y;
	int x;

	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class BOJ2667 {

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> cntArr = new ArrayList<Integer>();
	static int totalCnt = 0;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(line.substring(j, j + 1));
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt = 0;
					++totalCnt;
					dfs(new Node(i, j));
					cntArr.add(cnt);
				}
			}
		}

		System.out.println(totalCnt);
		Collections.sort(cntArr);
		for(int e : cntArr) {
			System.out.println(e);
		}
		br.close();
	}

	private static void dfs(Node node) {
		
		visited[node.y][node.x] = true;
		++cnt;
		for(int i=0; i<4; i++) {
			int tmpy = node.y+dy[i];
			int tmpx = node.x+dx[i];
			if(tmpy<0 || tmpx<0 || tmpx>=n ||tmpy >=n)
				continue;
			if(!visited[tmpy][tmpx] && map[tmpy][tmpx] == 1)
				dfs(new Node(tmpy, tmpx));
		}
		
	}

}
