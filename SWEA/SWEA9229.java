package swea;

import java.io.*;

/* 한빈이와 Spot Mart */
public class SWEA9229 {

	static int[] snacks;
	static int max;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			String[] condition = br.readLine().split("\\s");
			n = Integer.parseInt(condition[0]); // 과자봉지 수
			m = Integer.parseInt(condition[1]); // 무게 합 제한

			String[] snackStr = br.readLine().split("\\s");
			snacks = new int[n];
			for (int i = 0; i < n; i++) {
				snacks[i] = Integer.parseInt(snackStr[i]);
			}

			max = Integer.MIN_VALUE;
			makeCombination(0, new int[2], 0);
			if(max==Integer.MIN_VALUE) max = -1;
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.print(sb);

		br.close();
	}

	private static void makeCombination(int cnt, int[] combSnacks, int startIdx) {
		if (cnt == 2) {
			int sum = combSnacks[0] + combSnacks[1];
			if (sum > m)
				return;
			max = Math.max(max, sum);
			return;
		}

		for (int i = startIdx; i < snacks.length; i++) {
			combSnacks[cnt] = snacks[i];
			makeCombination(cnt + 1, combSnacks, i + 1);
		}
	}

}
