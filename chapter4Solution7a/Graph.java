package chapter4Solution7a;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	ArrayList<Project> nodes=new ArrayList<Project>();
	HashMap<String,Project> map=new HashMap<String,Project>();
	
	public Project getOrCreateProject(String project) {
	if(!map.containsKey(project)){
		Project node=new Project(project);
		nodes.add(node);
		map.put(project, node);
	}
		return map.get(project);
	}

	public void addEdge(String first, String second) {
		Project start= getOrCreateProject(first);
		Project end= getOrCreateProject(second);
		start.addNeighbour(end);
		
	}

	public ArrayList<Project> getNodes() {

		return nodes;
	}
	
}
