package boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split("\\s");
		int n = Integer.parseInt(info[0]);
		int k = Integer.parseInt(info[1]);
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1; i<n+1; i++) {
			queue.offer(i);
		}
		
		sb.append("<");
		while(!queue.isEmpty()) {
			for(int i=0; i< k-1; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll());
			if(queue.size()==0)
				sb.append(">");
			else
				sb.append(", ");
		}
		System.out.println(sb);
		br.close();
	}
	
}
