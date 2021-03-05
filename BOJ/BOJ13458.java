import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] p = new int[N];
		long result = N;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		String[] bc = br.readLine().split("\\s");
		int b = Integer.parseInt(bc[0]);
		int c = Integer.parseInt(bc[1]);

		for (int i = 0; i < N; i++) {
			p[i] -= b;
			if (p[i] <= 0)
				continue;

			result += p[i] / c;
			if (p[i] % c != 0)
				result++;
		}

		System.out.println(result);

		br.close();

	}
}
