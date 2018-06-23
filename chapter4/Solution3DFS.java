package chapter4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * 
 * LIST OF DEPTHS
 *
 */
public class Solution3DFS {
	public static void main(String[] args) {
		
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		//Create a TREE from an array
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);
	}
	
public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		
		ArrayList<LinkedList<TreeNode>> lists=new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root,lists,0); //when you pass an array it will modify that array itself wont create a new array.	Hence not assigning it to any other array.
		return lists;
	}	
	
	public static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		if(root==null)
			return;
		LinkedList<TreeNode> list=null;
		
		if(lists.size()==level){
			System.out.println("level" +level);
			list=new LinkedList<TreeNode>();
			lists.add(list);
		}
		else{
			System.out.println(lists.size());
			list=lists.get(level);
			
		}
		list.add(root);
		createLevelLinkedList(root.left,lists,level+1);
		createLevelLinkedList(root.right,lists,level+1);
		
	}
	
	
	public static void printResult(ArrayList<LinkedList<TreeNode>> result){
		int depth = 0;
		System.out.println("More efficient print");
		
		for(LinkedList<TreeNode> entry:result){
			Iterator<TreeNode> i=entry.listIterator(); //returns a ListIterator on the elements of this List
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" "+i.next().data);
			}
			System.out.println("");
			depth++;
		}

		
		System.out.println("My own print");
		for (int i = 0; i < result.size(); i++) {
			LinkedList<TreeNode> temp=new LinkedList<TreeNode>();
			temp.addAll(result.get(i));
			System.out.println("Level "+i);
			for (int j = 0; j < temp.size(); j++) {
				System.out.println(temp.get(j).data);
			}
			
		}
	}
	



}
