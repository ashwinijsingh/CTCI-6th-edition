package chapter1;

public class Solution8 {

	/**
	 * ZERO MATRIX: If any element is 0 then we make the row and column as zero.
	 1. If we use a second matrix the the space would be O(MN). Hence Solution 1: O(N) and Solution2: O(1)  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	/*	int matrix[][]={ 
			    { 1, 2, 3, 4 ,5,6}, 
			    { 7,0,9,10,11, 12}, 
			    { 13,10,15,16,17,18}, 
			    { 19,20,0,22 ,23,24},
			    { 25,26,27,28,29,30},
			    { 31,32,33,34,35,36}
			};	
		*/
		Solution8 ob=new Solution8();
		//Solution 1
		int matrix[][]={ 
			    { 0,10,13,14}, 
			    { 17,0,19,10}, 
			    { 13,10,15,16}, 
			    { 19,20,10,22},
			  
			};
		ob.setZeros(matrix);
		
		//Solution 2
		int matrix1[][]={ 
			    { 0,10,13,14}, 
			    { 17,0,19,10}, 
			    { 13,10,15,16}, 
			    { 19,20,10,22},
			  
			};
		ob.setZerosEfficient(matrix1);
		}
	
/*SOLUTION 1: 
 1.We use two arrays 
	 	i. ROW[] -> tracks all the rows which has zero.
	   ii. COLUMN[]-> tracks all the columns which has zero
 2. Space complexity=O(N) N-> Array size
 */
	
	void setZeros(int[][] matrix){
	    int r=matrix[0].length; // this will give the row length
		int c=matrix.length;    // this will give the column length
		boolean[] row=new boolean[r];
		boolean[] column=new boolean[c];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(matrix[i][j]==0){
					row[i]=true;
					column[j]=true;
				}
				
			}
		}
		
		for (int i = 0; i <r; i++) {
			if(row[i]){
			nullifyrow(matrix,i);
				
			}
			
		}
		
		for (int i = 0; i <c; i++) {
			if(column[i]){
			nullifycolumn(matrix,i);
				
			}
			
		}
		
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
		
	}

/*SOLUTION 2: 

1.We use the matrix itself 
		 	i. Use the matrix row -> tracks all the rows which has zero.
		   ii. Use the matrix column -> tracks all the columns which has zero.
2. Space complexity=O(1)
*/
	void setZerosEfficient(int[][] matrix){
		
		boolean firstrowhaszero=false;
		boolean firstcolumnhaszero=false;
		
		//Check if first row has zero
		for (int j = 0; j < matrix[0].length; j++) {
			if(matrix[0][j]==0){
				firstrowhaszero=true;
				break;
			}
		}
		
		//Check if first column has zero
		for (int i = 0 ; i < matrix.length; i++) {
			if(matrix[i][0]==0){
				firstcolumnhaszero=true;
				break;
			}
		}
		
		 
		for (int i = 1; i < matrix.length; i++) { // make sure we start from second row
			for (int j = 1; j < matrix[0].length; j++) { // make sure we start from first row
				if(matrix[i][j]==0){   // If we find any zero in the matrix
					matrix[i][0]=0;    // We set the corresponding first row and first column value to zero
					matrix[0][j]=0;
				}
				
			}
		}
		
		// For nullifying the row we keep column=0 and traverse through row i->1 to column length
		for (int i = 1; i <matrix.length; i++) {
			if(matrix[i][0]==0){
			nullifyrow(matrix,i);
				
			}
			
		}
		
		// For nullifying the column we keep row=0 and traverse through column j->1 to column length
		for (int j = 1; j <matrix[0].length; j++) {
			if(matrix[0][j]==0){
			nullifycolumn(matrix,j);
				
			}
			
		}
		
		//if first row had zero we make the first row zero
		if(firstrowhaszero){
			nullifyrow(matrix,0);
		}
		
		//if the the first column had zero we make it zero
		if(firstcolumnhaszero){
			nullifycolumn(matrix,0);
		}
		
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
		
	}

	
		/*
		 * NULLIFY ROW METHOD
		 */
		void nullifyrow(int[][] matrix, int row) {
			// TODO Auto-generated method stub
			 for (int j = 0; j < matrix[0].length; j++) {
				matrix[row][j]=0;
			}
			 
			
	}
		
		/*
		 * NULLIFY COLUMN METHOD
		 */
		void nullifycolumn(int[][] matrix, int column) {
			// TODO Auto-generated method stub
			 for (int j = 0; j < matrix.length; j++) {
				matrix[j][column]=0;
			}
	}
}

	
		
	




