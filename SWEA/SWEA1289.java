package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1289 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			String input = br.readLine();
			int len = input.length();
			char pos = '0';
			int cnt = 0;

			for (int j = 0; j < len; j++) {
				if (input.charAt(j) != pos) {
					++cnt;
					if (pos == '0')
						pos = '1';
					else
						pos = '0';
				}
			}

			System.out.println("#" + test_case + " " + cnt);
		}
	}
}