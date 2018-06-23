package chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class AssortedMethods {
	//Solution 3
	/* Creates tree by mapping the array left to right, top to bottom. */
	public static TreeNode createTreeFromArray(int[] array) {
		if(array.length>0){
			TreeNode root=new TreeNode(array[0]);
			Queue<TreeNode> q=new LinkedList<TreeNode>(); //Important to have new LinkedList<>();
			q.add(root);
			int i=1;
			boolean done=false;
			while(!done){
				TreeNode r=q.element();	//Gets but not removes the element in the head of the queue. 
				if(r.left==null){
					r.left=new TreeNode(array[i]);
					i++;
					q.add(r.left);
				}
				else if(r.right==null){
					r.right=new TreeNode(array[i]);
					i++;
					q.add(r.right);
				}
				else{
					q.remove();
				}
				if(i==array.length){
					done=true;
				}
			}
		return root;
		}
		else{
			return null;
		}
	}
	
	//Solution 4
	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	//Solution 4
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
}
