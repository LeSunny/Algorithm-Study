package swea;

import java.io.*;

class SWEA2805 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int result = 0;
            if (n == 1)
                result = Integer.parseInt(br.readLine());
            else {
                int[][] map = new int[n][n];
                for (int i = 0; i < n; i++) {
                    String row = br.readLine();
                    for (int j = 0; j < n; j++) {
                        map[i][j] = Integer.parseInt(row.substring(j, j + 1));
                    }
                }
 
                for (int i = 0; i <= n / 2; i++) {
                    for (int j = n / 2 - i; j <= n / 2 + i; j++) {
                        //System.out.println(i + " " + j);
                        result += map[i][j];
                    }
                }
                for (int i = n / 2 + 1; i < n; i++) {
                    // n/2-(n-i-1) ~ n/2+(n-i-1)
                    for (int j = n / 2 - (n - i - 1); j <= n / 2 + (n - i - 1); j++) {
                        //System.out.println(i + " " + j);
                        result += map[i][j];
                    }
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}