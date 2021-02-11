package boj;

import java.io.*;
import java.util.*;

public class BOJ1260 {

	static ArrayList<Integer>[] adjacent;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	static void dfs(int start) {
		visited[start] = true;
		sb.append(start);
		sb.append(" ");

		for (int e : adjacent[start]) {
			if (!visited[e]) {
				dfs(e);
			}
		}
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int r = queue.poll();
			sb.append(r).append(" ");

			for (int e : adjacent[r]) {
				if (!visited[e]) {
					queue.offer(e);
					visited[e] = true;
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] info = br.readLine().split("\\s");
		int n = Integer.parseInt(info[0]);
		int m = Integer.parseInt(info[1]);
		int v = Integer.parseInt(info[2]);

		adjacent = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			adjacent[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			String[] str = br.readLine().split("\\s");
			int n1 = Integer.parseInt(str[0]);
			int n2 = Integer.parseInt(str[1]);

			adjacent[n1].add(n2);
			adjacent[n2].add(n1);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(adjacent[i]);
		}

		dfs(v);
		visited = new boolean[n + 1];
		sb.append("\n");
		bfs(v);
		System.out.println(sb);
		br.close();
	}
}
