package chapter3;

public class Solution1 {

	/**
	 * Need to code and understand approach 2 228-229
	 * 
	 * THTREE IN ONE: Describe how you could use a single array to implement three stacks
	 * @throws FullStackException 
	 
	  
	 
	 */
	public static void main(String[] args) throws FullStackException {
		// TODO Auto-generated method stub
		/* First solution	:
		1.	Divide the array into equal parts.
	    2.	Disadvantage: One stack may run out of space while the others are nearly empty
		 * */
		Solution1FixedMultiStack ob=new Solution1FixedMultiStack(3);
		ob.push(0,1);
		ob.push(0,2);
		ob.push(0,3);
		ob.push(1,11);
		ob.push(1,12);
		ob.push(1,13);
		ob.push(2,21);
		ob.push(2,22);
		ob.push(2,23);
		
		System.out.println(ob.peek(2));
		System.out.println(ob.pop(2));
		System.out.println(ob.peek(2));
		System.out.println(ob.pop(2));
		System.out.println(ob.pop(2));
		//System.out.println(ob.pop(2));
		//ob.push(0, 14);
		
		/* Second solution	:
		1. Allow the stack blocks to be flexible in size.
		2. Shift elements as and when necessary if a stack exceeds its initial capacity
	    3. We will make use of circular array.	
		 * */
		
	}

}
