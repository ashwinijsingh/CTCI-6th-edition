package chapter4Solution7b;

import java.util.ArrayList;
import java.util.Stack;




public class Solution7b {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] projects = {"a", "b", "c", "d", "e", "f"};
		String[][] dependencies = {
				{"a", "d"},
				{"f", "b"},
				{"b", "d"},
				{"f", "a"},
				{"d", "c"}
				//,{"c", "a"} // this will give circular dependency
				};
		String[] buildOrder = buildOrderWrapper(projects, dependencies);
		
		if (buildOrder == null) {
			System.out.println("Circular Dependency.");
		} else {
			for (String s : buildOrder) {
				System.out.println(s);
			}
		}
		

	}
	
	
	
	
	public static String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
		Stack<Project> buildOrder = findBuildOrder(projects, dependencies);
		if (buildOrder == null) return null;
		String[] buildOrderString = convertToStringList(buildOrder);
		return buildOrderString;
	}
	
	 static Stack<Project> findBuildOrder(String[] projects,String[][] dependencies){
		Graph graph=buildGraph(projects,dependencies);
		return buildOrder(graph.getNodes());
		
	}
	 
	 

	private static Graph buildGraph(String[] projects,String[][] dependencies) {
		Graph graph=new Graph();
		
		for(String project:projects){
			graph.getorAddProject(project);
		}
		
		for(String[] dependency: dependencies){
			String first=dependency[0];
			String second=dependency[1];
			graph.addEdge(first,second);
		}
	
		return graph;
	}
	
	static Stack<Project> buildOrder(ArrayList<Project> projects){
		Stack<Project> st=new Stack<Project>();
		for(Project project:projects){
			if(project.getState()==Project.STATE.BLANK){
				if(!doDFS(project,st)){
					return null;
				}
			}
		}
		return st;
	}
	
	static boolean doDFS(Project project,Stack<Project> stack){
		if(project.getState()==Project.STATE.PARTIAL){
			return false; //circular dependency
		}
		
		if(project.getState() == Project.STATE.BLANK){
		project.setState(Project.STATE.PARTIAL);
		ArrayList<Project> children=project.getChildren();
		for(Project child:children){
			if(!doDFS(child,stack))
				return false;
		}
		project.setState(Project.STATE.COMPLETE);
		stack.push(project);
		
	}
		return true;
	}
	
	public static String[] convertToStringList(Stack<Project> projects) {
		String[] buildOrder = new String[projects.size()];
		for (int i = 0; i < buildOrder.length; i++) {
			buildOrder[i] = projects.pop().getName();
		}
		return buildOrder;
	}
	
	
}
