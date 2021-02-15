package boj;

import java.io.*;

public class BOJ1978 {
	static boolean[] isComposite;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];

		int max = 0;
		String[] inputs = br.readLine().split("\\s");
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(inputs[i]);
			max = Math.max(max, input[i]);
		}

		isComposite = new boolean[max + 1];

		isComposite[1] = true;
		for (int i = 2; i * i <= max; i++) {
			if (isComposite[i])
				continue;
			for (int j = i + i; j <= max; j += i) {
				isComposite[j] = true;
			}
		}
		for (int i = 2; i <= max; i++) {
			if (!isComposite[i])
				System.out.println(i);
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (!isComposite[input[i]]) {
				++cnt;
			}
		}

		System.out.println(cnt);

		br.close();
	}

}
