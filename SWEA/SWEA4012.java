package swea;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/* [모의 SW 역량테스트] 요리사 */
public class SWEA4012 {

	static int min;
	static StringBuilder sb;
	static int N;
	static int[] mark;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;

			makeCombination(0, 0, new int[N / 2]);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	static int sum1;
	static int sum2;

	private static void makeCombination(int cnt, int start, int[] ingredients) {
		if (cnt == N / 2) {
			sum1 = 0;
			sum2 = 0;
			makeSumComb(0, ingredients, new int[2], 0, true);

			int[] ingredients2 = new int[N / 2];
			int j = 0, h = 0;
			for (int i = 0; i < N && h < N / 2; i++) {
				if (j < N / 2 && ingredients[j] != i) {
					ingredients2[h] = i;
					h++;
				} else if (j < N / 2 && ingredients[j] == i)
					j++;
				else {
					ingredients2[h++] = i;
				}

			}
			makeSumComb(0, ingredients2, new int[2], 0, false);

			min = Math.min(min, Math.abs(sum1 - sum2));

			return;
		}

		for (int i = start; i < N; i++) {
			ingredients[cnt] = i;
			makeCombination(cnt + 1, i + 1, ingredients);
		}
	}

	private static void makeSumComb(int cnt, int[] ingredients, int[] arr, int start, boolean flag) {
		if (cnt == 2) {
			if (flag)
				sum1 += map[arr[0]][arr[1]] + map[arr[1]][arr[0]];
			else
				sum2 += map[arr[0]][arr[1]] + map[arr[1]][arr[0]];

			return;
		}

		for (int i = start; i < N / 2; i++) {
			arr[cnt] = ingredients[i];
			makeSumComb(cnt + 1, ingredients, arr, i + 1, flag);
		}
	}

}
