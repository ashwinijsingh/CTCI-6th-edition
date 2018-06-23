package chapter3;




/**
 * Creating a Class STACK renamed as Solution3Stack for Convenience.
 * 
 */

public class Solution3Stack {
	
	private int capacity;
	public Solution3Node top;
	public Solution3Node bottom;
	public int size = 0;
	
	
	public Solution3Stack(int capacity) { 
		 this.capacity=capacity;
		// top=null; //why didnt have to initialize ?
	}


	public boolean isFull(){
		return size==capacity;		
	}
	
	
	// we are joining the nodes to form a stack (link them)
	public void join(Solution3Node newnode, Solution3Node top){
		if(top!=null) top.above=newnode;    //new node should be linked to the current top
		if(newnode!=null)newnode.below=top; //new node linked  to the current top
		
		
	}
	
	public boolean push(int value){
		
		if(size>capacity)
		return false; // cannot push more values to the stack as the stack is full
		
		size++;       //increase the size of the stack as we are inserting the value
		Solution3Node n=new Solution3Node(value);
		if (size==1) bottom=n;
		
		join(n,top); 
		top=n;       // new node added will be come the top
		System.out.println("TOP"+top.value);
		return true;
		
	}
	
	public int pop(){
		Solution3Node n=top;
		top=top.below; // assign the new top as the node below top.
		size--;
		return n.value;
	}


	public int removeBottom() {
		
		Solution3Node b=bottom;	
		bottom=bottom.above;
		if(bottom!=null) bottom.below=null; //assign the new bottom of the stack
		size--;
		return b.value;
	}


	public boolean isEmpty() {
		
		return size==0;
	}
	
}
