package chapter2;

public class Solution3 {

	/**
	 * DELETE MIDDLE NODE
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution3 ob=new Solution3();
		LinkedListNode  list=new LinkedListNode(1);
		list.appendtoTail(2);
		list.appendtoTail(3);
	//	LinkedListNode node=list;
		list.appendtoTail(4);
		list.appendtoTail(5);
		
		
//ob.deleteMiddleNode(LinkedListNode.node1);
//
		
//		LinkedListNode node=list;
//		LinkedListNode n=null;
//while(node!=null){
//	if(node.data==3){
//		ob.deleteMiddleNode(node);
//		break;
//	}
//		node=node.next;
//	
//}
//
//
//while(list!=null){
//	System.out.println("Node value"+list.data);
//	list=list.next;
//
//}
//
//while(node!=null){
//	System.out.println("Node value"+node.data);
//	node=node.next;
//
//}

	
	}
	
	
	/*
	 * SOLUTION 1:
	 * -> Copy data over from  NEXTnode to current node 
	 * -> point the currentnode.next to the NEXTnode.next
	 * -> NOTE: if the last node we cannot use this solution
	 */
	boolean deleteMiddleNode(LinkedListNode node){
		if(node==null||node.next==null){
			return false;
		}
		System.out.println(node.data);
		LinkedListNode n=node;
		node.data=n.data;
		node.next=n.next;
		
		
		return true;
		
	}


}
