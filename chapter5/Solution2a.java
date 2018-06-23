package chapter5;

import java.util.Arrays;

//Anagram Comparator

public class Solution2a {

	/**
	 *
	 */
	public static void main(String[] args) {
		String[] array={"apple","carrot","lee","tarroc","leppa","ele"};
		Arrays.sort(array,new AnagramComparator());
		for(String s:array){
			System.out.print(s+",");
		}
	}
	

}
