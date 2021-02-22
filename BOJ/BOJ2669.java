import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] map = new int[100][100];
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int startx = Integer.parseInt(st.nextToken());
			int starty = Integer.parseInt(st.nextToken());
			int endx = Integer.parseInt(st.nextToken());
			int endy = Integer.parseInt(st.nextToken());

			for (int y = starty; y < endy; y++) {
				for (int x = startx; x < endx; x++) {
					map[y][x] = 1;
				}
			}
		}

		int sum = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				sum += map[i][j];
			}
		}

		System.out.println(sum);

		br.close();
	}
}
