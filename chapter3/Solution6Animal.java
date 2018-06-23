package chapter3;

public abstract class Solution6Animal {
	public String name;
	public int order;
	

	Solution6Animal(String name){
		this.name=name;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	public boolean isOlderThan(Solution6Animal a){
		//System.out.println("a.getorer"+a.getOrder());
		//System.out.println("a.order"+a.order);
		return this.order<a.getOrder();
	}
	
}

