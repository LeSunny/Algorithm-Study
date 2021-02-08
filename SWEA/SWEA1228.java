package swea;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SWEA1228 {
	static ArrayList<String> nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			nums = new ArrayList<String>();
			String[] original = br.readLine().split("\\s");

			for (int i = 0; i < n; i++) {
				nums.add(original[i]);
			}

			int comN = Integer.parseInt(br.readLine());
			String[][] commands = new String[comN+1][];
			String[] tmpCommands = br.readLine().split("I");

			for (int i = 0; i < comN+1; i++) {
				String command = tmpCommands[i].trim();
				if (!command.equals("")) {
					commands[i] = command.split("\\s");
					insertNums(commands[i]);
				}
			}
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(nums.get(i));
				if (i == 9)
					break;
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void insertNums(String[] command) {
		int pos = Integer.parseInt(command[0]);
		int n = Integer.parseInt(command[1]);

		for (int i = 2; i < 2 + n; i++) {
			nums.add(pos + i - 2, command[i]);
		}
	}

}
