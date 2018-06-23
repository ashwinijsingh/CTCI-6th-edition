package chapter5;

public class Solution5 {
	public static void main(String args[]){
		 String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
	        System.out.println(search(stringList, "apple"));
	}
	
	public static int search(String[] strings,String str){
		if(str==""||str==null||str.isEmpty()){
			return -1;
		}
		
		return search(strings,0,strings.length-1,str);
		
	}
	
	public static int search(String[] strings,int first,int last,String str){
		if(first>last)
			return -1;
		int mid=(first+last)/2;
		
		if(strings[mid].isEmpty()){
			int left=mid-1;
			int right=mid+1;
		while(true){	
			
			if(left<first && right>last){
				return -1;
			}
			else if(right<=last &&!strings[right].isEmpty()){
				mid=right;
				break;
			}
			else if(left>=first && !strings[left].isEmpty()){
				mid=left;
				break;
			}
			left--; right++;
		}
		}
		
		if(str.equals(strings[mid])){
			return mid;
		}
		else if(strings[mid].compareTo(str)<0){
			return search(strings,mid+1,last,str);
		}
		else{
			return search(strings,first,mid-1,str);
		}
	}

}
