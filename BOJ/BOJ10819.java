import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Math;

public class Main{
	public static int calculate(int[] arr) {
		int max=0;
		for(int i=0;i<arr.length-1;i++) {
			max+=Math.abs(arr[i]-arr[i+1]);
		}
		return max;
	}
	public static int permutation(int[] perm, int number) {
		int max = -1;
        for(int i=1; i< number; i++) {
        	if(perm[i-1] < perm[i]) max = i;
        }
        	
        if(max==-1) {
        	return 0;
        }
        	
        int max2 = -1;
        for(int j=max ; j<number; j++) {
        	if(perm[max-1] < perm[j]) max2 = j;
        }
        	
        //swap i-1 <-> j
        int temp = perm[max-1];
        perm[max-1] = perm[max2];
        perm[max2] = temp;
        	
        ArrayList<Integer> tempArr = new ArrayList<>();
        for(int i=max ; i<number; i++) {
        	tempArr.add(perm[i]);
        }
        	
        Collections.reverse(tempArr);
        	
        for(int i=max; i<number; i++) {
        	perm[i] = tempArr.get(i-max);
        }
        int result=calculate(perm);
        
        return result;
	}
	public static int factorial(int n) {
		if(n==1) return 1;
		else return n*factorial(n-1);
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
    	int number = in.nextInt();
    	int[] arr = new int[number];
    	for(int i=0; i<number; i++) {
    		arr[i] = in.nextInt();
    	}
    	Arrays.sort(arr);
    	int t = factorial(number);
    	
    	int max=0;
    	for(int i=0; i<t;i++) {
    		int temp = permutation(arr,number);
    		if(max<temp)
    			max=temp;
    	}
    	System.out.println(max);
    }
}
