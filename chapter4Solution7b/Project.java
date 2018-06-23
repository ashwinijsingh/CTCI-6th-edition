package chapter4Solution7b;

import java.util.ArrayList;
import java.util.HashMap;

import chapter4Solution7b.Project.STATE;

public class Project {

	String name;
	ArrayList<Project> children=new ArrayList<Project>();
	HashMap<String,Project> map=new HashMap<String,Project>();
	enum STATE {COMPLETE,PARTIAL,BLANK};
	STATE state=STATE.BLANK;
	Project(String n){
		name=n;
	}
	
	public void addChildren(Project child){
		if(!map.containsKey(child.getName())){
			children.add(child);
			map.put(child.getName(), child);
					}
	}


	public String getName() {
	
		return name;
	}
	
	public STATE getState(){
		return state;
	}
	
	public ArrayList<Project> getChildren(){
		return children;
	}

	public void setState(STATE st) {
		state=st;
		
	}
	
	

}
