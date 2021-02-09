package boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<Integer>();
		int n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			queue.offer(i);
		}
		
		if (queue.size() != 1) {
			while (!queue.isEmpty()) {
				queue.poll();
				if (queue.size() == 1) {
					break;
				}
				queue.offer(queue.poll());
			}
		}
		
		System.out.println(queue.poll());
		
		br.close();
	}
	
}
