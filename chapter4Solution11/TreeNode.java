package chapter4Solution11;

import java.util.Random;

public class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	int size;
	
	public  TreeNode(int d){
		data=d;
		size=1;
	}
	
	public void insertInOrder(int d){
		if(d<=data){
			if(left==null){
				left=new TreeNode(d);
			}
				else{
				left.insertInOrder(d);
			}
		}
		else{
			if(right==null){
				right=new TreeNode(d);
			}
			else{
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
/*
 * 	Random.nextInt(int n)

	Returns a new pseudo-random integer value which is uniformly distributed between 0 (inclusively) and n (exclusively).

	Parameters:
	n the upper limit of the values that can be returned
	Returns:
	a randomly generated int between 0 and n*/
	
	public TreeNode findRandomNode(){
		int leftsize=left==null?0:left.size();
		Random random=new Random();
		int index=random.nextInt(size);
		if(index<leftsize){
			return left.findRandomNode();
		}
		else if(index==leftsize){
			return this;
		}
		else{
			return right.findRandomNode();
		}
	}
	
	public int size(){
		return size;
	}

	public TreeNode getithNode(int i){
		int leftsize=left==null?0:left.size();
		if(i<leftsize){
			return left.getithNode(i);
		}
		else if(i==leftsize){
			return this;
		}
		else{
			return right.getithNode(i-(leftsize+1));
		}
	}
}
