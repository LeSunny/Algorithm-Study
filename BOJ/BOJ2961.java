package boj;

import java.io.*;

class Flavor {
	int s;
	int b;

	public Flavor(int s, int b) {
		this.s = s;
		this.b = b;
	}
}

public class BOJ2961 {

	static int min = Integer.MAX_VALUE;
	static int N;
	static Flavor[] ingredients;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		ingredients = new Flavor[N];

		for (int n = 0; n < N; n++) {
			String[] input = br.readLine().split("\\s");
			int s = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			ingredients[n] = new Flavor(s, b);
		}

		makeSubset(0, 1, 0, 0, 0);

		System.out.println(min);

		br.close();
	}

	private static void makeSubset(int cnt, int s, int b, int startIdx, int totalcnt) {
		if (cnt == N) {
			if (totalcnt == 0)
				return;

			int sub = Math.abs(s - b);
			min = Math.min(min, sub);
			return;
		}

		for (int i = startIdx; i < N; i++) {
			makeSubset(cnt + 1, s * ingredients[cnt].s, b + ingredients[cnt].b, i + 1, totalcnt + 1);
			makeSubset(cnt + 1, s, b, i + 1, totalcnt);
		}
	}

}
