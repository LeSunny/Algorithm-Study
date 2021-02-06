package swea;

import java.io.*;

/* 오목판정 */
public class SWEA11315 {

	static int[] dy = {0, 1, 1, 1};
	static int[] dx = {1, 1, -1, 0};
	static String[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int n = Integer.parseInt(br.readLine());
			map = new String[n][n];

			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = line.substring(j, j + 1);
				}
			}
			
			boolean flag = false;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j].equals("o") && findOmock(i, j, n)) {
						flag = true;
						break;
					}
				}
				if(flag) break;
			}
			
			String result = flag ? "YES" : "NO";
			sb.append("#").append(t).append(" ").append(result).append("\n");
			
		}
		System.out.print(sb);
		br.close();
	}
	
	private static boolean findOmock(int y, int x, int n) {
		// 팔방탐색
		for(int i=0; i<4; i++) {
			int cnt = 1;
			
			for(int j=1; j<5; j++) {
				if(y+dy[i]*j <0 || y+dy[i]*j >= n || x+dx[i]*j <0 || x+dx[i]*j >= n ) break;
				
				if(map[y+dy[i]*j][x+dx[i]*j].equals("o")) {
					++cnt;
					//System.out.println(cnt);
				}else {
					break;
				}
			}
			
			if(cnt == 5) {
				return true;
			}
		}
		
		return false;
	}
}
