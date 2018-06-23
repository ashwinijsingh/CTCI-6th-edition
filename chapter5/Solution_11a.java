package chapter5;

import java.util.Arrays;

public class Solution_11a {
	
	public static void main(String args[]){
		int[] array = {5,3,1,2,3};
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " +array[i]);
		}
		
		peakAndValley(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " +array[i]);
		}
		
	}
	
	
	public static void peakAndValley(int[] array){
		
		Arrays.sort(array);
		
//		System.out.println("");
//		for (int i = 0; i < array.length; i++) {
//			System.out.print(" " +array[i]);
//		}
//		System.out.println("");
//		
		
		for (int i = 1; i < array.length; i += 2) {
			swap(array, i - 1, i);
		}
	}
	
	public static void swap(int[] array, int left, int right) {
		
//		System.out.println(" left "+left+"right "+right);
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

}
