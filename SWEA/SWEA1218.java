package swea;

import java.io.*;
import java.util.Stack;

public class SWEA1218 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int len = Integer.parseInt(br.readLine());
			Stack<String> stack = new Stack<String>();
			String line = br.readLine();

			boolean flag = true;

			for (int i = 0; i < len; i++) {
				String bracket = line.substring(i, i + 1);
				if (bracket.equals("(") || bracket.equals("{") || bracket.equals("[") || bracket.equals("<"))
					stack.push(bracket);

				if (bracket.equals(")")) {
					if (!stack.isEmpty() && stack.peek().equals("("))
						stack.pop();
					else {
						flag = false;
						break;
					}
				} else if (bracket.equals("}")) {
					if (!stack.isEmpty() && stack.peek().equals("{"))
						stack.pop();
					else {
						flag = false;
						break;
					}
				} else if (bracket.equals("]")) {
					if (!stack.isEmpty() && stack.peek().equals("["))
						stack.pop();
					else {
						flag = false;
						break;
					}
				} else if (bracket.equals(">")) {
					if (!stack.isEmpty() && stack.peek().equals("<"))
						stack.pop();
					else {
						flag = false;
						break;
					}
				}
			}

			if (flag && stack.isEmpty())
				System.out.println("#" + t + " " + 1);
			else
				System.out.println("#" + t + " " + 0);

		}
		br.close();
	}

}
