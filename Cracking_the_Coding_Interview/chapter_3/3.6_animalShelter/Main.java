/*

*/

import java.util.LinkedList;
import java.util.Random;

public class Main {

	public static void main(String [] args) {
    ShelterQueue queue = new ShelterQueue();
    queue.enqueue(new Dog());
    queue.enqueue(new Cat());
    queue.enqueue(new Cat());
    queue.enqueue(new Cat());
    queue.enqueue(new Dog());
    System.out.println(queue.dequeueAny());
    System.out.println(queue.dequeueCat());
    System.out.println(queue.dequeueDog());
    System.out.println(queue.dequeueAny());
    System.out.println(queue.dequeueAny());
	}

}

class BestSolution {

}

class ShelterQueue {
  LinkedList<Dog> dogList;
  LinkedList<Cat> catList;
  Random r;
  public ShelterQueue() {
    dogList = new LinkedList<Dog>();
    catList = new LinkedList<Cat>();
    r = new Random();
  }

  public void enqueue(Animal a) {
    if(a instanceof Dog) {
      dogList.add((Dog)a);
    }
    else if(a instanceof Cat) {
      catList.add((Cat)a);
    }
  }

  public Animal dequeueAny() {
    if(catList.isEmpty() && dogList.isEmpty()) {
      throw new ArrayIndexOutOfBoundsException();
    }
    else if(catList.isEmpty()) {
      return dogList.poll();
    }
    else if(dogList.isEmpty()) {
      return catList.poll();
    }
    int rand = r.nextInt(2);
    return (rand == 0 ? dogList.poll() : catList.poll());
  }

  public Dog dequeueDog() {
    if(dogList.isEmpty()) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return dogList.poll();
  }

  public Cat dequeueCat() {
    if(catList.isEmpty()) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return catList.poll();
  }
}

class Animal {
  
}

class Dog extends Animal {

}

class Cat extends Animal {

}
