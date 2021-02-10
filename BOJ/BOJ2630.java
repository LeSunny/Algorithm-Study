package boj;

import java.io.*;

public class BOJ2630 {
	static int blue;
	static int white;
	static int[][] paper;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split("\\s");
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		divideNconquer(0, 0, n, n);
		System.out.println(white);
		System.out.println(blue);

		br.close();
	}

	private static void divideNconquer(int startX, int startY, int endX, int endY) {
		int color = paper[startY][startX];
		if(endX- startX==1) {
			if(color==1)
				blue++;
			else
				white++;
			return;
		}else if(endX==startX)
			return;
		
//		System.out.println(startX+", "+startY+" // "+ endX+", "+endY);

		boolean flag = true;
		
		for(int i=startY; i<endY; i++) {
			for(int j=startX; j<endX; j++) {
				if(paper[i][j] != color) {
					flag = false;
					break;
				}
			}
		}
		
		if(flag) {
			if(color == 1) {
				blue++;
			}else {
				white++;
			}
		}else {
			divideNconquer(startX, startY, startX+(endX-startX)/2, startY+(endY-startY)/2);
			divideNconquer(startX, startY+(endY-startY)/2, startX+(endX-startX)/2, endY);
			divideNconquer(startX+(endX-startX)/2, startY, endX, startY+(endY-startY)/2);
			divideNconquer(startX+(endX-startX)/2, startY+(endY-startY)/2, endX, endY);
		}
	}

}
