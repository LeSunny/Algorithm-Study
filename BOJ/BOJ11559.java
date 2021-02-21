package boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ11559 {

	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	static char[][] map = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	static Queue<Node> queue;
	static Queue<Node> adjQueue;

	static class Node {
		int x;
		int y;

		public Node(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	/* 4개 이상 붙어 있는 것들 체크 */
	private static int bfs(char color) {
		Node current;

		while (!queue.isEmpty()) {
			current = queue.poll();
			adjQueue.offer(current);

			for (int i = 0; i < 4; i++) {
				int tmpy = current.y + dy[i];
				int tmpx = current.x + dx[i];

				if (tmpy < 0 || tmpx < 0 || tmpy >= 12 || tmpx >= 6)
					continue;

				Node r = new Node(tmpy, tmpx);

				// 동일한 색 && 방문 X
				if (map[tmpy][tmpx] == color && !visited[tmpy][tmpx]) {
					visited[tmpy][tmpx] = true;
					queue.offer(r);
				}
			}

		}

		return adjQueue.size();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		queue = new LinkedList<Node>();
		adjQueue = new LinkedList<Node>();
		int combo = 0;

		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}

		while (true) {
			boolean isExit = true;

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if ('A' <= map[i][j] && map[i][j] <= 'Z' && !visited[i][j]) {
						visited[i][j] = true;
						queue.offer(new Node(i, j));

						// 같은 색 뿌요 개수
						int sameCnt = bfs(map[i][j]);

						if (sameCnt >= 4) {
							for (int k = 0; k < sameCnt; k++) {
								Node d = adjQueue.poll();
								map[d.y][d.x] = 'X';
							}

							isExit = false;
						}

						adjQueue.clear();
					}

				}

			}
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] == 'X')
						delete(new Node(i, j));
					visited[i][j] = false;
				}
			}

			if (isExit)
				break;

			++combo;
		}

		System.out.println(combo);

		br.close();
	}

	private static void delete(Node node) {
		for (int i = node.y; i >= 1; i--) {
			map[i][node.x] = map[i - 1][node.x];
		}
	}

}
