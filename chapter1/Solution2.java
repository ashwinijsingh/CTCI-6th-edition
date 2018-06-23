package chapter1;

public class Solution2 {

	/**
	 * 
	 PERMUTATION:
	 
	 1. Assumptions for this code:
	  	a. Whitespace is significant
	  	b. Case sensitive.
	  
	 2. Example of PERMUTATION:
	  The different ways in which the alphabets A, B and C can be grouped together,
	  Permutations are: ABC, ACB, BCA, CBA, CAB, BAC.
	 
	 *
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*  My solution	
		 
		 1. Define 2 sets of size 128 with integer array.
		 2. Set 1 will have count of string 1 characters based on ASCII position. Similarly Set 2.
		 3. Compare both the sets and of they are equal then its a Permutation
		 
		 
		 */
				String a = "center";
				String b = "centre";
						
				boolean flag = true;
				if (a.length() != b.length()) {
					flag = false;
				} 
				else 
				{
					int set1[] = new int[128];
					for (int i = 0; i < a.length(); i++) {				
						int value = a.charAt(i);
						set1[value]++;
					}
					

					int set2[] = new int[128];

					for (int i = 0; i < b.length(); i++) {
						int value = b.charAt(i);
						set2[value]++;
					}

					for (int i = 0; i < set1.length; i++) {
						if (set1[i] != set2[i]) {
							flag = false;
							break;
						}

					}
				}
				
				if(flag){
					System.out.println("Permutation");
				}
				else{
					System.out.println("Not Permutation");
				}	
		
		
	Solution2 ob=new Solution2();
		
	/* First solution	:
	   
	   1. Sort s1 & s2: 
	   	  -> Convert s1 & s2 to character array: char[] array =s1.tocharArray()
	      -> JAVA.UTIL.ARRAYS.SORT(Character array);
	   2. check if the sorted arrays are equal
	  
	   This solution is not very efficient.

	 * */
		
	String s1="center";
	String s2="centre";
	System.out.println("-- First Solution --");
	System.out.println("s2 is permutation of s1 : "+ob.isPermutation1(s1,s2));
	
	/*
	 * Second Solution :
	 
	 1. Similar to my solution but here we Define 1 set of size 128 with integer array.
	 2. while checking for the second string we check for the ASCII values and now we decrement the set.
	 3. If the at any point the integer array is less than 0 then it is not a permutation. 
	  	
	 */
	
	
	System.out.println("-- Second Solution --");
	System.out.println("s2 is permutation of s1 : "+ob.isPermutation2(s1,s2));
	

	}
	
	String sort(String s){
		char[] stringchar=s.toCharArray();
		java.util.Arrays.sort(stringchar);
		return new String(stringchar);
		
	}

	boolean isPermutation1(String s1,String s2){
		return sort(s1).equals(sort(s2));
	}
	
	boolean isPermutation2(String s1,String s2){
			
		int[] stringchar=new int[128];
		for (int i = 0; i < s1.length(); i++) {			
			stringchar[s1.charAt(i)]++;
		}
		
		for (int i = 0; i < s2.length(); i++) {
				stringchar[s2.charAt(i)]--;
				if(stringchar[i]<0){
					return false;
				}

		}
		return true;
	}
	
}
