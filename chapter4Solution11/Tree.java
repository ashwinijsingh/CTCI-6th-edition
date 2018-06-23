package chapter4Solution11;

import java.util.Random;

public class Tree {
	TreeNode root=null;

	public void insertInOrder(int d){
		if(root==null){
			root=new TreeNode(d);
		}
		else {
			root.insertInOrder(d);
		}
	}

	public TreeNode getRandomNode(){
		if(root==null){
			return null; 
		}
		Random random=new Random();
		int index=random.nextInt(root.size());
		return root.getithNode(index);
	}
}
