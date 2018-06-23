package chapter3;

import java.util.Stack;

public class Solution2StackWithMin2 extends Stack<Integer>{
	 Stack<Integer> s2;
	 
	 public Solution2StackWithMin2(){
		 s2=new Stack<Integer>();
	 }
	
	 void push(int value){
		 if(value< min()){
			 s2.push(value);
		 }
		 super.push(value);
	 }
	 
	 public Integer pop(){
		 int poppedValue=super.pop();
		 if(poppedValue==min()){
			 s2.pop();
		 }
		 return poppedValue;
	 }
	 
	 int min(){
		 if(s2.isEmpty()){
			 return Integer.MAX_VALUE;
		 }
		 else{
			 return s2.peek();
		 }
	 }

}
