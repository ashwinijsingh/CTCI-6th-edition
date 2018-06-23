package chapter2;

public class Solution4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListNode n=new LinkedListNode(3);
		n.appendtoTail(5);
		n.appendtoTail(8);
		n.appendtoTail(5);
		n.appendtoTail(10);
		n.appendtoTail(2);
		n.appendtoTail(1);
		Solution4 ob=new Solution4();
		
		LinkedListNode resultnode=ob.partition(n, 5);
		
		System.out.println("SOLUTION 1");
		while(resultnode!=null){
			System.out.println("Node value"+resultnode.data);
			resultnode=resultnode.next;
		
		}
		
		LinkedListNode n1=new LinkedListNode(3);
		n1.appendtoTail(5);
		n1.appendtoTail(8);
		n1.appendtoTail(5);
		n1.appendtoTail(10);
		n1.appendtoTail(2);
		n1.appendtoTail(1);
		
		LinkedListNode resultnode1=ob.partition2(n1, 5);
		
		
		System.out.println("SOLUTION 2");
		while(resultnode1!=null){
			System.out.println("Node value"+resultnode1.data);
			resultnode1=resultnode1.next;
		
		}
		
	}
	
	LinkedListNode partition(LinkedListNode node,int x){
		LinkedListNode bs=null;
		LinkedListNode be=null;
		LinkedListNode as=null;
		LinkedListNode ae=null;
		
		while(node!=null){
			LinkedListNode next=node.next;
			node.next=null;
			if(node.data<x){
				if(bs==null){
					bs=node;
					be=bs;
				}
				else{
					be.next=node;
					be=node;
				}
			}
			else{
				if(as==null){
					as=node;
					ae=node;
				}
				else{
					ae.next=node;
					ae=node;
				}
			}
			node=next;
		}
		
		if(bs==null){
			return as;
		}
		
		be.next=as;
		return bs;
	}
	
	
	LinkedListNode partition2(LinkedListNode node,int x){
		LinkedListNode head=node;
		LinkedListNode tail=node;
	
		
		while(node!=null){
			LinkedListNode next=node.next;
			node.next=null;
			if(node.data<x){
			node.next=head;
			head=node;
			}
			else{
			tail.next=node;
			tail=node;
			}
			node=next;
		}
		tail.next=null;
		
		return head;
	}

}
