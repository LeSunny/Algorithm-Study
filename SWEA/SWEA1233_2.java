package swea;

import java.io.*;

public class SWEA1233_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			boolean flag = true;
			for (int i = 1; i <= n / 2; i++) {
				String[] input = br.readLine().split("\\s");
				if (!input[1].equals("+") && !input[1].equals("*") && !input[1].equals("/") && !input[1].equals("-")) {
					flag = false;
				}
			}

			boolean flag2 = true;
			for (int i = n / 2 + 1; i <= n; i++) {
				String[] input = br.readLine().split("\\s");
				if (input[1].equals("+") || input[1].equals("*") || input[1].equals("/") || input[1].equals("-")) {
					flag2 = false;
				}
			}

			if (!flag || !flag2) {
				System.out.println("#" + t + " " + 0);
			} else {
				System.out.println("#" + t + " " + 1);
			}
		}

		br.close();
	}
}
