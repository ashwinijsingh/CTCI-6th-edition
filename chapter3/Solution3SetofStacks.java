package chapter3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Solution3SetofStacks {

	
	ArrayList<Solution3Stack> stacks=new ArrayList<Solution3Stack>();
	public int capacity;
	
	
	Solution3SetofStacks(int capacity){
		this.capacity=capacity;
	}
	
	//get the last stack in the array
	public Solution3Stack getLastStack() {
		
		if(stacks.size()==0){  								//array size is 0 then no element added hence null
			return null;
		}
		else{
			
			return stacks.get(stacks.size()-1); 			// you need to get the last stack present in the array
		}
	}

	
	//push a value into the latest stack
	public void push(int v){
	
		Solution3Stack last=getLastStack();					
		if(last!=null && !last.isFull()){    				//the last stack is not empty or not full
			last.push(v);									// then add the value to the last stack.
			System.out.println("push old"+v);
		}
		else{
			Solution3Stack st=new Solution3Stack(capacity); //we create a stack on the given capacity  when the last stack is empty 
			st.push(v);										//then push the value into the stack
			System.out.println("\npush new"+v);
			stacks.add(st);									//add the stack the the Array
		}
	}
	
	
	public int pop(){
		Solution3Stack last=getLastStack();					
		if(last==null) throw new EmptyStackException();		//if the last stack is null then the stack/array is empty
		int v=last.pop();									
		if(last.size==0) {stacks.remove(stacks.size()-1);   //if the last last stack where the value was popped is empty then remove the stack from the array
		System.out.print("last stack empty after ");
		}
		return v;
	}
	
	public int popAtindex(int index){
		return leftShift(index, false);
	}
	public int leftShift(int index, boolean removeTop){
		Solution3Stack stack=stacks.get(index);
		int remove_item;
		if(removeTop) remove_item=stack.pop();
		else remove_item=stack.removeBottom();
		if(stack.isEmpty()){
			stacks.remove(index);
		}
		else if(index+1<stacks.size()){
			int v=leftShift(index+1,false);
			stack.push(v);
		}
		return remove_item;
	}
	
	
}
