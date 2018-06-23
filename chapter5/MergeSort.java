package chapter5;

public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {5,7,4,3,8,10,60};
		mergesort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
	}
	
	public static void mergesort(int[] array) {
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length - 1);
	}

	public static void mergesort(int[] array, int[] helper, int low, int high) {
		if(low==high){
		return;
		}
		else{
			int middle = (low + high) / 2;
			mergesort(array, helper, low, middle); // Sort left half
			mergesort(array, helper, middle+1, high); // Sort right half
			System.out.println("Main array");
			System.out.println("low : "+low+" middle :"+middle+" high :"+high);
			merge(array, helper, low, middle, high); // Merge them
		}
	}

	public static void merge(int[] array, int[] helper, int low, int middle, int high) {
		/* Copy both halves into a helper array */
		System.out.println("---------------------------------------------");
		System.out.println("low : "+low+" middle :"+middle+" high :"+high);
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		System.out.println("Helper");
		for (int i = 0; i < helper.length; i++) {
			System.out.print(" "+helper[i]);
		}
		System.out.println();
		
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		
		System.out.println("helperLeft :"+helperLeft+" helperRight :"+helperRight+" current "+current);
		/* Iterate through helper array. Compare the left and right
		 * half, copying back the smaller element from the two halves
		 * into the original array. */
		while (helperLeft <= middle && helperRight <= high) {
			System.out.println("helperLeft :"+helperLeft+" helperRight :"+helperRight+"current :"+current);
			System.out.println("check : helperLeft <= middle && helperRight <= high");
			System.out.println("helperLeft "+helperLeft+" <= "+middle+" (middle)"+" && "+" helperRight "+helperRight+" <= "+high+" (high)"  );
			if (helper[helperLeft] <= helper[helperRight]) {
				System.out.println("helper[helperLeft] : "+helper[helperLeft]+" <= "+" helper[helperRight] "+helper[helperRight]);
				System.out.println("Hence ");
				System.out.println("array[current] : "+array[current]+" = "+" helper[helperLeft] "+helper[helperLeft]);
				array[current] = helper[helperLeft];
				helperLeft++;
			} else { // If right element is smaller than left element
				System.out.println("Else");
				System.out.println("helper[helperLeft] : "+helper[helperLeft]+" > "+" helper[helperRight] "+helper[helperRight]);
				System.out.println("array[current] : "+array[current]+" = "+" helper[helperRight] "+helper[helperRight]);
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
			System.out.println("helperLeft :"+helperLeft+" helperRight :"+helperRight+"current :"+current);
			System.out.println("check : helperLeft <= middle && helperRight <= high");
			System.out.println("helperLeft "+helperLeft+" <= "+middle+" (middle)"+" && "+" helperRight "+helperRight+" <= "+high+" (high)"  );
			
		}

		/* Copy the rest of the left side of the array into the
		 * target array */
		int remaining = middle - helperLeft;
		System.out.println("remaining = middle - helperLeft");
		System.out.println("remaining :"+remaining);
		for (int i = 0; i <= remaining; i++) {
			System.out.println("array[current + i] "+array[current + i]+" = "+helper[helperLeft + i]);
			array[current + i] = helper[helperLeft + i];
		}
	}

}
