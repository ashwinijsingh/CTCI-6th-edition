package chapter2;

public class LinkedListNode1 {
	public LinkedListNode1 next;
	public LinkedListNode1 prev;
	public LinkedListNode1 last;
	public int data;
	public LinkedListNode1(int d, LinkedListNode1 n, LinkedListNode1 p) {
		data = d;
		setNext(n);
		setPrevious(p);
	}
	
	public LinkedListNode1() { }

	public void setNext(LinkedListNode1 n) {
		next = n;
		if (this == last) {
			last = n;
		}
		if (n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}
	
	public void setPrevious(LinkedListNode1 p) {
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
	
	public LinkedListNode1 clone() {
		LinkedListNode1 next2 = null;
		if (next != null) {
			next2 = next.clone();
		}
		LinkedListNode1 head2 = new LinkedListNode1(data, next2, null);
		return head2;
	}
}