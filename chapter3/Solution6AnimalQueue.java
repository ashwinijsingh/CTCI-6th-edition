package chapter3;

import java.util.LinkedList;

public class Solution6AnimalQueue {
	LinkedList<Solution6Dog> dog=new LinkedList<Solution6Dog> ();
	LinkedList<Solution6Cat> cat=new LinkedList<Solution6Cat> ();
	private int order=0;
	
	public void enQueue(Solution6Animal a){
		a.setOrder(order);
		order++;
		if(a instanceof Solution6Dog) dog.addLast((Solution6Dog) a);
		else if(a instanceof Solution6Cat) cat.addLast((Solution6Cat) a);
		}
	
	public Solution6Animal deQueueAny(){
		if(dog.size()==0){
			return deQueueCat();
		}
		else if(cat.size()==0){
			return deQueueDog();
		}
		else{
			Solution6Cat c=cat.peek();
			Solution6Dog d=dog.peek();
			if(c.isOlderThan(d)){
				return deQueueCat() ;
			}
			else{
				return deQueueDog();
			}
			
		}
	}

	private Solution6Animal deQueueDog() {
	//Gets and removes the element in the head of the queue, or returns null if there is no element in the queue.
		return dog.poll();
	}

	private Solution6Animal deQueueCat() {
		return cat.poll();
	}
	
	public int size() {
		return dog.size() + cat.size();
	}
}
