package chapter1;

public class Solution5 {

	/**
	 STRING : CHECK THAT THE STRING IS ONE/ZERO EDIT AWAY (INSERT, DELETE Or REPLACE a character)
	  
	  1.REPLACEMENT: Example : 'BALE' and 'PALE'
	  2.INSERTION: Example: 'APPLE' and 'APLE'
	  3.DELETION: Reverse of INSERTION 
	  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="apple";
		String str2="apple";
		Solution5 ob=new Solution5();
		if(str1.length()==str2.length()){
			System.out.println("One/Zero Edit replace : "+ob.replace(str1,str2));
			System.out.println("One/Zero Edit replace Solution 1: "+ob.insertreplace(str1,str2));
		}
		else if(str1.length() == str2.length()+1 ){
			System.out.println("One/Zero Edit delete : "+ob.insert(str2,str1));
			System.out.println("One/Zero Edit delete Solution2 : "+ob.insertreplace(str2,str1));
		}
		else if(str1.length()+1 == str2.length() ){
			System.out.println("One/Zero Edit insert : "+ob.insert(str1,str2)); 
			System.out.println("One/Zero Edit insert Solution 2: "+ob.insertreplace(str1,str2)); 
		}

	}

/* 
 	1.If the lengths are  different then insert/delete.
 	2.str1 < str2
 */
	boolean insert(String str1, String str2) {
		// TODO Auto-generated method stub
		int index1=0;
		int index2=0;
		
		while(index1<str1.length() && index2<str2.length()){
			if(str1.charAt(index1) != str2.charAt(index2)){ // -->1. if any character is not equal
				if(index1 != index2){   //                     -->4 if second time the character is not equal then we know that index1 != index 2
					return false;                          
				}
				index2++;   //                                 -->2. we increment index 2 (as string 1< string 2)
			}
			else{
				index1++;    //                                -->3. Else we increment both inex1 and index2
				index2++;                                   
			}
		}
		return true;
		

	}

/* 
 	1.If the lengths are the same then it is replace (str1==str2)
 	
 */	
	boolean replace(String str1, String str2) {
		// TODO Auto-generated method stub
		 
		 boolean founddifference=false;
		 for (int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i)!=str2.charAt(i)){ //              -->1. First time we find difference
				if(founddifference){//                          -->3. Second time we find the difference then re return false
					return false;
				}
				founddifference=true; //						-->2. We make founddifference value to true
			}
			
		}
		return true;
	}
	
	
	/*Solution 2:
	 * 
	
	*/
	boolean insertreplace(String str1, String str2) {
		// TODO Auto-generated method stub
		int index1=0;
		int index2=0;
		
		while(index1<str1.length() && index2<str2.length()){
			if(str1.charAt(index1) != str2.charAt(index2)){
				if(index1 != index2){
					return false;
				}
				
				if(str1.length()==str2.length()){
				index1++; // --> On replace move shorter pointer
				}
			}
			else{
				index1++; // --> If matching also move shorter pointer
			}
			index2++;// --> Always move longer pointer
		}
		return true;
		

	}

}
