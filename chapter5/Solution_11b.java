package chapter5;

public class Solution_11b {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int array[]= {5,3,1,2,3};
		peakAndValley(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(" "+array[i]);
		}

	}
	
	public static void peakAndValley(int[] array){
		for (int i = 1; i < array.length; i+=2) {
			int max=indexMax(array,i-1,i,i+1);
			if(i!=max){
				swap(array,i,max);
			}
			
		}
	}
	
	public static int indexMax(int[] array,int a,int b,int c){
		int len=array.length;
		int aValue=a>=0 && a<len?array[a]:Integer.MIN_VALUE;				
		int bValue=b>=0 && b<len?array[b]:Integer.MIN_VALUE;
		int cValue=c>=0 && c<len?array[c]:Integer.MIN_VALUE;
		
		int max=Math.max(aValue, Math.max(bValue, cValue));
		if(max==aValue) return a;
   else if(max==bValue) return b;
   else return c;
	}
	
	
	public static void swap(int[] array, int left, int right) {

		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}


}
