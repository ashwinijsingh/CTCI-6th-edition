package chapter4;

public class Solution1Graph {
	private static int MAX_VERTICES = 6;
	private Solution1Node vertices[];	//Array of all the nodes nodes in the graph
	private int count;

	public Solution1Graph() {
		vertices = new Solution1Node[MAX_VERTICES]; //When define a graph you mention the number of nodes
		count = 0;									//you keep a count so that you wont exceed the defined number of nodes
    }
	public Solution1Node[] getNodes() {
		return vertices;				//Return the Array which contains the list of all the nodes in the graph
	}
	
	

	public void addNode(Solution1Node solution1Node) {
		if(count<vertices.length){			//check if the size of the graph has exceeded the number of nodes defined initially
			vertices[count]=solution1Node;
			count++;
		}
		else{
			System.out.println("Grapgh Full: Cannot add the node to the graph");
		}
		
	}

}
