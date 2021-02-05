package swea;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class SWEA1223 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			String expression = br.readLine();
			ArrayList<String> ops = new ArrayList<String>();
			Stack<String> stack1 = new Stack<String>(); // 후위 연산으로의 변환을 위한 Stack(연산자만 들어감)
			Stack<Integer> stack2 = new Stack<Integer>(); // 계산을 위한 Stack

			for (int i = 0; i < n; i++) {
				String token = expression.substring(i,i+1);
				if(expression.charAt(i)-48 > 0 && expression.charAt(i)-48 < 10) {
					ops.add(token);
				}else {
					int tokenP = 0;
					if(token.equals("*")) tokenP = 1;
					
					if(stack1.isEmpty())
						stack1.push(token);
					else {
						while(!stack1.isEmpty()) {
							int topP = 0;
							if(stack1.peek().equals("*"))
								topP = 1;
							
							if(topP < tokenP) {
								stack1.push(token);
								break;
							}
							ops.add(stack1.pop());							
						}
						if(stack1.isEmpty())
							stack1.push(token);
					}
				}
			}
			while(!stack1.isEmpty()) {
				ops.add(stack1.pop());
			}
			
			
//			for(String s : ops)
//				System.out.print(s+" ");
//			System.out.println();

			int result = 0;
			for(int i=0; i<ops.size(); i++) {
				String token = ops.get(i);
				if(0 < token.charAt(0) - 48 && token.charAt(0) - 48 < 10) {
//					System.out.println("stack push "+ token);
					stack2.push(Integer.parseInt(token));
				}else {
					int op1 = stack2.pop();
					int op2 = stack2.pop();
//					System.out.println("stack pop "+ op1);
//					System.out.println("stack pop "+ op2);
					
					if(token.equals("*")) {
						result = op1 * op2;
//						System.out.println("stack * "+ result);
					}else if(token.equals("+")) {
						result = op1 + op2;
//						System.out.println("stack + "+ result);
					}else if(token.equals("-")) {
						result = op2 - op1;
//						System.out.println("stack - "+ result);
					}
					
					stack2.push(result);
				}
			}
			
			while(!stack2.isEmpty()) {
				System.out.println("#"+t+" "+stack2.pop());
			}			
		}
	}
}
