package swea;

import java.io.*;
import java.util.ArrayList;

class Ingredient {
	int grade;
	int calorie;

	public Ingredient(int grade, int calorie) {
		this.grade = grade;
		this.calorie = calorie;
	}
}

public class SWEA5215 {

	static ArrayList<Ingredient> ingredients;
	static int n;
	static int l;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			max = 0;
			ingredients = new ArrayList<Ingredient>();
			String[] info = br.readLine().split("\\s");
			n = Integer.parseInt(info[0]);
			l = Integer.parseInt(info[1]);
			
			for (int i = 0; i < n; i++) {
				String[] ingredient = br.readLine().split("\\s");
				ingredients.add(new Ingredient(Integer.parseInt(ingredient[0]), Integer.parseInt(ingredient[1])));
			}
			
			makeSubSet(0, new boolean[n]);
			System.out.println("#"+t+" "+max);
		}
		
		br.close();
	}

	private static void makeSubSet(int cnt, boolean[] isSelected) {
		if (cnt == n) {
			int calorieSum = 0;
			int gradeSum = 0;
			for (int i = 0; i < n; i++) {
				if (isSelected[i]) {
					calorieSum += ingredients.get(i).calorie;
					gradeSum += ingredients.get(i).grade;
				}
			}
			if (calorieSum > l)
				return;

			max = Math.max(max, gradeSum);
			return;
		}

		isSelected[cnt] = true;
		makeSubSet(cnt + 1, isSelected);
		isSelected[cnt] = false;
		makeSubSet(cnt + 1, isSelected);

	}

}
