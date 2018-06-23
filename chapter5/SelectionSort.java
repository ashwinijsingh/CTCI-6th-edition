package chapter5;

public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = {5,7,4,3,8,10,60};
		doSelectionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}

	}
	
	 public static  void doSelectionSort(int[] arr){
         int len=arr.length;
	        for (int i = 0; i < len- 1; i++)
	        {
	            int index = i;
	            for (int j = i + 1; j < len; j++){
	                if (arr[j] < arr[index]) 
	                    index = j;
	            }
	            int smallerNumber = arr[index];  
	            arr[index] = arr[i];
	            arr[i] = smallerNumber;
	           
	        }
	    //    return arr;
	    }

}
