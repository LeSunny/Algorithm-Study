import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			int[][] cards = new int[2][4];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int num = Integer.parseInt(st.nextToken());

				for (int j = 1; j <= num; j++) {
					cards[i][Integer.parseInt(st.nextToken()) - 1]++;
				}
			}

			boolean flag = false;
			for (int i = 3; i >= 0; i--) {
				if (cards[0][i] > cards[1][i]) {
					System.out.println("A");
					flag = true;
					break;
				} else if (cards[0][i] < cards[1][i]) {
					System.out.println("B");
					flag = true;
					break;
				}
			}

			if (!flag)
				System.out.println("D");

		}

		br.close();
	}
}
