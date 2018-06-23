package chapter4;

public class TreeNode {
	
	int data;
	TreeNode left,right,parent;
	private int size = 0;
	
	public TreeNode(int value) {
		this.data=value;
	}
	
	//Solution 2
	public static TreeNode createMinimalBST(int[] array) {	
		return createMinimalBST(array,0,array.length-1);
	}
	
	//Solution 2
	public static TreeNode createMinimalBST(int a[],int start,int end){
		if(end<start){
			return null;
		}
		int mid=(start+end)/2;
		TreeNode n=new TreeNode(a[mid]);
		n.left=createMinimalBST(a,start,mid-1);
		n.right=createMinimalBST(a,mid+1,end);
		return n;
	}

	//Solution 4
	public void insertInOrder(int d) {
		if (d <= data) {
			if (left == null) {
				setLeftChild(new TreeNode(d));
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				setRightChild(new TreeNode(d));
			} else {
				right.insertInOrder(d);
			}
		}
		setSize(getSize() + 1);
	}

	private void setLeftChild(TreeNode left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}
	
	
	private void setRightChild(TreeNode right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}

	//Solution 6
	public TreeNode find(int d) {
		if (d == data) {
			return this;
		} else if (d <= data) {
			return left != null ? left.find(d) : null;
		} else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	



}
