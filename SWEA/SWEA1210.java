package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
	int x;
	int y;

	public Node(int y, int x) {
		this.x = x;
		this.y = y;
	}
}

public class SWEA1210 {
	// static int[] dy = {0, 0};
	static int[] dx = { -1, 1 };
	static int[][] map = new int[100][100];
	static boolean[][] mark = new boolean[100][100];

	private static boolean bfs(Node start) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(start);
		mark[start.y][start.x] = true;
		int x = start.x;
		int y = start.y;

		while (!q.isEmpty()) {
			Node r = q.poll();

			if (r.y == 99) {
				// System.out.println(r.x+" "+map[r.y][r.x]);
				if (map[r.y][r.x] == 2)
					return true;
				else
					return false;
			}

			boolean flag = false;
			for (int i = 0; i < 2; i++) {
				int tmpX = r.x + dx[i];

				if (tmpX < 0 || tmpX >= 100)
					continue;
				if (!mark[r.y][tmpX] && map[r.y][tmpX] != 0) {
					// System.out.println("왼오 " +(r.y)+" "+tmpX);
					q.offer(new Node(r.y, tmpX));
					mark[r.y][tmpX] = true;
					flag = true;
					break;
				}
			}

			if (!flag && r.y + 1 < 100 && map[r.y + 1][r.x] != 0) {
				// System.out.println("down " +(r.y+1)+" "+(r.x));
				q.offer(new Node(r.y + 1, r.x));
				mark[r.y + 1][r.x] = true;
			}
		}

		return false;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			br.readLine();
			ArrayList<Node> start = new ArrayList<Node>();
			// 입력 받기
			for (int i = 0; i < 100; i++) {
				String[] line = br.readLine().split("\\s");
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(line[j]);
					if (i == 0 && map[i][j] == 1) {
						start.add(new Node(0, j));
					}
				}
			}

			// start.add(new Node(0,67));

			// start 에서 하나씩 내려가기
			for (Node s : start) {
				boolean r = bfs(s);
				if (r) {
					System.out.println("#" + test_case + " " + s.x);
					break;
				}
				for (int i = 0; i < 100; i++) {
					for (int j = 0; j < 100; j++) {
						mark[i][j] = false;
					}
				}
			}

		}
	}
}