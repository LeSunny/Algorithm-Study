import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] mark;
	static int bingoCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[5][5];
		mark = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				// 부를 숫자
				int marknum = Integer.parseInt(st.nextToken());
				cnt++;
				check(marknum);
//				System.out.println(marknum + " "+ cnt + " " + bingoCnt);
				if (bingoCnt >= 3)
					break;
			}
//			System.out.println(cnt + " " + bingoCnt);
			if(bingoCnt>=3)
				break;
		}
		System.out.println(cnt);

		br.close();
	}

	private static void check(int marknum) {
		for (int i=0; i < 5; i++) {
			for (int j=0; j < 5; j++) {
				if (map[i][j] == marknum) {
					mark[i][j] = true;
					checkBingo(i, j);
					return;
				}
			}
		}
	}

	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	private static void checkBingo(int y, int x) {
		int cnt = 0;
		// 가로 체크
		for (int i = 0; i < 5; i++) {
			if (mark[y][i])
				++cnt;
		}
		if (cnt == 5)
			bingoCnt++;
		cnt = 0;
		// 세로 체크
		for (int i = 0; i < 5; i++) {
			if(mark[i][x]) {
				++cnt;
			}
		}
		if(cnt==5) {
			bingoCnt++;
		}
		// 대각선 두개 체크
		if(y==x) {
			cnt=0;			
			for(int i=0; i<5; i++) {
				if(mark[i][i]) {
					++cnt;
				}
			}
			if(cnt==5) {
				bingoCnt++;
			}	
		}
		if(x==4-y) {
			cnt=0;
			for(int i=0; i<5; i++) {
				if(mark[i][4-i]) {
					++cnt;
				}
			}
			if(cnt==5) {
				bingoCnt++;
			}	
		}		
	}
}
