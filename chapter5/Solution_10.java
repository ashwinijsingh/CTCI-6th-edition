package chapter5;

public class Solution_10 {

	private static RankNode root=null;
	
	public static void track(int d){
		if(root==null){
			root=new RankNode(d);
		}
		else{
			root.insert(d);
		}
	}
	
	public static int getRankofValue(int d){
		return root.getRank(d);

		
	}
	
	
	public static void main(String[] args) {
		
		int[] list = {20,15,10,5,13,25,23,24};
		for (int i = 0; i < list.length; i++) {
			track(list[i]);
		}
	
		System.out.println("rank of "+"10"+" is : "+getRankofValue(25));
	}

}
