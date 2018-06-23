package chapter4;

public class Solution5MinMax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {10,15,17,20,25};
		TreeNode node = TreeNode.createMinimalBST(array);
		System.out.println(checkBST(node,null,null));

	}
	
	static boolean checkBST(TreeNode n,Integer min,Integer max){
		if(n==null) return true;
		
		if((min!=null && n.data<=min)||(max!=null && n.data> max)){
			return false;
		}
		if(!checkBST(n.left,min,n.data)||!checkBST(n.right,n.data,max)){
			return false;
		}
		return true;
	}

}
