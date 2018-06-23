package chapter4Solution7a;

import java.util.ArrayList;
import java.util.Stack;


public class Solution7a {

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
		System.out.println("Sequence of nodes");
		if(buildOrder!=null){
			for(String order:buildOrder){
				System.out.println(order);
			}
		}

	}
	
	
	public static String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
		Project[] buildOrder = findBuildOrder(projects, dependencies);
		if (buildOrder == null) return null; //circular dependency
		String[] buildOrderString = convertToStringList(buildOrder);
		return buildOrderString;
	}
	
	public static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}
	
	public static Graph buildGraph(String[] projects,String[][] dependencies){
		Graph graph=new Graph();
		for(String project: projects){
			graph.getOrCreateProject(project);
		}
		
		for(String[] dependency:dependencies){
			String first=dependency[0];
			String second=dependency[1];
			graph.addEdge(first,second);
			
		}
		
		return graph;
	}

	


	
	private static Project[] orderProjects(ArrayList<Project> projects) {
		Project[] order=new Project[projects.size()];
		int endOfList=addNonDependent(order,projects,0);
		int tobeProcessed=0;
		
		while(tobeProcessed<projects.size()){
			Project current=order[tobeProcessed];
			if(current==null)
				return null; //circular dependency
			ArrayList<Project> children=current.getChildren();
			for(Project child:children){
				child.decrementDependencies();
			}
			
			endOfList=addNonDependent(order,children,endOfList);
			tobeProcessed++;
		}
		
		return order;
	}
	private static int addNonDependent(Project[] order,ArrayList<Project> projects, int offset) {
		
		for(Project project:projects){
			if(project.getNumberDependencies()==0){
				order[offset]=project;
				offset++;
			}
			
		}
		return offset;
	}
	
	public static String[] convertToStringList(Project[] projects) {
		String[] buildOrder = new String[projects.length];
		for (int i = 0; i < projects.length; i++) {
			buildOrder[i] = projects[i].getName();
		}
		return buildOrder;
	}

}
