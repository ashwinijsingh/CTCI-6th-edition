package chapter4;

public class Solution5InOrder {

	/**
	 * CHECK BALANCED BST
	 */
	public static void main(String[] args) {
		int[] array = {10,15,17,20,25};
		TreeNode node = TreeNode.createMinimalBST(array);
		System.out.println(checkBSTA(node,array.length));
		System.out.println(checkBSTB(node));
		test();
	}

	/*
	 * Solution 1 A
	 */
	
	static boolean checkBSTA(TreeNode node,int size){
		
		int[] a=new int[size];
		System.out.println(size);
		checkBSTA(node,a);
		for (int i = 1; i < a.length; i++) {
			if(a[i]<=a[i-1])
				return false;
			
		}
		return true;
	}
	static int index=0;
	static void checkBSTA(TreeNode root,int[] a){
		if(root==null) return;
		System.out.println(root.data);
		checkBSTA(root.left,a);
		a[index]=root.data;
		index++;
		checkBSTA(root.right,a);
	}
	
	/*
	 *Solution 1B 
	 */
	static Integer last_printed=null;
	static boolean checkBSTB(TreeNode root){
		if(root ==null ) return true;
		if(!checkBSTB(root.left)) return false;
		if(last_printed!=null && root.data<=last_printed)
			return false;
		last_printed=root.data;
		if(!checkBSTB(root.right)) return false;
		return true;
	}
	
	public static void test() {
		TreeNode node;
		boolean condition;
		System.out.println("test cases for equals condition.");

		/* Expect true: for left child: node.data <= last_printed.
   2
  / \
 /   \
 2   3
      \
      4
		*/
		int[] array2 = {1, 2, 3, 4};
		node = TreeNode.createMinimalBST(array2);
		node.left.data = 2;
		//node.print();
		last_printed = null;
		condition = checkBSTB(node);
		System.out.println("should be true: " + condition);

		/* Expect false: for right child: node.data <= last_printed.
   2
  / \
 /   \
 1   2
      \
      4
		 */
		int[] array3 = {1, 2, 3, 4};
		node = TreeNode.createMinimalBST(array3);
		node.right.data = 2;
		//node.print();
		last_printed = null;
		condition = checkBSTB(node);
		System.out.println("should be false: " + condition);
	}
}
