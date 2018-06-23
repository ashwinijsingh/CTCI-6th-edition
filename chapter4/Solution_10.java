package chapter4;

public class Solution_10 {

	/**
	 * Check Subtree:6
	 * 
	 * 
	 * indexOf():
	 * The indexOf() method returns the position of the first occurrence of a specified value in a string.
	 * This method returns -1 if the value to search for never occurs.
	 * 
	 * LastIndexOf()
	 * The lastIndexOf() method returns the position of the last occurrence of a specified value in a string.
	 * Note: The string is searched from the end to the beginning, but returns the index starting at the beginning, at position 0.
	 * 
	 */
	public static void main(String[] args) {
	System.out.println("Solution 1");
		// t2 is a subtree of t1
				int[] array1 = {1, 2, 1, 3, 1, 1, 5};
				int[] array2 = {2, 3, 1};
				
				TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
				TreeNode t2 = AssortedMethods.createTreeFromArray(array2);

				if (containsTree(t1, t2)) {
					System.out.println("t2 is a subtree of t1");
				} else {
					System.out.println("t2 is not a subtree of t1");
				}

				// t4 is not a subtree of t3
				int[] array3 = {1, 2, 3};
				TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
				TreeNode t4 = AssortedMethods.createTreeFromArray(array3);

				if (containsTree(t3, t4)) {
					System.out.println("t4 is a subtree of t3");
				} else {
					System.out.println("t4 is not a subtree of t3");
				}
			
	System.out.println("---------------------");
	
	System.out.println("Solution 2");
	
	// t2 is a subtree of t1
//			int[] array1 = {1, 2, 1, 3, 1, 1, 5};
//			int[] array2 = {2, 3, 1};
			
//			TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
//			TreeNode t2 = AssortedMethods.createTreeFromArray(array2);

			if (containsTree1(t1, t2)) {
				System.out.println("t2 is a subtree of t1");
			} else {
				System.out.println("t2 is not a subtree of t1");
			}

			// t4 is not a subtree of t3
//			int[] array3 = {1, 2, 3};
//			TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
//			TreeNode t4 = AssortedMethods.createTreeFromArray(array3);

			if (containsTree1(t3, t4)) {
				System.out.println("t4 is a subtree of t3");
			} else {
				System.out.println("t4 is not a subtree of t3");
			}
	
	}

	
	public static boolean containsTree(TreeNode t1, TreeNode t2){
		StringBuilder s1=new StringBuilder();
		StringBuilder s2=new StringBuilder();
		
		getOrder(t1,s1);
		getOrder(t2,s2);
		
		System.out.println("String 1: "+s1.toString());
		System.out.println("String 2: "+s2.toString());
		
		System.out.println("Index :"+s1.indexOf(s2.toString()));
		
		System.out.println(s1.lastIndexOf(s2.toString()));
		
		return s1.indexOf(s2.toString()) !=-1;
		
	}

	private static void getOrder(TreeNode node, StringBuilder s1) {
		if(node==null){
			s1.append("X");
			return;
		}
		s1.append(node.data+" ");
		getOrder(node.left,s1);
		getOrder(node.right,s1);
		
	}
	
	//Solution 2
	
	private static boolean containsTree1(TreeNode t1,TreeNode t2){
		if(t2==null) return true;
		return subTree(t1,t2);
	}


	private static boolean subTree(TreeNode r1, TreeNode r2) {
		if(r1==null)
		return false;
		else if(r1.data==r2.data && matchTree(r1,r2)){
		return true; 
		}
		
		return subTree(r1.left,r2) || subTree(r1.right,r2);
		
	}


	private static boolean matchTree(TreeNode r1, TreeNode r2) {
		
		if(r1==null && r2==null){
		
			return true;
		}
		else if(r1==null || r2==null){
			return false;
		}
		else if(r1.data!=r2.data){
			return false;
		}
		else{
		return matchTree(r1.left,r2.left) && matchTree(r1.right,r2.right);
		}
	}
	

}
