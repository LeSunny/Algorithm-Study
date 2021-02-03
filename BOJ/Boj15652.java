package com.ssafy.boj;

import java.io.*;


/* 중복을 허용하는 조합 */
public class Boj15652 {
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
		makeCombination(0, new int[m]);
	}

	private static void makeCombination(int cnt, int[] combArr) {

		if (cnt == m) {
			for (int i = 0; i < m-1; i++) {
				if(combArr[i]>combArr[i+1])
					return;				
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				sb.append(combArr[i]);
				if (i == m - 1)
					break;
				sb.append(" ");
			}
			System.out.println(sb);
			return;
		}
		for (int i = 0; i < n; i++) {
			combArr[cnt] = nums[i];
			makeCombination(cnt + 1, combArr);
		}
	}

}
