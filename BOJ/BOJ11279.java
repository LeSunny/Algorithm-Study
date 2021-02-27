import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringBuilder answer = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input==0) {
				if(pq.isEmpty())
					answer.append("0\n");
				else {
					answer.append(Integer.toString(pq.poll())+"\n");
				}					
			}
			else
				pq.add(input);
		}
		
		bw.write(new String(answer));
		
		bw.flush();
	}
}
