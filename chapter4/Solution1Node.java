package chapter4;

import chapter4.Solution1.State;

public class Solution1Node {
	
	public State state;
	private Solution1Node adjacent[];
	 private String vertex;
	 public int adjacentCount;
	

	public Solution1Node(String vertex, int adjacentLength) {
		this.vertex=vertex;
		adjacentCount=0;
		adjacent=new Solution1Node[adjacentLength]; // adjacent Nodes created 
	}

	public Solution1Node[] getAdjacentNodes() {
		return adjacent;
	}

	public void adjacentCount(Solution1Node solution1Node) {
		if(adjacentCount<adjacent.length){
			this.adjacent[adjacentCount]=solution1Node;
			adjacentCount++;
		}
		else{
			System.out.println("Cannot add more adjacent nodes");
		}
		
	}


}
