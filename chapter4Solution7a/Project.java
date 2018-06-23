package chapter4Solution7a;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {
	private String name;
	private ArrayList<Project> children=new ArrayList<Project>();
	private HashMap<String,Project> map=new  HashMap<String,Project>();
	private int dependencies=0;
	
	Project(String n){
		name=n;
	}
	
	String getName(){
		return name;
	}
	
	ArrayList<Project> getChildren(){
		return children;
	}
	
	int getNumberDependencies(){
		return dependencies;
	}

	public void addNeighbour(Project end) {
	if(!map.containsKey(end.getName())){
		children.add(end);
		map.put(end.getName(), end);
		end.incrementDependencies();
	}	
	}

	public void incrementDependencies() {
		dependencies++;	
	}

	public void decrementDependencies() {
		dependencies--;
		
	}
	
	
	
	
}
