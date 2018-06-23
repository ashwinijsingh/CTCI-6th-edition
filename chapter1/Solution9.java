package chapter1;

public class Solution9 {

	/**
	 * STRING2 IS A ROTATION ON STRING1 : ONLY ONE CALL TO isSubstring()
	 	EXAMPLE: S1='waterbottle' and S2='erbottlewat' -> S2 is a rotation of S1
	 
	 	1. Now if we rotate S1 after 'wat' we get 'erbottlewat', so we cut S1 into two parts X and Y and rearrange them to get S2.
	 	   X->'wat' Y->'erbottle' then S2=YX.
	 	2. From the above method we can see that YX (S2) will always be a substring of XYXY (which is S1S1)
	 	   Hence we need to check if S2 is a Substring of S1S1.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1="anish";
		String s2="nisha";
		
		String s1s1=s1+s1;
		boolean isboolean;
		//System.out.println(s1s1.substring(0));
	
		System.out.println(s1s1.contains(s2));;

	}

}
