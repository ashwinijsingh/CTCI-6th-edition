package chapter5;

import java.util.Arrays;
import java.util.Comparator;


//Solution 2
public class AnagramComparator implements Comparator<String>{

	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(sortChars(s2));
	}
	
	public String sortChars(String s){
		char[] content=s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	
}
