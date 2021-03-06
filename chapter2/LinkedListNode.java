package chapter2;

public class LinkedListNode {
	//https://github.com/careercup/ctci/blob/master/java/CtCILibrary/CtCILibrary/LinkedListNode.java
	public LinkedListNode next;
	public LinkedListNode prev;
	public LinkedListNode last;
	public int data;
	public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
		data = d;
		setNext(n);
		setPrevious(p);
	}
	
	LinkedListNode(){
		
	}
	
	public LinkedListNode(int d){
	 data =d;
	 
	}
	
	public void setNext(LinkedListNode n) {
		next = n;
		if (this == last) {
			last = n;
		}
		if (n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}
	
	public void setPrevious(LinkedListNode p) {
		prev = p;
		if (p != null && p.next != this) {
			p.setNext(this);
		}
	}	
	
	public String printForward() {
		if (next != null) {
			return data + "->" + next.printForward();
		} else {
			return ((Integer) data).toString();
		}
	}
	
	public LinkedListNode clone() {
		LinkedListNode next2 = null;
		if (next != null) {
			next2 = next.clone();
		}
		LinkedListNode head2 = new LinkedListNode(data, next2, null);
		return head2;
	}
	
	void appendtoTail(int d){
		
		
		LinkedListNode end=new LinkedListNode(d);
		LinkedListNode n=this;
		while(n.next!=null){		
			n=n.next;
		}
		n.next=end;
		
		
	}
	
	public static void main(String[] args){
		LinkedListNode node = new LinkedListNode(4);
	
		node.appendtoTail(5);
		node.appendtoTail(1);
		
		
	while(node!=null){
		System.out.println("Node value"+node.data);
		node=node.next;
	
	}
	}



}

