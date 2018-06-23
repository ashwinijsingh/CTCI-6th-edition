package chapter4;


public class Solution_12 {

	/**
	 * PATHS WITH SUM
	 * Solution 2 is in special project as it required java 1.8
	 */
	public static void main(String[] args) {
		
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);		
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(-8);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);	
		root.right.left.left = new TreeNode(0);
		System.out.println("SOLUTION1"+ countPathsWithSum(root, 0));
		
//		TreeNode root = new TreeNode(-7);
//		root.left = new TreeNode(-7);
//		root.left.right = new TreeNode(1);
//		root.left.right.left = new TreeNode(2);
//		root.right = new TreeNode(7);
//		root.right.left = new TreeNode(3);
//		root.right.right = new TreeNode(20);
//		root.right.right.left = new TreeNode(0);
//		root.right.right.left.left = new TreeNode(-3);
//		root.right.right.left.left.right = new TreeNode(2);
//		root.right.right.left.left.right.left = new TreeNode(1);
//		System.out.println(countPathsWithSum(root, -14));
		
		/*TreeNode root = new TreeNode(0);
		root.left = new TreeNode(0);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.left.right = new TreeNode(0);
		root.right.right = new TreeNode(0);
		System.out.println(countPathsWithSum(root, 0));
		System.out.println(countPathsWithSum(root, 4));*/
	}

	public static int countPathsWithSum(TreeNode node,int sum){
		if(node==null) return 0;
		int totalPathfromRoot=countPathsFromNode(node,sum,0);
		
		int leftPath=countPathsWithSum(node.left,sum);
		int rightPath=countPathsWithSum(node.right,sum);
		
		return totalPathfromRoot+leftPath+rightPath;
		
	}
	
	public static int countPathsFromNode(TreeNode node,int targetsum, int currentsum){
		if(node==null) return 0;
		System.out.println("Node : "+node.data);
		System.out.print("Current Sum ="+currentsum+"+"+node.data);
		 currentsum+=node.data;
		 System.out.println(" = "+currentsum);
		 int totalpath=0;
		 if(targetsum==currentsum){
			 totalpath++;
		 }
		 System.out.println("Total Path"+totalpath);
		 if(node.left!=null){
		 System.out.println("Left total paths : totalpath ="+totalpath+ " countPathsFromNode("+node.left.data+" , "+ targetsum + " , "+currentsum+")" );
		 }
		 else{
			 System.out.println("Left total paths : totalpath ="+totalpath+ " countPathsFromNode(+"+"NULL"+" , "+ targetsum + " , "+currentsum+")" );
		 }
		 totalpath+=countPathsFromNode(node.left,targetsum,currentsum);
		 System.out.println("Left total paths is :"+totalpath);
		 if(node.right!=null){
		 System.out.println("Right total paths : totalpath ="+totalpath+ " countPathsFromNode("+node.right.data+" , "+ targetsum + " , "+currentsum+")" );
		 }
		 else{
			 System.out.println("Right total paths : totalpath ="+totalpath+ " countPathsFromNode(+"+"NULL"+" , "+ targetsum + " , "+currentsum+")" );
		 }
		 totalpath+=countPathsFromNode(node.right,targetsum,currentsum);
		 System.out.println("Right total paths is :"+totalpath);
		 System.out.println("return :"+totalpath);
		 return totalpath;
	}


}
