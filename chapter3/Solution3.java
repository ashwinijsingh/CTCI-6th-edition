package chapter3;

public class Solution3 {

	/**
	 * STACK OF PLATES
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int capacity_per_substack = 5;
		Solution3SetofStacks set = new Solution3SetofStacks(capacity_per_substack);
		
		System.out.println(" Push");
		for (int i = 0; i < 11; i++) {
			set.push(i);
		}
		System.out.println("\n Pop \n");
		for (int i = 0; i < 11; i++) {
			System.out.println("Popped " + set.pop());
		}
		
		System.out.println(" Push");
		for (int i = 0; i < 12; i++) {
			set.push(i);
		}
		
		System.out.println("Popped at index "+set.popAtindex(1));
		
		
		System.out.println("\n Pop \n");
		for (int i = 0; i < 11; i++) {
			System.out.println("Popped " + set.pop());
		}
		
	}
	
	
	

}
