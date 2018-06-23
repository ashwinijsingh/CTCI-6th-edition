package chapter2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution1 {

	/**
	 * Go through page 92
	 * 
	 * REMOVE DUPLICATES 1. My own assumption that its a INT linked list (need
	 * to go through parameterized and not parameterized linked list)
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Solution 1
		 * 1. Create a hash table
		 * 2. Add the linkedlist to the hashtable as we iterate through the linked list.
		 * 3. If we find the duplicate we remove it from the linked list and then iterate through the rest of the array.
		 * 
		 */
		
       // A. USING JAVA.UTIL.LINKEDLIST
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(0);
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(3);
		list.add(3);
		HashSet<Integer> set = new HashSet<Integer>();
		Iterator<Integer> i = list.iterator();
		while (i.hasNext()) {

			int value = (Integer) i.next();
			if (set.contains(value)) {
				i.remove();
			} else {
				set.add(value);
			}

		}

		System.out.println("**Solution 1 **");
		System.out.println("A : USING JAVA.UTIL: \n Modified linked list :");
		i = list.iterator();

		while (i.hasNext()) {
			System.out.print(" "+i.next());
		}
		
		System.out.println("\n");
		
		// A. USING THE NODE CREATED
		LinkedListNode listnode=new LinkedListNode(0);
		listnode.appendtoTail(0);
		listnode.appendtoTail(3);
		listnode.appendtoTail(3);
		listnode.appendtoTail(1);
		listnode.appendtoTail(3);
		
		System.out.println("B USING THE CREATED NODE:\n Linked List before deleting the duplicate : ");
		
		LinkedListNode head=listnode;
		while(listnode!=null){
			System.out.print(" "+listnode.data);
			listnode=listnode.next;
		
		}
		
		Solution1 ob=new Solution1();
		listnode=ob.deleteDups(head);
		System.out.println("\n Linked List after deleting the duplicate : ");
		while(listnode!=null){
			System.out.print(" "+listnode.data);
			listnode=listnode.next;
		
		}
		
		System.out.println("\n");
		
		
		
		/*Solution 2:
		 * 1. Temporary Buffer like Hash Table not Allowed
		 * 2. We will keep two pointers 
		 * 		i. Current: iterates through the linked list.
		 * 	   ii. Runner: iterates through the subsequent nodes. 
		 *  
		 */



		System.out.println("**Solution 2: \n Modified linked list**");
	
		listnode=ob.deleteDupsEfficient(head);		
		System.out.println("\n Linked List after deleting the duplicate : ");
		while(listnode!=null){
			System.out.print(" "+listnode.data);
			listnode=listnode.next;
		
		}
		
/*	Not working need to work on this code
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);

		Iterator i1 = list1.iterator();
		

		while (i1.hasNext()) {
			Integer x = (Integer) i1.next();
			Iterator i2 = i1;
			while (i2.hasNext()) {

				if (x.equals(i2.next())) {

					i1.remove();
				}

			}

		}
		
		
		i = list1.iterator();

		while (i.hasNext()) {
			System.out.println(i.next());

		}
		*/

	}
	
	LinkedListNode deleteDups(LinkedListNode n){
		LinkedListNode head=n;
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous=null;
		while(n!=null){
			if(set.contains(n.data)){
			
				previous.next=n.next;
			}
			else{
			set.add(n.data);
			previous=n;
			}
			
			n=n.next;
		}
		
		
		return head;
		
	}
	
	LinkedListNode deleteDupsEfficient(LinkedListNode n){

		LinkedListNode current=n;
		while(current!=null){
			LinkedListNode runner=current;
			while(runner.next!=null){
				
				if(current.data==runner.next.data){
					runner=runner.next.next;
				}
				else{
					runner=runner.next;
				}
			}
			current=current.next;
		}
		
		
		
		return n;
	}

}
