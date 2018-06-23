package chapter3;

public class Solution2 {

	/**
	 * STACK MINIMUM:
	 * 1) Push , Pop and Min should work in O(1) time.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* First solution	:
		1.	Keep a track of minimum every time a value is added to the stack 
	    		a. NODE: each node will have minimum recorded
		 * */
		
		Solution2StackWithMin ob=new Solution2StackWithMin();
		ob.push(5);
		ob.push(6);
		ob.push(3);
		ob.push(7);
		System.out.println(ob.min());
		ob.pop();
		ob.pop();
		System.out.println(ob.min());
		//ob.pop();
		//System.out.println(ob.min());
		//ob.push(5);
		
		
		Solution2StackWithMin2 ob1=new Solution2StackWithMin2();
		ob1.push(5);
		ob1.push(6);
		ob1.push(3);
		ob1.push(7);
		System.out.println(ob1.min());
		ob1.pop();
		System.out.println(ob1.min());
		ob1.pop();
		System.out.println(ob1.min());
		
		
	}

}
