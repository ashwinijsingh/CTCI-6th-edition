package chapter5;

public class Solution4 {

	/**
	 * Sorted search : No size
	 */
	public static void main(String[] args) {
		
		int[] array = {1, 2, 4, 5,7,8};
		Listy list=new Listy(array);
		System.out.println(search(list,2));
		System.out.println(search(list,9));
	}
	
	public static int search(Listy list,int value){
		int index=1;
		while(list.elementAt(index)!=-1 && list.elementAt(index)<value){
			index*=2;
		}
		return binarySearch(list,value,index/2,index);
	}
	
	public static int binarySearch(Listy list,int value,int low,int high){
		int mid;
		
		while(low<=high){
		mid=(low+high)/2;
		int middle=list.elementAt(mid);
		if(middle>value || middle==-1){
			high=mid-1;
		}
		else if(middle<value){
			low=mid+1;
		}
		else{
			return mid;
		}
		
	}
	return -1;
	}
}
