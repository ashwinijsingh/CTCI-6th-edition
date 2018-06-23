package chapter3;

import java.util.Stack;

public class Solution5 {

	/**
	 * SORT STACK
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution5 ob=new Solution5();
		Stack<Integer> s=new Stack<Integer>();
			s.push(5);
			s.push(8);
			s.push(3);
			s.push(2);
			s.push(11);
			s=ob.sort(s);
			System.out.println("Sorted list");
			while(!s.isEmpty()){
				System.out.println(" "+s.pop());
			}
			
	}

	Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> r=new Stack<Integer>();
	
		while(!s.isEmpty()){
			int temp=s.pop();
			while(!r.isEmpty()&&r.peek()>temp){
				s.push(r.pop());
			}
			r.push(temp);
		}
		
		while(!r.isEmpty()){
			s.push(r.pop());
		}
		return s;
	}
}
