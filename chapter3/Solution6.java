package chapter3;

public class Solution6 {

	/**
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {


		
		Solution6AnimalQueue animals = new Solution6AnimalQueue();
		animals.enQueue(new Solution6Cat("Callie"));
		animals.enQueue(new Solution6Cat("Kiki"));
		animals.enQueue(new Solution6Dog("Fido"));
		animals.enQueue(new Solution6Dog("Dora"));
		animals.enQueue(new Solution6Cat("Kari"));
		animals.enQueue(new Solution6Dog("Dexter"));
		animals.enQueue(new Solution6Dog("Dobo"));
		animals.enQueue(new Solution6Cat("Copa"));
		
		System.out.println(animals.deQueueAny().name);	
		System.out.println(animals.deQueueAny().name);	
		System.out.println(animals.deQueueAny().name);	
		
		animals.enQueue(new Solution6Dog("Dapa"));
		animals.enQueue(new Solution6Cat("Kilo"));
		
		System.out.println();
		while (animals.size() != 0) {
			System.out.println(animals.deQueueAny().name);	
		}
	}


	}


