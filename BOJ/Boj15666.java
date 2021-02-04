import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Boj15666 {

	static int n;
	static int m;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> hs = new HashSet<String>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split("\\s");
		String[] numsInfo = br.readLine().split("\\s");

		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);

		nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(numsInfo[i]);
		}
		Arrays.sort(nums);

		makeCombination(0, new int[m], 0);
		System.out.println(sb);
	}

	private static void makeCombination(int cnt, int[] combArr, int startIdx) {
		if (cnt == m) {
			String s = "";
			for (int i = 0; i < m; i++) {
				s += combArr[i];
				s += " ";
			}

			if (!hs.contains(s)) {
				for (int i = 0; i < m; i++) {
					sb.append(combArr[i]);
					if (i == m - 1)
						break;
					sb.append(" ");
				}
				sb.append("\n");
				hs.add(s);
			}

			return;
		}

		for (int i = startIdx; i < n; i++) {
			combArr[cnt] = nums[i];
			makeCombination(cnt + 1, combArr, i);
		}
	}

}
