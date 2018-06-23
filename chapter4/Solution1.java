package chapter4;

import java.util.LinkedList;
/**
 * ROUTE BETWEEN NODES 	
 */
public class Solution1 {
	public static void main(String args[]){
		Solution1Graph g = createNewGraph();
		Solution1Node[] n = g.getNodes();
		Solution1Node start = n[3];
		Solution1Node x=new Solution1Node("x",0);
		Solution1Node end = x;
		System.out.println(search(g, start, end));
	}
	
	
	//Creating a new graph
	public static Solution1Graph createNewGraph(){
		
		Solution1Graph g = new Solution1Graph();  
		
		Solution1Node[] temp=new Solution1Node[6]; //defining an array of Node of size 6
		//creating temporary nodes and defining the number of adjacent nodes
		temp[0]	= new Solution1Node("a",3);
		temp[1] = new Solution1Node("b", 0);
		temp[2] = new Solution1Node("c", 0);
		temp[3] = new Solution1Node("d", 1);
		temp[4] = new Solution1Node("e", 1);
		temp[5] = new Solution1Node("f", 1);
		// connecting the temporarty nodes with the adjacent nodes
		temp[0].adjacentCount(temp[1]);
		temp[0].adjacentCount(temp[2]);
		temp[0].adjacentCount(temp[3]);
		temp[3].adjacentCount(temp[4]);
		temp[4].adjacentCount(temp[5]);
		temp[5].adjacentCount(temp[0]);
		//Adding the nodes to the graph
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		
		return g;
	}
	
	//Defining an enumerator where we can store if the node has been visited or nore
	public enum State {
		Unvisited,Visited,Visiting;
	}
	//Search if there is a route between two points
	public static boolean search(Solution1Graph g,Solution1Node start, Solution1Node end){
		
		
		if(start==end)	return true;						//if the start and end node are the same then there is a Route
		LinkedList<Solution1Node> q=new LinkedList<Solution1Node>();	
		
		for(Solution1Node u: g.getNodes()){ 	// get all the nodes nodes in the graph
			u.state=State.Unvisited;			//make the state of all the nodes as 'UNVISITED'
		}
		
		q.add(start);							//add the start node to the queue
		Solution1Node u;						//temporary variable node
		while(!q.isEmpty()){
			 u=q.pop();
			 if(u!=null){
				 for(Solution1Node v: u.getAdjacentNodes()){
					 if(v.state == State.Unvisited){
					 if(v==end){
						 return true;				//if the node is equal to the end then return true
					 }
					 else{
						 v.state=State.Visiting;	//else we make the state of the node as 'VISITING'
						 q.add(v);					//add the VISITING state to the queue
					 }
				 }
				 }
			 }
			 u.state=State.Visited; //once the state is popped from the queue we make the state as 'VISITED'
		}
		return false;
	}
}
