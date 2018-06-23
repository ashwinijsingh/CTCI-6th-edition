package chapter3;

import java.util.EmptyStackException;


 class Solution1FixedMultiStack {
	private int numberOfStacks=3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	//Constructor to initialize the stack size and array size
	Solution1FixedMultiStack(int stacksize){
		stackCapacity=stacksize;
		values=new int[numberOfStacks*stackCapacity]; //array size 3* 10(stack size)
		sizes=new int[stackCapacity];                 //Separate array which maintains the size(number of elements) of each stack 
	}

	public void push(int stacknum,int value)throws FullStackException{
		if(isFull(stacknum)){
			throw new FullStackException();
		}
		sizes[stacknum]++;						//Increment the stack pointer and then update the top value. 
		values[indexOfTop(stacknum)]=value;	
	}
	
	boolean isFull(int stacknum){
		return sizes[stacknum]==stackCapacity;
	}
	
	public int pop(int stacknum){
		if(isEmpty(stacknum)){
			throw new EmptyStackException();
		}
	 int top=indexOfTop(stacknum);
	 int value= values[top];
	 values[top]=0;
	 sizes[stacknum]--;
	 return value;
	}
	
	public int peek(int stacknum){
		if(isEmpty(stacknum)){
			throw new EmptyStackException();
		}
	return values[indexOfTop(stacknum)];
	}
	
	boolean isEmpty(int stacknum){
		return sizes[stacknum]==0;
	}
	
	int indexOfTop(int stacknum){
		int offset=stacknum*stackCapacity; // this offset is to access the stack as we have one array which is divided into 3 (imaginary)
		int size=sizes[stacknum];
		return offset+size-1;
	}
	
	
}
