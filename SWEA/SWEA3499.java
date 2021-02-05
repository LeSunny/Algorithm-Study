package swea;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA3499 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());

			String[] cards = br.readLine().split("\\s");
			Queue<String> cardQ1 = new LinkedList<String>();
			Queue<String> cardQ2 = new LinkedList<String>();
			Queue<String> result = new LinkedList<String>();

			if(n%2==0) {
				for (int i = 0; i < n / 2; i++) {
					cardQ1.offer(cards[i]);
				}
				for (int i = n / 2 ; i < n; i++) {
					cardQ2.offer(cards[i]);
				}
			}else {
				for (int i = 0; i <= n / 2; i++) {
					cardQ1.offer(cards[i]);
				}
				for (int i = n / 2 + 1; i < n; i++) {
					cardQ2.offer(cards[i]);
				}
			}
			

			while (!cardQ1.isEmpty() && !cardQ2.isEmpty()) {
				result.offer(cardQ1.poll());
				result.offer(cardQ2.poll());
			}
			
			while(!cardQ1.isEmpty()) {
				result.offer(cardQ1.poll());
			}
			
			sb.append("#");
			sb.append(t);
			sb.append(" ");
			while(!result.isEmpty()) {
				sb.append(result.poll());
				if(result.size()==0) break;
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
