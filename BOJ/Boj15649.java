import java.io.*;

/*
 * https://www.acmicpc.net/problem/15649
 * N과 M (1) : 중복되지 않은 순열
 * */

public class Boj15649 {

	static int n;
	static int m;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split("\\s");

		n = Integer.parseInt(NM[0]);
		m = Integer.parseInt(NM[1]);
		nums = new int[n];

		for (int i = 1; i <= n; i++) {
			nums[i - 1] = i;
		}

		makePermutation(0, new int[m], new boolean[n]);

	}

	public static void makePermutation(int selectedNum, int[] permArr, boolean[] visited) {
		if (selectedNum == m) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				sb.append(permArr[i]);
				if (i == m - 1)
					break;
				sb.append(" ");
			}
			System.out.println(sb);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				permArr[selectedNum] = nums[i];
				makePermutation(selectedNum + 1, permArr, visited);
				visited[i] = false;
			}
		}
	}
}
