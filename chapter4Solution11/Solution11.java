package chapter4Solution11;





public class Solution11 {

	/**
	 * RANDOM NODE
	 */
	public static void main(String[] args) {
		int[] array = {10,30,5,15,17,3,7};
		TreeNode tree = new TreeNode(20);
		for(int i=0;i<array.length;i++){
		tree.insertInOrder(array[i]);
		}
		
		System.out.println(tree.findRandomNode().data);
		
		int[] counts = new int[10];
		for (int i = 0; i < 1000000; i++) {
			Tree tree1 = new Tree();
			int[] array1 = {1, 0, 6, 2, 3, 9, 4, 5, 8, 7};
			for (int x : array1) {
				tree1.insertInOrder(x);
			}
			int d = tree1.getRandomNode().data;
			counts[d]++;
		}
		
		for (int i = 0; i < counts.length; i++) {
			System.out.println(i + ": " + counts[i]);
		}
		

	}

}
