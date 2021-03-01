import java.io.*;
import java.util.*;

public class Main {

	static boolean[] brokenNum = new boolean[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int broken = Integer.parseInt(br.readLine());
		int ans = Math.abs(N - 100); // 초기 채널 100 (모든 버튼이 고장났을 경우 대비)

		if (broken > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < broken; i++) {
				brokenNum[Integer.parseInt(st.nextToken())] = true;
			}
		}

		for (int i = 0; i < 1000000; i++) {
			int n = i;
			int len = count(n);

			if (len > 0) {
				int press = Math.abs(i - N);
				ans = Math.min(ans, len + press);
			}
		}

		System.out.println(ans);

		br.close();
	}

	private static int count(int n) {
		if (n == 0) {
			if (brokenNum[n])
				return 0;
			else
				return 1;
		}
		int len = 0;
		while (n > 0) {
			if (brokenNum[n % 10])
				return 0;
			len++;
			n /= 10;
		}
		return len;
	}
}
