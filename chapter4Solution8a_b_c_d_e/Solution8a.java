package chapter4Solution8a_b_c_d_e;

public class Solution8a {

	/**
	 * With links to Parents
	 * ->Similar to approach of linkedlists
	 */
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12};
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root " + root.data);
		TreeNode n3 = root.find(3);
		TreeNode n7 = root.find(7);
		TreeNode ancestor = commonAncestor(n3, n7,root);
		System.out.println(ancestor.data);

	}
	
	public static TreeNode commonAncestor(TreeNode p,TreeNode q,TreeNode root){
		int delta=depth(p)-depth(q);
		System.out.println("DELTA :"+delta);
		TreeNode first=delta>0?p:q; //longer list
		TreeNode second=delta>0?q:p;//shorter list
		
		first=goUpBy(first,Math.abs(delta));

		while(first != second && first!=null && second!=null){
		first=first.parent;
		second=second.parent;
		}
	
		return first == null||second == null?null:first;
		
	}
	
	public static int depth(TreeNode node){
		int depth=0;
		System.out.println("NODE: "+node.data);
		while(node!=null){
		System.out.println("parent "+node.data);
		node=node.parent;
		depth++;
	}
		System.out.println("depth is : "+depth);
		return depth;
	}
	
	public static TreeNode goUpBy(TreeNode node,int delta){
		while(delta>0){
			node=node.parent;
			delta--;
		}
		return node;
	}
	
}
