package chapter4Solution8a_b_c_d_e;

public class Solution8b {

	/**
	 * Link to parents (better worst case)
	 * -> O(t)->size of the subtree with the first common ancestor
	 * -> O(n)-> number of nodes in the tree
	 */
	public static void main(String[] args) {
	
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(4);
		TreeNode n7 = root.find(3);
		TreeNode ancestor = commonAncestor(root, n3, n7);
		System.out.println(ancestor.data);
	}
	
	public static TreeNode commonAncestor(TreeNode root,TreeNode p,TreeNode q){
		if(!covers(root,p)||!covers(root,q)){ //check if the nodes are covered in the tree
			return null;
		}
		else if(covers(p,q)){ 				  //check if the p is a parent of q
			return p;
			
		}
		else if(covers(q,p)){				 //check if q is a parent of p
			return q;
		}
		
		TreeNode sibling=getSibling(p);     
		TreeNode parent=p.parent;
		while(!covers(sibling,q)){          //check if the sibling covers the node. Keep moving upwards.
			sibling=getSibling(parent);
			parent=parent.parent;
		}
		return parent;
	}

	public static boolean covers(TreeNode root,TreeNode node){
		if(root==null) return false;
		if(root==node) return true;
		return covers(root.left,node)|| covers(root.right,node);
	}
	
	public static TreeNode getSibling(TreeNode node){
		if(node==null){
			return null;
		}
		TreeNode parent=node.parent;
		return parent.left==node? parent.right:parent.left;
	}
}
