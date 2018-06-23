package chapter1;

public class Solution4 {

	/**
	 * Missed page page 197 & 198 which Solution 3 (Vectors)
	 * 
	 * 
	 * PERMUTATION of PALINDROME:
	  
	  1. PALINDROME : String that is the same forwards and backwards.
	  2. CONDITION TO BE A PALINDROME: 
	  		i.  Need to have an even number of most of the characters.
	  		ii. At most one odd character (middle character)
	  
	  Note: As mentioned in Solution 2:
	  Example of PERMUTATION:
	  The different ways in which the alphabets A, B and C can be grouped together,
	  Permutations are: ABC, ACB, BCA, CBA, CAB, BAC.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str="abba";
		Solution4 ob=new Solution4();
		int[] table=ob.createTable(str);
		boolean foundodd=ob.checkpalindrome(table);
		System.out.println();
		
		
		System.out.print("SOLUTION 1 :");
		if(foundodd){
			System.out.print(" TRUE");
		}
		else{
			System.out.print(" FALSE");
		}
		System.out.println();
		System.out.println("SOLUTION 2 : "+ob.createCheckTable(str));
		
		
	}
	
	
	/* 1.In this method we create a table to see how many times a character will appear
	 */
	int[] createTable(String str){
		//System.out.println(Character.getNumericValue('z')); --- >35
		//System.out.println(Character.getNumericValue('a')); ---->10
		int[] newtable=new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		System.out.println("Size of the array : "+newtable.length);
		char[] ch=str.toCharArray();
		
	
		System.out.println("Character "+" Position ");
		for (int i = 0; i < ch.length; i++) {
			
			int value=getPosition(ch[i]);
			System.out.println(ch[i]+"  "+value);
			if(value != -1){
				newtable[value]++;
			}
		}
		
		for (int i = 0; i < newtable.length; i++) {
			System.out.print(" "+newtable[i]);
			
		}
		
		return newtable;
		
	}

	/*
	 1.  Map each letter in the string to a number.
	     Ex: a->0 b->1 c->2
	 2. This is case sensitive and any non-letter we map it to -1 
	 */
	 int getPosition(char c) {
		// TODO Auto-generated method stub
		 int a=Character.getNumericValue('a');
		 int z=Character.getNumericValue('z');
		 int val=Character.getNumericValue(c);
		 
		 if(a<=val && val<=z ){
			 return val-a;
		 }
		 
		 return -1;
	}
	 
	 
	 /*
	  1. We check that not more than one character is odd 
	  2. This is method is part of Solution 1 which is optimized in Solution 2
	  */
	 boolean checkpalindrome(int[] table){
		 
		 boolean foundodd=false;
		 
		 for (int i = 0; i < table.length; i++) {
			if(table[i]%2 == 1){
				if(foundodd){
					
					return false;				
				}
				foundodd =true;
			}
		}
		 return true;
	 }
	 
	 /* This is similar to Solution 1 but here as we create the table we check if it a palindrome or not
	  * We need not call a separate function
	  * */
	 
	 
		boolean createCheckTable(String str){
			
			int[] newtable=new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
			System.out.println("Size of the array : "+newtable.length);
			char[] ch=str.toCharArray();
			int countodd=0;
		
			System.out.println("Character "+" Position ");
			for (int i = 0; i < ch.length; i++) {
				
				int value=getPosition(ch[i]);
				System.out.println(ch[i]+"  "+value);
				if(value != -1){
					newtable[value]++;
					if(newtable[value]%2==1){ //-----> This is the check that we do in SOLUTION 2
						countodd++;
					}
					else{
						countodd--;
					}
				}
			}
			
			return countodd<=1; //---> at the end the odd number should be less that or equal to one
			
		}

}
