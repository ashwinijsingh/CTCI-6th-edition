package chapter4;

public class Solution4 {
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Is balanced? " + isBalanced(root));
		
		// Could be balanced, actually, but it's very unlikely...
		TreeNode unbalanced = new TreeNode(10);
		for (int i = 0; i < 10; i++) {
			unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
		}
		System.out.println("Root? " + unbalanced.data);
		System.out.println("Is balanced? " + isBalanced(unbalanced));
		
		
		
		System.out.println("Solution 2");
		
		// Create balanced tree
		int[] array1 = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root1 = TreeNode.createMinimalBST(array1);
		System.out.println("Is balanced? " + isBalanced(root1));
		root1.insertInOrder(4); // Add 4 to make it unbalanced
		System.out.println("Is balanced? " + isBalanced(root1));
	}
	

	/*Solution 1:Brute Force type
	 * 1) This method is O(NLogN)-doubt
	 * 2)
	 */
	
	static boolean isBalanced(TreeNode root){
		if(root==null){
			return true;
		}
		int heightDiff=getHeight(root.left)-getHeight(root.right);
//		if(root.left!=null){
//		System.out.println("Root.left : "+root.left.data+" Height "+getHeight(root.left));
//		}
//		if(root.right!=null){
//		System.out.println("Root.right : "+root.right.data+" Height "+getHeight(root.left));
//		}
//		System.out.println("Height difference "+heightDiff);
		if(Math.abs(heightDiff)>1){
			return false;
		}
		else{
			return isBalanced(root.left)&&isBalanced(root.right);
		}
	}
	
	static int getHeight(TreeNode n){
		if(n==null){
			return -1;
		}
			return Math.max(getHeight(n.left),getHeight(n.right))+1;
	}
	
	/*Solution 2:
	 * This Solution is O(N) time and O(H) space
	 */
	static int checkHeight(TreeNode root){
		if(root==null) return -1;
		
		int leftHeight=checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; //A constant holding the minimum value an int can have, -231.
		
		int rightHeight=checkHeight(root.right);
		if(rightHeight==Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int heightDifference=leftHeight-rightHeight;
		if(heightDifference>1){
			return Integer.MIN_VALUE;
		}
		else {
			return Math.max(leftHeight, rightHeight)+1;
		}
	}
	
	static boolean isBalanced1(TreeNode root){
		return checkHeight(root)!=Integer.MIN_VALUE;
	}

}
