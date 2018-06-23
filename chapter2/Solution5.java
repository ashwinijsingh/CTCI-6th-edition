package chapter2;

public class Solution5 {

	/**
	 * SUM LISTS:
	 * 1. INPUT: (7->1->6)+(5->9->2) :617+295
	 * 	  OUTPUT: 2->1->9: 912
	 * 2. Follow up question:
	 * 	  INPUT: (6->1->67+(2->9->5) :617+295
	 * 	  OUTPUT: 9->1->2: 912
	 *  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// SOLUTION 1
		LinkedListNode lA1 = new LinkedListNode(9, null, null);
		LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(9, null, lA2);
		
		LinkedListNode lB1 = new LinkedListNode(1, null, null);
		LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(0, null, lB2);	
		
		LinkedListNode list3 = addLists(lA1, lB1, 0);
		
		System.out.println("  " + lA1.printForward());		
		System.out.println("+ " + lB1.printForward());			
		System.out.println("= " + list3.printForward());	
		
		int l1 = linkedListToInt(lA1);
		int l2 = linkedListToInt(lB1);
		int l3 = linkedListToInt(list3);
		
		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));		

		
		
	//SOLUTION 2
		
//		LinkedListNode lA1 = new LinkedListNode(3, null, null);
//		LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
//		LinkedListNode lA3 = new LinkedListNode(5, null, lA2);
//		
//		LinkedListNode lB1 = new LinkedListNode(5, null, null);
//		LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
//		LinkedListNode lB3 = new LinkedListNode(1, null, lB2);	
//		
//		LinkedListNode list3 = addLists(lA1, lB1);
//		
//		System.out.println("  " + lA1.printForward());		
//		System.out.println("+ " + lB1.printForward());			
//		System.out.println("= " + list3.printForward());	
//		
//		int l1 = linkedListToInt(lA1);
//		int l2 = linkedListToInt(lB1);
//		int l3 = linkedListToInt(list3);
//		
//		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
//		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));	
	}
	/*
	 * SOLUTION 1:
	 * 1. Adding node by node and then carry of the "excess" data to the next node.
	 * 
	 * 
	 * 
	 */
	private static 	LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2,int carry){
		if(l1==null && l2==null && carry==0){
			return null; 		// we return a null which will be assignwed to the node
		}
		
		LinkedListNode result=new LinkedListNode();
		int value=carry;
		if(l1!=null){  
			value +=l1.data;		// 
		}
		if(l2!=null){
			value +=l2.data;		//
		}
		
		result.data=value%10; // we are storing the second digit of the addition
		
		if(l1!=null || l2!=null){ //when either of the linked list is not null
			LinkedListNode more=addLists(l1==null ? null:l1.next,
										 l2 == null ? null: l2.next,
										 value>=10?1:0); //if there is a carry we return 1
			
			result.setNext(more); // 9->null; 1->9->null; 2->1->9->null
		}
		return result;
	}
	//GITHUB
	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		if (node.next != null) {
			value = 10 * linkedListToInt(node.next);
		}
		return value + node.data;
	}
	
	/*
	 * SOLUTION 2:
	 * 1. 
	 * 
	 * 
	 * 
	*/
	private static 	LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2){
		int len1=length(l1);
		int len2=length(l2);
		
		if(len1<len2){
			l1=padList(l1,len2-len1);
		}
		if(len2>len1){
			l2=padList(l2,len1-len2);
		}
		
		Solution5PartialSum sum=addListHelper(l1,l2);
		
		if(sum.carry==0){
			return sum.sum;
		}
		else{
			return insertBeforeHead(sum.sum,sum.carry);
		}
		
		
	}
	
	
	//GITHUB
	private static int length(LinkedListNode l) {
		if (l == null) {
			return 0;
		} else {
			return 1 + length(l.next);
		}
		
	}
	
	
	static LinkedListNode padList(LinkedListNode l,int pad){
		LinkedListNode head=l;
		for (int i = 0; i < pad; i++) {
			head=insertBeforeHead(head,0);
		}
		return head;
	}
	
	static LinkedListNode insertBeforeHead(LinkedListNode list,int data){
		LinkedListNode node=new LinkedListNode(data);
		if(list!=null){
			node.next=list;
		}
		return node;
		}

	private static Solution5PartialSum  addListHelper(LinkedListNode l1,LinkedListNode l2){
		if(l1==null && l2==null){
			Solution5PartialSum sum= new Solution5PartialSum();
			return sum;
		}
		
		Solution5PartialSum sum=addListHelper(l1.next,l2.next);
		
		int value=sum.carry+l1.data+l2.data;
		
		LinkedListNode result=insertBeforeHead(sum.sum,value%10);
		
		sum.sum=result;
		sum.carry=value/10;
		return sum;
	}
}
