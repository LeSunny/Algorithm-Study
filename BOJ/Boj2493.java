package boj;

import java.io.*;
import java.util.Stack;

class Tower {
	long height;
	int position;

	public Tower(long height, int position) {
		this.height = height;
		this.position = position;
	}

}

public class Boj2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		Stack<Tower> stack = new Stack<Tower>();
		String[] towers = br.readLine().split("\\s");
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=num; i++) {
			long tall = Long.parseLong(towers[i-1]);
			while(!stack.isEmpty()) {
				if(stack.peek().height >= tall) {
					sb.append(stack.peek().position);
					sb.append(" ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) sb.append("0 ");
			stack.push(new Tower(tall, i));
		}
		System.out.println(sb);
		br.close();
	}

}
