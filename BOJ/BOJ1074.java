package boj;

import java.io.*;

public class BOJ1074_2 {

	static int num = 0;
	static int r;
	static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] info = br.readLine().split("\\s");
		int n = Integer.parseInt(info[0]);
		r = Integer.parseInt(info[1]);
		c = Integer.parseInt(info[2]);

		drawZ(n, 0, 0, r, c);
		br.close();
	}

	private static void drawZ(int n, int x, int y, int r, int c) {
		if (n == 0) {
			if (y == r && x == c)
				System.out.println(num);
			else
				num++;
			return;
		}

		if (y <= r && r < y + (int) Math.pow(2, n - 1) && x <= c && c < x + (int) Math.pow(2, n - 1)) {
			drawZ(n - 1, x, y, r, c);
		} else if (y <= r && r < y + (int) Math.pow(2, n - 1) && c >= x + (int) Math.pow(2, n - 1)
				&& c < x + (int) Math.pow(2, n)) {
			num += Math.pow(2, (n - 1) * 2);
			drawZ(n - 1, x + (int) Math.pow(2, n - 1), y, r, c);
		} else if (r < y + (int) Math.pow(2, n) && r >= y + (int) Math.pow(2, n - 1) && c >= x
				&& c < x + (int) Math.pow(2, n - 1)) {
			num += Math.pow(2, (n - 1) * 2) * 2;
			drawZ(n - 1, x, y + (int) Math.pow(2, n - 1), r, c);
		} else {
			num += Math.pow(2, (n - 1) * 2) * 3;
			drawZ(n - 1, x + (int) Math.pow(2, n - 1), y + (int) Math.pow(2, n - 1), r, c);
		}
	}

}
