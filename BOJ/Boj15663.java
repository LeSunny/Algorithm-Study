package com.ssafy.boj;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Boj15663 {

	static int n;
	static int m;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> hs = new HashSet<String>();

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

		makePermutation(0, new int[m], new boolean[n]);
		System.out.println(sb);
	}

	private static void makePermutation(int cnt, int[] permArr, boolean[] visited) {
		if (cnt == m) {
			String s = "";
			for (int i = 0; i < m; i++) {
				s+=permArr[i];
			}
			
			if(!hs.contains(s)) {
				for (int i = 0; i < m; i++) {
					sb.append(permArr[i]);
					if (i == m - 1)
						break;
					sb.append(" ");
				}
				sb.append("\n");
				hs.add(s);
			}		
			
			return;
		}

		for (int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				permArr[cnt] = nums[i];
				makePermutation(cnt + 1, permArr, visited);	
				visited[i] = false;
			}
		}
	}

}
