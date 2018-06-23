package chapter4Solution7b;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	ArrayList<Project> nodes=new ArrayList<Project>();
	HashMap<String,Project> map=new HashMap<String,Project>();
	
	public Project getorAddProject(String name){
		if(!map.containsKey(name)){
			Project node=new Project(name);
		    nodes.add(node);
		    map.put(name,node);
		}
		return map.get(name);
	}
	
	public void addEdge(String first,String second){
		Project start=map.get(first);
		Project end=map.get(second);
		start.addChildren(end);
	}
	
	public ArrayList<Project> getNodes(){
		return nodes;
	}
	
	
}
