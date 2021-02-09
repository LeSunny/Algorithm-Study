package boj;

import java.io.*;
import java.util.Stack;

public class BOJ10773 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0 && !stack.isEmpty())
				stack.pop();
			else
				stack.push(input);
		}

		int sum = 0;
		while (!stack.isEmpty())
			sum += stack.pop();

		System.out.println(sum);

		br.close();
	}

}
