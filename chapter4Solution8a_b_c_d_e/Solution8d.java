package chapter4Solution8a_b_c_d_e;

public class Solution8d {
static int call=0;
	/**
	 * 1) Returns p, if roots subtree includes p and not q
	 * 2) Returns q, if roots subtree includes q and not p
	 * 3) Returns null, if p and q are not in roots subtree
	 * 4) Returns the common ancestor of p & q   
	 * 
	 * Problem:
	 * This program cannot differentiate between two cases:
	 * case 1: returns p when q is a sub child of p
	 * case 2: return p when q is present in the tree but q is not present in the tree 
	 * 
	 */
	public static void main(String[] args) {
		
		//int[] array = {1,3,5,8};
		int[] array = {2,3,5,7,10,15,17,20,30};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(17);
		//TreeNode n7 = new TreeNode(6);
		TreeNode n7=root.find(30);
		TreeNode ancestor = commonAncestorBad(root, n3, n7);
		if (ancestor != null) {
			System.out.println(ancestor.data);
		} else {
			System.out.println("null");
		}
	}
	
	public static TreeNode commonAncestorBad(TreeNode root, TreeNode p, TreeNode q) {
		String xtemp;
		String ytemp;
		System.out.println("Call-------- :"+call++);
		if(root!=null){
			System.out.println("commonAncestorBad  Method called with root as "+root.data);
		}
		
		if (root == null) {
			System.out.println("commonAncestorBad  Method called with root as NULL");
			return null;
		}
		if (root == p && root == q) {
			System.out.println("commonAncestorBad LINE 33 where P value and Q value are equal"+p.data);
			return root;
		}
		
		System.out.println("calling Method  Where root is "+root.data);
		TreeNode x = commonAncestorBad(root.left, p, q);
		if (x != null && x != p && x != q) { // Found common ancestor
			System.out.println("CHECKING X:COMMON ancestor found return X :"+x.data);
			return x;
		}
		if(x==null){
		System.out.println("X value is NULL ");
		xtemp="NULL";
		}
		else{
		System.out.println("X value is not NOT NULL"+x.data);
		xtemp=String.valueOf(x.data);
		}
		System.out.println("********************************************");
		System.out.println("calling Method Y Where root is "+root.data);
		TreeNode y = commonAncestorBad(root.right, p, q);
		if (y != null && y != p && y != q) {
			System.out.println("CHECKING Y:COMMON ancestor found return Y :"+y.data);
			return y;
		}
		
		if(y==null){
			System.out.println("Y value is NULL ");
			ytemp="NULL";
			}
			else{
			System.out.println("Y value is not NOT NULL"+y.data);
			ytemp=String.valueOf(y.data);
			}
		
		System.out.println("---------------------------------------------------");
		System.out.println("-Check condition-FOR ROOT : ("+root.data+") Xvalue :"+xtemp+" Yvalue :"+ytemp);
		System.out.println("---------------------------------------------------");
		if (x != null && y != null) {
			System.out.println("COMMON ancestor found X is :"+x.data);
			System.out.println("COMMON ancestor found Y is :"+y.data);
			System.out.println("COMMON ancestor found ROOT is :"+root.data);
			return root; // This is the common ancestor
		} else if (root == p || root == q) {
			
			if(root == p){
			System.out.println("Root is :"+root.data);
			System.out.println("P value :"+p.data);
		//	System.out.println("Y value :"+y.data); //--> 8
			System.out.println("Hence returning :"+root.data);
			}
			if(root == q){
				System.out.println("Root is :"+root.data);
				System.out.println("Q value :"+q.data);
				System.out.println("Hence returning :"+root.data);
				}
			
			System.out.println("---------------------------------------------------");
			return root;
		} else {

			 if(y==null&&x==null){
				System.out.println("X & Y is NULL RETURNING NULL for root  :"+root.data);
			}
			 else if(y==null&&x!=null){
				System.out.println("Y is NULL and X is NOT NULL RETURNING  X  :"+x.data+" for root  :"+root.data);
			}
			else if(x!=null && y!=null){
				System.out.println("returning X and Y is NOT NULL which is RETURNING X:"+x.data+" for root  :"+root.data);
			}
			else{
			  System.out.println("returning Y which is NON NULL RETURNING :"+y.data+" for root  :"+root.data);
			}
			System.out.println("---------------------------------------------------");
			return x == null ? y : x;
		}
		
		
		
	}	
}
