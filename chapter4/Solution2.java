package chapter4;

public class Solution2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5};
		
		// We needed this code for other files, so check out the code in the library
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root " + root.data);
		//System.out.println(root.getSize());

	}
	

}
