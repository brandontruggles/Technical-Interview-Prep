/*

*/

import java.util.Stack;

public class Main {

	public static void main(String [] args) {
    MyQueue queue = new MyQueue();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    System.out.println(queue.peek());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
	}

}

class BestSolution {

}

class MyQueue {
  Stack<Integer> stack;
  Stack<Integer> auxStack;

  public MyQueue() {
    stack = new Stack<Integer>();
    auxStack = new Stack<Integer>();
  }

  public void add(int val) {
    stack.push(val);
  }

  public void moveToAux() {
      while(stack.size() > 0) {
        auxStack.push(stack.pop());
      }
  }

  public int peek() {
    if(stack.size() == 0 && auxStack.size() == 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    if(auxStack.size() == 0) {
      moveToAux();
    }
    return auxStack.peek();
  }

  public int dequeue() {
    if(stack.size() == 0 && auxStack.size() == 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    if(auxStack.size() == 0) {
      moveToAux();
    }
    return auxStack.pop();
  }
}
