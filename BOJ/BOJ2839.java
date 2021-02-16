package boj;

import java.io.*;

public class BOJ2839 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int t = 0, f = n / 5;

		int min = Integer.MAX_VALUE;
		boolean flag = false;
		for (; f >= 0; f--) {
			int total = n;
			total -= 5 * f;
			if (total % 3 == 0) {
				flag = true;
				t = total / 3;
				min = Math.min(min, t + f);
			}
		}
		if (flag)
			System.out.println(min);
		else
			System.out.println(-1);
		br.close();
	}
}
