package chapter1;

public class Solution7 {

	/**
	 * ROTATE MATRIX (IMAGE)  N X N matrix:
	 
	 1. Why do we choose N/2: 
	 	->Because in a matrix when we finish outer rotation(layer 1) then we do rotation of layer 2.
	 	->The number of layers we do rotation is only N/2.
	 	  Example: 3 X 3 -> 1, 4 x 4 -> 2, 5 x 5->2 , 6x6->3... hence N/2 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][]={ 
		    { 1, 2, 3, 4 ,5,6}, 
		    { 7,8,9,10,11, 12}, 
		    { 13,14,15,16,17,18}, 
		    { 19,20,21,22 ,23,24},
		    { 25,26,27,28,29,30},
		    { 31,32,33,34,35,36}
		};
		
		int n=matrix.length; // this will give the column length
		int n1=matrix[0].length; // this will give the row length 
		
		if(n==0 || n!=n1) System.out.println("Not an N*N");
		
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
		
		System.out.println("-----");
		
		int val=n;
		for (int i = 0; i < n/2; i++) {      //1.
			int decrementer=val-1;
			int size=n-1-i;
			System.out.println("value "+val);
			System.out.println("x     "+decrementer);
			System.out.println("size  "+size);
			for (int j = i; j < size; j++) {
				
				
				int temp=matrix[i][j];
				matrix[i][j]=matrix[decrementer][i];
				matrix[decrementer][i]=matrix[size][decrementer];
				matrix[size][decrementer]=matrix[j][size];
				matrix[j][size]=temp;
				
				decrementer--;

			}
			val--;
			System.out.println("value after loop "+i+" is "+val);
			
		}
			for (int i = 0; i < matrix.length; i++) {
			    for (int j = 0; j < matrix[i].length; j++) {
			        System.out.print(matrix[i][j] + " ");
			    }
			    System.out.println();
			}
		
		

	}

}
