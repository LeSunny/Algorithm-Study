package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA6808 {

	static StringBuilder sb = new StringBuilder();
	static int win, lose;
	static int[] gyoo, young;
	static boolean[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			win = 0;
			lose = 0;
			gyoo = new int[9];
			young = new int[9];
			nums = new boolean[18];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < 9; i++) {
				gyoo[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < 9; i++) {
				nums[gyoo[i] - 1] = true;
			}
			int j = 0;
			for (int i = 0; i < 18 && j < 9; i++) {
				if (!nums[i]) {
					young[j++] = i + 1;
				}
			}

			makePermutation(0, new int[9], new boolean[9]);

			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static void playGame(int[] youngs) {
		int gScore = 0;
		int yScore = 0;
		for (int i = 0; i < 9; i++) {
			if (gyoo[i] < youngs[i])
				yScore += (gyoo[i] + youngs[i]);
			else
				gScore += (gyoo[i] + youngs[i]);
		}

		if (gScore > yScore)
			win++;
		else if (gScore < yScore)
			lose++;
	}

	private static void makePermutation(int cnt, int[] permArr, boolean[] visited) {
		if (cnt == 9) {
			playGame(permArr);
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				permArr[cnt] = young[i];
				makePermutation(cnt + 1, permArr, visited);
				visited[i] = false;
			}
		}
	}

}
