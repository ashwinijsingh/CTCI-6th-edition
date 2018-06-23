package chapter2;
/**
* INTERSECTION
* 
*/
public class Solution7 {
	
	public static void main(String[] args) {
		
		LinkedListNode l1=new LinkedListNode(3);
		l1.appendtoTail(1);
		l1.appendtoTail(5);
		l1.appendtoTail(9);
		
		l1.appendtoTail(7);
		l1.appendtoTail(2);
		l1.appendtoTail(1);
		
		LinkedListNode current=l1;
		LinkedListNode l2=new LinkedListNode(12);
	
		int temp=3;
		while(temp>=0){
			current=current.next;
			temp--;
			
		}
		
		l2.setNext(current);
		LinkedListNode node=getLinkedListIntersection(l1,l2);
		
		
		System.out.println("First Node: \n");
		while(node!=null){
			System.out.println("Node value"+node.data);
			node=node.next;
		
		}
		
		LinkedListNode l3=new LinkedListNode(12);
		l3.appendtoTail(7);
		l3.appendtoTail(2);
		l3.appendtoTail(1);
		LinkedListNode node1=getLinkedListIntersection(l1,l3);
		
		
		System.out.println("\nSecond Node "+node1);
		
	}
	
	public static  LinkedListNode getLinkedListIntersection(LinkedListNode l1,LinkedListNode l2){
		
		Solution7Result result1=getTail(l1);
		Solution7Result result2=getTail(l2);
		
		if(result1.tail!=result2.tail){
			return null;
		}
		
		LinkedListNode shorter=result1.size<result2.size?l1:l2;
		LinkedListNode longer=result1.size<result2.size?l2:l1;
		
		longer=getKthNode(longer,Math.abs(result1.size-result2.size));

		while (longer != shorter){
			longer=longer.next;
			shorter=shorter.next;
		}
		
		return longer;
		
	}

	public static Solution7Result getTail(LinkedListNode head){
		int size=1;
		LinkedListNode current=head;
		
		while(current.next != null){
			size++;
			current=current.next;
		}
		 return new Solution7Result(current,size);
		
	}
	
	public static LinkedListNode getKthNode(LinkedListNode head,int diff){
		int k=diff;
		LinkedListNode current=head;
		while(k>0 && current!=null){
			current=current.next;
			k--;
		}
		
		return current;
	}
	
}
