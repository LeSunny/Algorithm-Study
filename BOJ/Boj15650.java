import java.io.*;

/* 중복되지 않은 조합 */
public class Boj15650 {

	static int n;
	static int m;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split("\\s");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}

		makePermutation(0, new int[m], new boolean[n]);
	}

	private static void makePermutation(int cnt, int[] permArr, boolean[] visited) {
		if (cnt == m) {
			for (int i = 0; i < m - 1; i++) { // 오름차순 확인
				if (permArr[i] > permArr[i + 1])
					return;
			}
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

		for (int i = cnt; i < n; i++) { // 중복검사를 하지 않고, i를 cnt부터 시작하도록 했다
			if (!visited[i]) {
				visited[i] = true;
				permArr[cnt] = nums[i];
				makePermutation(cnt + 1, permArr, visited);
				visited[i] = false;
			}
		}
	}
}
