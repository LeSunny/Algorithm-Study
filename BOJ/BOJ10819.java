import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, nums[];
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());			
		}
		
		makePermutation(0, new int[N], new boolean[N]);
		System.out.println(max);
		br.close();
	}
	
	private static void makePermutation (int cnt, int[] permArr, boolean[] visited){
		if(cnt == N) {
			calculate(permArr);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			permArr[cnt] = nums[i];
			makePermutation(cnt+1, permArr, visited);
			visited[i] = false;
		}
	}

	private static void calculate(int[] permArr) {
		int sum = 0;
		
		for(int i=0; i<N-1; i++) {
			sum += Math.abs(permArr[i]-permArr[i+1]);
		}
		
		max = Math.max(sum, max);
	}
}
