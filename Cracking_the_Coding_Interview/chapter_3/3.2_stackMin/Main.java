/*

*/

import java.util.Stack;

public class Main {

	public static void main(String [] args) {
    MinStack stack = new MinStack();
    stack.push(5);
    stack.push(2);
    stack.push(3);
    stack.push(6);
    System.out.println(stack.min());
    System.out.println(stack.pop());
    System.out.println(stack.min());
    System.out.println(stack.pop());
    System.out.println(stack.min());
    System.out.println(stack.pop());
    System.out.println(stack.min());
    System.out.println(stack.pop());
	}

}

class BestSolution {

}

class MinStack {
  Stack<Integer> stack;
  Stack<Integer> mins;
  public MinStack() {
    stack = new Stack<Integer>();
    mins = new Stack<Integer>();
  }
  public void push(int num) {
    if(mins.size() > 0) {
      if(num <= min()) {
        mins.push(num);
      }
    }
    else {
      mins.push(num);
    }
    stack.push(num);
  }
  public int pop() {
    int popped = stack.pop();
    if(popped == min()) {
      mins.pop();
    }
    return popped;
  }
  public int peek() {
    return stack.peek();
  }
  public int min() {
    return mins.peek();
  }
}
