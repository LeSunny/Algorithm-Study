import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2605 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			int pos = i - 1 - Integer.parseInt(st.nextToken());
			al.add(pos, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int e : al) {
			sb.append(e).append(" ");
		}
		
		System.out.println(sb);

		br.close();
	}
}
