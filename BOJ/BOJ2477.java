import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());

		int maxGaro = Integer.MIN_VALUE;
		int garopos = 0;
		int maxSero = Integer.MIN_VALUE;
		int seropos = 0;
		int[] input = new int[6];
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			input[i] = len;

			if (dir == 1 || dir == 2) {
				maxGaro = Math.max(maxGaro, len);
				if (maxGaro == len) {
					garopos = i;
				}
			} else {
				maxSero = Math.max(maxSero, len);
				if (maxSero == len) {
					seropos = i;
				}
			}
		}

		int gp1 = garopos == 5 ? 0 : garopos + 1;
		int gp2 = garopos == 0 ? 5 : garopos - 1;

		int sp1 = seropos == 5 ? 0 : seropos + 1;
		int sp2 = seropos == 0 ? 5 : seropos - 1;

		int area = maxGaro * maxSero - (Math.abs(input[gp1] - input[gp2]) * (Math.abs(input[sp1] - input[sp2])));
		area *= K;
		System.out.println(area);

		br.close();
	}
}
