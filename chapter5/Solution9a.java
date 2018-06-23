package chapter5;

public class Solution9a {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] matrix = {{15, 30,  50,  70,  73}, 
		 	 	  {35, 40, 100, 102, 120},
		 	 	  {36, 42, 105, 110, 125},
		 	 	  {46, 51, 106, 111, 130},
		 	 	  {48, 55, 109, 140, 150}};
		
		System.out.println(findElement(matrix,110));

	}
	
	public static boolean findElement(int[][] matrix,int elem){
		int row=0;
		int column=matrix[0].length-1;
		while(row<matrix.length && column>=0){
		if(elem == matrix[row][column]){
			return true;
		}
		else if(elem < matrix[row][column]){
			column--;
		}
		else{
			row++;
		}
		}
		
		return false;
	}
	
	

}
