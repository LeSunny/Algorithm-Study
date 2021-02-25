import java.io.*;
import java.util.*;

public class Main {
	static int width, height;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());

		ArrayList<Integer> garo = new ArrayList<Integer>();
		ArrayList<Integer> sero = new ArrayList<Integer>();
		garo.add(0);
		sero.add(0);
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			if (st.nextToken().equals("1")) {
				garo.add(Integer.parseInt(st.nextToken()));
			} else {
				sero.add(Integer.parseInt(st.nextToken()));
			}
		}

		garo.add(width);
		sero.add(height);

		Collections.sort(garo);
		Collections.sort(sero);

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < garo.size() - 1; i++) {
			for (int j = 0; j < sero.size() - 1; j++) {
				int area = (sero.get(j + 1) - sero.get(j)) * ((garo.get(i + 1) - garo.get(i)));
				max = Math.max(max, area);
			}
		}

		System.out.println(max);
		br.close();
	}
}
