package com.ssafy.boj;

import java.io.*;
import java.util.Arrays;

/* 중복되지 않은 조합(사용자 입력) */
public class Boj15655 {

	static int n;
	static int m;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split("\\s");
		String[] numsInfo = br.readLine().split("\\s");

		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(numsInfo[i]);
		}
		Arrays.sort(nums);

		makeCombination(0, new int[m], 0);
		System.out.println(sb);
	}

	private static void makeCombination(int cnt, int[] combArr, int startIdx) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(combArr[i]);
				if (i == m - 1)
					break;
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = startIdx; i < n; i++) {
			combArr[cnt] = nums[i];
			makeCombination(cnt + 1, combArr, i + 1);
		}
	}

}
