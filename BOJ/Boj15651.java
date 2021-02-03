package com.ssafy.boj;

import java.io.*;

/* 중복을 허용하는 순열 */
public class Boj15651 {

	static int n;
	static int m;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split("\\s");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}

		makePermutation(0, new int[m]);
		System.out.println(sb);
	}

	private static void makePermutation(int cnt, int[] permArr) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(permArr[i]);
				if (i == m - 1)
					break;
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			permArr[cnt] = nums[i];
			makePermutation(cnt + 1, permArr);
		}

	}
}
