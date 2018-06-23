package chapter4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * 
 * LIST OF DEPTHS:
1)	Both DFS and BFS run at O(N) Time:
2)	BFS is more space efficient ?
	a.	In a way correct: As DFS uses O(LogN) recursive calls in a balanced tree (depth=Log(N)) and each of which will add a new level of stack. 
	b.	BFS is iterative hence no extra stack for this solution.
	c.	Both the solutions return O(N) data hence DFS space of O(LogN) will now become O(N).
		Hence both solutions are equally efficient.
 	  
 *
 */


public class Solution3BFS {

	public static void main(String[] args) {
		
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);
		

	}
	


public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		
		ArrayList<LinkedList<TreeNode>> result=new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current=new LinkedList<TreeNode>(); //LinkedList L0
		
		if(root!=null){
			current.add(root); 
		}
		
		
		while(current.size()>0){
			System.out.println("size of current"+current.size());
			result.add(current);       			 //Add L0,L1,L2.. to the final result
			LinkedList<TreeNode> parents=current;// can be L0,L1,L2...Need to store the previous nodes as parents
			current=new LinkedList<TreeNode>();  //LinkedList L1,L2...
			for(TreeNode parent:parents){
				if(parent.left!=null){
					current.add(parent.left);
				}
				if(parent.right!=null){
					current.add(parent.right);
				}

			}
		}
		return result;
	}	

	private static void printResult(ArrayList<LinkedList<TreeNode>> result) {
	
		int depth=0;
		for(LinkedList<TreeNode> entry: result){
			Iterator<TreeNode> i=entry.listIterator(); //returns a ListIterator on the elements of this List
			System.out.print("Linked List at depth "+depth+" : ");
			while(i.hasNext()){
				System.out.print(" "+i.next().data);
				}
			System.out.println();
			depth++;
			}
		}
	
}
