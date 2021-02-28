import java.io.*;
import java.util.*;

public class Main {
	static int width, height;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String str = br.readLine();

			if (checkPalindrome(str, 0, str.length() - 1)) {
				System.out.println(0);
			} else if (checkSimilarPalindrome(str)) {
				System.out.println(1);
			} else {
				System.out.println(2);
			}

		}

		br.close();
	}

	private static boolean checkSimilarPalindrome(String str) {

		int start = 0, end = str.length() - 1;

		while (start <= end) {
			if (str.charAt(start) != str.charAt(end)) {
				String str1 = str.substring(start + 1, end + 1);
				if (checkPalindrome(str1, 0, str1.length() - 1)) {
					return true;
				}
				String str2 = str.substring(start, end);
				if (checkPalindrome(str2, 0, str2.length() - 1)) {
					return true;
				}

				return false;
			}

			start++;
			end--;
		}

		return false;
	}

	private static boolean checkPalindrome(String str, int start, int end) {

		while (start <= end) {
			if (str.charAt(start) != str.charAt(end))
				return false;

			start++;
			end--;
		}

		return true;

	}
}
