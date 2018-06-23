package chapter2;

import java.util.Stack;

public class Solution6 {

	/**
	 * PALINDROME
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//SOLUTION 1
		LinkedListNode node=new LinkedListNode(1);
		LinkedListNode head=node;
		node.appendtoTail(0);
		node.appendtoTail(1);
		node.appendtoTail(0);
		node.appendtoTail(2);
		System.out.println("Is a palindrome "+isPalindrome(node));
	
	//SOLUTION 2
		System.out.println("Is a palindrome "+isPalindrome1(node));
	
	//SOLUTION 3
		Solution6Result res=isPalindrome2(node,lengthOfLinkedList(node));
		System.out.println("Is a palindrome "+res.result);

	}

	static boolean isPalindrome(LinkedListNode head){
		LinkedListNode reverse=reverseAndClone(head);
		return isEqual(head,reverse);
	}

	private static LinkedListNode reverseAndClone(LinkedListNode node) {
		// TODO Auto-generated method stub
		
		LinkedListNode head=null;
		while(node!=null){
		LinkedListNode n=new LinkedListNode(node.data);
		n.next=head;
		head=n;
		node=node.next;
		}	
		return head;
		
	}
	
	 static boolean isEqual(LinkedListNode l1, LinkedListNode l2){
		while(l1!=null && l2!=null){
			if(l1.data!=l2.data){
				return false;
			}
			l1=l1.next;
			l2=l2.next;
		}
		
		return l1 ==null && l2==null;
	}
	 
	 static boolean isPalindrome1(LinkedListNode head){
		 LinkedListNode slow=head;
		 LinkedListNode fast=head;
		 
		 Stack<Integer> stack=new Stack<Integer>();
		 while(fast!=null && fast.next!=null){
			 stack.add(slow.data);
			 slow=slow.next;
			 fast=fast.next.next;
		 }
		 if(fast!=null){
			 slow=slow.next;
		 }
		 
		 while(slow!=null){
			 int pop=stack.pop();
			 
			 if(pop != slow.data){
				 return false;
			 }
			 slow=slow.next;
			 

		 }
		 return true;
	 }
	 
	 static Solution6Result isPalindrome2(LinkedListNode head,int length){
		 
		 if(head==null || length==0){
			 return new Solution6Result(head,true);
		 }
		 else if(length==1){
			 return new Solution6Result(head.next,true);
		 }
		 
		 Solution6Result res=isPalindrome2(head.next,length-2);
		 
		 if(!res.result || res.node==null){
			 return res;
		 }
		 res.result= (head.data==res.node.data);
		 res.node=res.node.next;
		 return res;
		 
	 }
	 
	 static int lengthOfLinkedList(LinkedListNode head){
		 int size=0;
		 while(head!=null){
			 size++;
			 head=head.next;
		 }
		 return  size;
	 }
}
	

