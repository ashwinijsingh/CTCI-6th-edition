package chapter5;

public class Listy {

	int[] array;
	
	Listy(int[] arr){
		array=arr.clone();
	}
	
	public int elementAt(int index){
		if(index >=array.length){
			return -1;
		}
		return array[index];
	}
}
