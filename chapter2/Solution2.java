package chapter2;

public class Solution2 {

	/**
	 * RETURN Kth TO THE LAST
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 ob=new Solution2();
		
		/*
		 * My Solution
		 * -> take the reverse 
		 */
		//String x="611";
		StringBuffer x1=new StringBuffer("611");
		x1.reverse();
		System.out.println(x1);

		int c=Integer.parseInt(x1.toString());
		System.out.println(c);
			
	
		
		/* 
		 * SOLUTION 1:
		 * -> Recursively 
		 * ->Drawback : we cannot pass a counter and integer value through normal return statements
		 */
		
		LinkedListNode list=new LinkedListNode(5);
		list.appendtoTail(4);
		list.appendtoTail(3);
		list.appendtoTail(2);
		list.appendtoTail(1);
		int index=ob.printkthToLast(list, 5);
		
		/*
		 * SOLUTION 2:
		 * -> passed by reference 
		 * 
		 */
		
		LinkedListNode node=ob.printkthToLast2(list, 4);
		
		/*
		 * SOLUTION 2:
		 * -> Two pointers : p1=head and p2=k places ahead oh p1;
		 * 
		 */
		
		node=ob.nthToLast(list, 3);
	}
	
	
	int printkthToLast(LinkedListNode head,int k){
		if(head==null){
			return 0;
		}
		int index=printkthToLast(head.next,k)+1;
		if(index==k){
			System.out.println("Solution 1: The "+k+"th elemnt from last is "+head.data);
		}
		return index;
	}
	
	LinkedListNode printkthToLast2(LinkedListNode head,int k){
		Solution2Index index=new Solution2Index();
		return printkthToLast2(head,k,index);
	}

	LinkedListNode printkthToLast2(LinkedListNode head,int k,Solution2Index index){
		if(head==null){
			return null;
		}
		LinkedListNode node=printkthToLast2(head.next,k,index);
		index.value=index.value+1;
		if(index.value==k){
			System.out.println("Solition 2: The "+k+"th elemnt from last is "+head.data);
		}
		return node;
	}
	
	LinkedListNode nthToLast(LinkedListNode head,int k){
		LinkedListNode p1=head;
		LinkedListNode p2=head;
		
		for(int i=0;i<k;i++){
		if(p1==null){
			return null; // Out of bounds
		}
			p1=p1.next;
		}
		
		while (p1!=null){
			p1=p1.next;
			p2=p2.next;
		}
		System.out.println("Solition 3: The "+k+"th elemnt from last is "+p2.data);
		return p2;
		
	}
	
}
