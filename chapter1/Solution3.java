package chapter1;

public class Solution3 {

	/**
	 *URLify
	 *
	 * Doubt : Page 195 Using strings will allow us to implement in one pass ?
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1="Mr John Smith      ";
		
		System.out.println("Given String is :"+str1);
		
		
		
	 /*
	  * My Solution 
	   1. Split the string with spaces
	   2. Then concatenate the strings based on the split
	  * 
	  */
  
	    String list[]=str1.split(" ");
		String finalstring = null;
		

		for (int i = 0; i < list.length; i++) {
			
			
			if(i!=list.length-1)
			list[i]=list[i].concat("%20");
			
			if(i==0){
			finalstring=list[i];
			}
			else{
			finalstring=finalstring.concat(list[i]);
			}
			
		}
		
		System.out.println("My solution FINAL String is : "+finalstring);
		
		System.out.println("Given String is :"+str1);
		
		
		/*
		 SOLUTION 1:
		 
		 1. Assumption: 
		 	->Sufficient buffer in the end of the string.
		 	->the true length is provided
		 
		 2. Steps:

		    i.	We count the number of spaces
			ii.	The final length of the string will be = true length + number of spaces * 2
			iii.Traverse in reverse order in such a manner that if we see a space we insert ‘%20’ 
		 
		 Note:
		 We use Character Array instead in Strings as Strings are IMMUTABLE in Java. 

		 
		 
		 */
		
		int truelength=13;
		char char1[]=str1.toCharArray();
		
		
		System.out.print("The initial character array is :  ");
		for (int i = 0; i < char1.length; i++) {
			System.out.print(char1[i]);
			
		}
		
		System.out.println("\n String length array length :"+str1.length());
		System.out.println(" Character array length :"+char1.length);
		
		int space=0;
		
		//number of spaces
		for (int i = 0; i < truelength; i++) {
			if(char1[i] == ' '){
				space++;
			}
		}
		
		System.out.println(" Number of SPACES : "+space);		
		
		int finallength=truelength+2*space;		
		
		System.out.println("finallength :"+finallength);		
		
		
		// end of array
		if(truelength < char1.length)
		{
			char1[truelength]='\0';
		}
		
		
		for (int i = truelength-1; i > 0; i--) {
			if(char1[i] == ' '){
				char1[finallength-1]='0';
				char1[finallength-2]='2';
				char1[finallength-3]='%';
				finallength=finallength-3;
			}
			else{
				char1[finallength-1]=char1[i];
				finallength--;
			}
		}
		
		
		for (int i = 0; i < char1.length; i++) {
			System.out.print(char1[i]);
			
		}

		
		
	}
	
	
	
	

}
