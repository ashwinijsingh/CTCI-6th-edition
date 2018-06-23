package chapter1;

public class Solution6 {

	/**
	 STRING COMPRESSION:
	 1. Example : aabbcccaa ->a2b2c3a12
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="abbaaaccbc";
		Solution6 ob=new Solution6();
		String solution1=ob.compressBad(str1);
		System.out.println("SOLUTION 1 : "+solution1);
		String solution2=ob.compress(str1);
		System.out.println("SOLUTION 2 : "+solution2);
		int length=ob.compressLengthcheck(str1);
		System.out.println("SOLUTION 3 : "+length);
		
		
	}
	
/* 
  SOLUTION 1: 
 1. The runtime of this is O(p+k^2) where p: size of the string k: number of character sequence
 2. Example: aabccdeeaa -> There are 6 character sequences a1bc2de2a2 
 					    -> It is slow because string concatenation operates on O(n2)
 */
	String compressBad(String str1){
		
		int consecutive=0;
		String finalstring="";
		
		for (int i = 0; i < str1.length(); i++) {
			consecutive++;
			if(i+1>=str1.length() || str1.charAt(i) !=str1.charAt(i+1)){
				finalstring+=""+str1.charAt(i)+consecutive;
				consecutive=0;
			}
		}
		return  finalstring.length()<str1.length()? finalstring : str1;
		
	}

/* SOLUTION 2: Page 89
 1. When we use Strings(Solution1) :
 		
 		i. On each concatenation we create a new copy of the string and two strings are copied over character by character.
 	   ii. First iteration we copy x characters then 2x.... nx : Hence O(xn^2).  (Math : 1+2+..n=n(n+1)/2 => O(n^2))
 
 2. StringBuilder :  Creates a resizable array of string.
 
 */
	String compress(String str1){
		
		StringBuilder finalstring=new StringBuilder();
		int consecutive=0;
		for (int i = 0; i < str1.length(); i++) {
			consecutive++;
			if(i+1>=str1.length() || str1.charAt(i)!=str1.charAt(i+1)){
				finalstring.append(str1.charAt(i));
				finalstring.append(consecutive);
				consecutive=0;
			}
			
		}
		return finalstring.toString().length()<str1.length()? finalstring.toString() : str1;
		
	}
	

/* SOLUTION 3:
 1. We check in advance if the compressed length is going to less than the g1ven string
 2. Advantage: When we don't have large set of repeating characters this will help us avoid in creating a string we never use. 
 3. Disadvantage: we will have to loop through all the characters twice and also duplicate code.
 * 
 */
	
	int compressLengthcheck(String str1){
		
		int finallength=0;
		int consecutive=0;
		for (int i = 0; i < str1.length(); i++) {
			consecutive++;
			if(i+1>=str1.length() || str1.charAt(i)!=str1.charAt(i+1)){
				finallength=finallength+1+String.valueOf(consecutive).length(); //--> we need to consider more that single digit value 
				consecutive=0;                     											//    for one character sequence
				
			}
			
		}
		return finallength;
		
	}

}
