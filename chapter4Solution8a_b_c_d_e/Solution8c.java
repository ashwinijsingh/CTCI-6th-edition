package chapter4Solution8a_b_c_d_e;

public class Solution8c {
	
	/**
	 * Without link to parents:
	 * 1) If both the nodes or the left side of the root -> recurse through the left side
	 * 2) If both the nodes are on the right side of the root -> recurse through the right side.
	 * 3) If both the nodes are present on opposite sides of the root then that will be the common ancestor.
	 * 
	 * Problem:
	 * 1) We keep traversing left and right of the root node over and over again. Instead we should just traverse through the nodes once
	 */

	public static void main(String[] args) {
		
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(3);
		TreeNode n7 = root.find(5);
		//TreeNode temp=new TreeNode(12);
		TreeNode ancestor = commonAncestor(root, n3, n7);
		System.out.println(ancestor.data);
	}
	
	public static TreeNode commonAncestor(TreeNode root,TreeNode p,TreeNode q){
		if(!covers(root,p)||!covers(root,q)){
			System.out.println("One of the nodes is not covered");
			return null;
		}
		return ancestorHelper( root,p, q);
		
	}
	
	
	public static boolean covers(TreeNode root,TreeNode node){
		if(root==null) return false;
		if(root==node) return true;
		return covers(root.left,node)||covers(root.right,node);
	}
	
	
	
	public static TreeNode ancestorHelper(TreeNode root,TreeNode p,TreeNode q){
		if(root==null||p==root||q==root) //When root one of the nodes is a ancestor/parent of the other //Null condition : not sure, as we will never reach this point
		{	System.out.println("One of then is a parent/ancestor of the other");
			return root;
		}
		boolean pIsOnLeft=covers(root.left,p); //if p is on left
		boolean qIsOnLeft=covers(root.left,q); //if q is on right
		
		if(pIsOnLeft!=qIsOnLeft){ //both are on opposite sides
			return root;
		}
		
		TreeNode child=pIsOnLeft?root.left:root.right;
		return ancestorHelper(child,p,q);
	}
	
}
