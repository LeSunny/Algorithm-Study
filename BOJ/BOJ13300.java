import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] info = br.readLine().split("\\s");
		
		int N = Integer.parseInt(info[0]);
		int K = Integer.parseInt(info[1]);
		int[][] arr = new int[6][2];

		for (int i = 0; i < N; i++) {
			String[] student = br.readLine().split("\\s");
			++arr[Integer.parseInt(student[1])-1][Integer.parseInt(student[0])];
		}

		int sum = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				sum += arr[i][j]/K;
				if(arr[i][j]%K!=0)
					sum++;
			}
		}
		System.out.println(sum);

		br.close();
	}
}
