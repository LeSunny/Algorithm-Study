package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA3234 {

	static int N;
	static int[] weight;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			weight = new int[N];

			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}

			cnt = 0;
			makePermutation(0, 0, new int[N]);
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);

		br.close();
	}

	private static void makePermutation(int num, int flag, int[] arr) {
		if (num == N) {
			makeSubset(0, arr, 0, 0);
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			arr[num] = weight[i];
			makePermutation(num + 1, flag | 1 << i, arr);
		}
	}

	private static void makeSubset(int size, int[] arr, int left, int right) {
		if (left < right)
			return;

		if (size == N) {
			if (left >= right)
				cnt++;
			return;
		}

		makeSubset(size + 1, arr, left + arr[size], right);
		makeSubset(size + 1, arr, left, right + arr[size]);

	}

}
