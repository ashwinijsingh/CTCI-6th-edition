package chapter4;

public class Solution6 {

	/**
	 * SUCCESSOR: In order traversal successor= 
	 */
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = inorderSucc(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
		

	}
	
	static TreeNode inorderSucc(TreeNode n){
		if(n==null) return null;
		if(n.right!=null){
			return leftMost(n.right);
		}
		else{
			TreeNode q=n;
			TreeNode x=q.parent;
			while(x!=null && x.left!=q){
				q=x;
				x=x.parent;
				
			}
		return x;	
		}
		
	}

	private static TreeNode leftMost(TreeNode n) {
		if(n==null){
			return null;
		}
		while(n.left!=null){
			n=n.left;
		}
		return n;
	}

}
