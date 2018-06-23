package chapter3;

import java.util.Stack;

public class Solution2StackWithMin extends Stack<Solution2NodeWithMin>{

	public void push(int value){
		int newMin=Math.min(value, min());
		super.push(new Solution2NodeWithMin(value,newMin));
	}
	
	
	public int min(){
		if(this.isEmpty()){
			
			return Integer.MAX_VALUE; // Will return ->2147483647, hence the first value pushed will become the minimum.
			
		}
		else{
			return peek().min;
		}
	}

}
