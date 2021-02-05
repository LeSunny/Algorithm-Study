package swea;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA1225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = 0;
		while (t < 10) {
			t = Integer.parseInt(br.readLine());
			
			//입력
			String[] str = br.readLine().split("\\s");
			Queue<Integer> queue = new LinkedList<Integer>();
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(str[i]));
			}
			
			int cnt = 1;
			while(queue.peek()!=0) {
				int first = queue.poll();
				
				first -= cnt;
				if(first < 0 ) {
					first = 0;
				}
				cnt = cnt%5 + 1;
				
				queue.offer(first);
				if(first == 0)
					break;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(t);
			sb.append(" ");
			for(int i=0; i < 8; i++) {
				sb.append(queue.poll());
				if(i==7) break;
				sb.append(" ");
			}
			System.out.println(sb);
		}
		br.close();
	}

}
