package chapter5;

public class RankNode {
	int left_size=0;
	RankNode left,right;
	int data=0;
	
	RankNode(int d){
		data=d;
	}
	
	public void insert(int d){
		if(d<=data){
			if(left==null){
				left=new RankNode(d);
			}
			else{
				left.insert(d);
			}
			left_size++;
		}
		else{
			if(right==null){
				right=new RankNode(d);
			}
			else{
				right.insert(d);
			}
		}
		
	}
	
	public int getRank(int d){
		if(d==data){
			return left_size;
		}
		else if(d<data){
			if(left == null) return -1;
			else return left.getRank(d);
		}
		else{
			int right_rank=right==null?-1:right.getRank(d);
			if(right_rank==-1){
				return -1;
			}
		return left_size+1+right_rank; 
		}
		
	}

}
