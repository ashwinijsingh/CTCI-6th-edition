package chapter3;

import java.util.Stack;

public class Solution4MyQueue<T> {
	Stack<T> newStack,oldStack;
	public Solution4MyQueue() {
		newStack=new Stack<T>();
		oldStack=new Stack<T>();
	}

	public int size(){
		return newStack.size()+oldStack.size();
	}
	public void add(T value){
		newStack.push(value);
	}
	
	public void shiftElements(){
		if(oldStack.isEmpty()){
			while(!newStack.isEmpty()){
				oldStack.push(newStack.pop());
			}
		}
	}
	public T peek(){
		shiftElements();
		return oldStack.peek();
	}
	public T remove(){
		shiftElements();
		return oldStack.pop();
	}
	
}
