package chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//Hash Map List 

public class Solution2b {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		sort(array);
	}
	
	public static void sort(String[] array){
		HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
		
		
		for(String value:array){
			String key=sortChars(value);//value.t
		
		//	list.add(value);
			if(!map.containsKey(key)){
				ArrayList<String> list=new ArrayList<String>();
				list.add(value);
				map.put(key, list);
			}
			else{
			map.get(key).add(value);
			}
		}
		
		int index=0;
		
		for(String key:map.keySet()){
			ArrayList<String> list=map.get(key);
			for(String value:list){
				array[index]=value;
				index++;
			}
		}
		
		for(String arr:array){
			System.out.print(arr+" ");
		}
		
		
	}
	
	public static String sortChars(String s){
		char[] content=s.toCharArray();
		Arrays.sort(content);
		return new String(content);
		
	}

}
