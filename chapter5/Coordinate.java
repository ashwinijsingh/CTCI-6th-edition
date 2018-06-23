package chapter5;



public class Coordinate implements Cloneable {
	int row,column;
	
	public Coordinate(int r,int c){
		row=r;
		column=c;
	}
	public Object clone() { 
		return new Coordinate(row, column);
	}
	
	public boolean inBounds(int[][] matrix){
		return row>=0 && column>=0 && row<matrix.length && column <matrix[0].length;
	}
	
	public boolean isBefore(Coordinate p){
		return row<=p.row && column <=p.column;
	}
	
	public void setToAverage(Coordinate start,Coordinate end){
		row=(start.row+end.row)/2;
		column=(start.column+end.column)/2;
	}
	
	
}
