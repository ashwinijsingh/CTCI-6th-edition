package chapter4Solution8a_b_c_d_e;

public class Solution8e {

	/**
	 * We use a class Result which will store:
	 * 1. Node
	 * 2. isAncestor
	 * 
	 * This code will take care if one node is not there in tree (Case1 & Case 2 of Solution8d) 
	 */
	public static void main(String[] args) {
		
		//int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] array = {3,5,7,10,15,17,20,30};
		
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(0);
		TreeNode n7 = root.find(17);
		TreeNode ancestor = commonAncestor(root, n3, n7);
		if (ancestor != null) {
			System.out.println(ancestor.data);
		} else {
			System.out.println("null");
		}
		

	}
	
	public static TreeNode commonAncestor(TreeNode root,TreeNode p,TreeNode q){
		Result r=commonHelper(root,p,q);
		if(r.isAncestor){
			return r.node;
		}
		else{
			return null;
		}
	}

	private static Result commonHelper(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null){
			return new Result(null,false);
		}
		else if(p==root && q==root){
			return new Result(root,true);
		}
		Result rx=commonHelper(root.left,p,q);
		if(rx.isAncestor){
			return rx; //ancestor found
		}
		
		Result ry=commonHelper(root.right,p,q);
		if(ry.isAncestor){
			return ry;//ancestor found
		}
		
		
		if(rx.node!=null && ry.node!=null){
			return  new Result(root,true); // common ancestor
		}
		else if( p==root|| q== root){
			
			boolean isAncestor=rx.node!=null || ry.node!=null; // rx or ry should not be null
			System.out.println("root "+root.data+" ancestor "+isAncestor);
			if(rx.node!=null){
			System.out.println("rx.node!=null-->"+rx.node.data);
			}
			if(ry.node!=null){
				System.out.println("ry.node!=null-->"+ry.node.data);
			}
			if(ry.node==null && rx.node==null){
				System.out.println("ry.node==null && rx.node==null");
			}
			return new Result(root,isAncestor);
		}
		else {
			return new Result(rx.node!=null?rx.node:ry.node,false); 
		}
	}

}
