package boj;

import java.io.*;
import java.util.Stack;


/* 후위 표기식 */
public class BOJ1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String expression = br.readLine();
		int len = expression.length();
		StringBuilder sb = new StringBuilder();
		Stack<Character> operatorStack = new Stack<Character>();
		
		for(int i = 0; i < len; i++) {
			char token = expression.charAt(i);
			
      // 숫자일 때
			if('A' <= token && token <= 'Z') {
				sb.append(token);
			} else if(token == ')') {
				while(!operatorStack.isEmpty()) {
					if(operatorStack.peek() == '(') {
						operatorStack.pop();
						break;
					}
					sb.append(operatorStack.pop());
				}
			} else {
				while(!operatorStack.isEmpty()) {
					int point = 3; // 왼 괄호
					if(token=='+' || token =='-')
						point = 1;
					else if(token == '*' || token == '/')
						point = 2;
					
					int topPoint = 0;
					if(operatorStack.peek()=='+' || operatorStack.peek() =='-')
						topPoint = 1;
					else if(operatorStack.peek() == '*' || operatorStack.peek() == '/')
						topPoint = 2;
					
					if(topPoint < point) { // token의 우선순위가 더 높을 때 push
						operatorStack.push(token);
						break;
					}
					sb.append(operatorStack.pop());
				}
				if(operatorStack.isEmpty()){
					operatorStack.push(token);
				}
			}
			
		}
		while(!operatorStack.isEmpty()) { // 남아있는 연산자를 sb에 더해준다
			sb.append(operatorStack.pop());
		}
		
		System.out.println(sb);
		
		br.close();
	}
}
