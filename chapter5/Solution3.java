package chapter5;

public class Solution3 {

	/**
	 * Rotated Arrays
	 */
	public static void main(String[] args) {
		int[] a = { 2, 3, 2,1, 2, 2, 2, 7 , 9 , 2 };

			System.out.println(search(a, 2));
			System.out.println(search(a, 3));
			System.out.println(search(a, 4));
			System.out.println(search(a, 1));
			System.out.println(search(a, 7));
			System.out.println(search(a, 3));
			System.out.println(search(a, 9));
		

	}
	
	public static int search(int a[], int x) {
		return search(a, 0, a.length - 1, x);
	}

	
	public static int search(int a[],int left,int right,int x){
		int mid=(left+right)/2;
		
		if(a[mid]==x){ //found element
			return mid;
		}
		if(right<left){ //not found
			return -1;
		}
		
		if(a[mid]>a[left]){ // left is normally ordered
			if(x>=a[left] && x<a[mid]){
				return search(a,left,mid-1,x); //search left
			}
			else{
				return search(a,mid+1,right,x); //search right
			}
			
		}
		else if(a[mid]<a[left]){ //right is normally ordered
			if(x>=a[mid] && x<a[right]){  
			return search(a,mid+1,right,x); //search right
			}
			else{
				return search(a,left,mid-1,x); //search left
			}
		}
		else if(a[mid]==a[left]){ //if left or right is same as mid
			if(a[mid]!=a[right]){ //if mid is not the same as right
				return search(a,mid+1,right,x); //search right
			}
			else{
				
				int result=search(a,left,mid-1,x);
				if(result == -1){
					return search(a,mid+1,right,x);
				}
				else{
					return result;
				}
			}
		}
		return -1;
	}

}
