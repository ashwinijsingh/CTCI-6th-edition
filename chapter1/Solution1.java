package chapter1;
//https://github.com/careercup/CtCI-6th-Edition/tree/master/Java
//https://github.com/careercup/ctci/tree/master/java
//https://github.com/careercup/CtCI-6th-Edition-cpp
public class Solution1 {

	/**
	 * 
	 * Left out : Page 193 
	 * Doubt page 192
	 * 
	 * UNIQUE CHARACTERS IN A STRING:
		
		1. Ask the Interviewer if the String is ASCII or Unicode String
		2. In this program we have assumed that the character set is ASCII 
		   If we do not assume this then we will have to increase the storage
		3. ASCII: -> 8 bit encoding.
		 		  -> Assigns values to only 128 characters 
		 		  	 (a-z, A-Z, space, some punctuation and some control characters)
		  Unicode:-> Unicode is a way to assign unique numbers (code points) to  characters from all languages
		  			 in active use today.
		  
		  For every character that has ASCII value, the unicode point and the ASCII value of that character is the same. 
		4. Below code:
			-> Time complexity : O(N)
			-> Space complexity: O(1).		
		
		 
		5. If we cant do additional data structure then we can do the following:
			
			a. Compare each character to very other character in the string. 
			   This will take O(N^2) time and O(1) space.
			b. If the modification of the string is allowed then we can sort the string in O(Nlog(N)) time and 
			   then linearly check the string. Many sorting algorithms may take up extra space.
			 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		String str1="iiiii";
		boolean flag=true; 
		
		// if the length of the string is greater than 128 then the string will not have unique code
		if(str1.length()>128){
			flag=false;
		}
		else{
		// declare a boolean array for length 128(ASCII size). Default value is zero.
		boolean set[]=new boolean[128];
		
		/*
		 * if you assign character value to an integer you will get the ASCII value of that character.
		int value=str1.charAt(0);
		System.out.println("value : "+value)
		op: value : 105
		
		*/
		for (int i = 0; i < str1.length(); i++) {
			int value=str1.charAt(i);
			
			if(set[value]){
				// the value is found second time. hence not unique
				flag=false;
				break;
			}
			/*
			 ->first time the value is found
			 ->We set the value of the position equal to ASCII vale to true in the boolean set
			*/
			set[value]=true;		
			
		}
		
		if(flag){
			System.out.println("The String is unique");
		}
		else{
			System.out.println("The string is not unique");
		}
			
		}
	
		
		
		
		

		
		
		

	}

}
