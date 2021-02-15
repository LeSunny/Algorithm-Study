package boj;

import java.io.*;

public class BOJ3040 {

	static int[] people = new int[9];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			people[i] = Integer.parseInt(br.readLine());
		}
		
		makeCombination(0, new int[7], 0);
		
		br.close();
	}
	
	private static void makeCombination(int cnt, int[] dwarf, int startIdx) {
		if(cnt == 7) {
			int sum=0;
			for(int i=0; i<7; i++) {
				sum += dwarf[i];
			}
			if(sum==100) {
				for(int d : dwarf) {
					System.out.println(d);
				}
			}
			return;
		}
		
		for(int i=startIdx; i<9; i++) {
			dwarf[cnt] = people[i];
			makeCombination(cnt+1, dwarf, i+1);
		}
	}
	
}
