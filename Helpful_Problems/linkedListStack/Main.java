//A simple implementation of a stack using a singly-linked list.

public class Main {
	public static void main(String [] args) {
    Stack stack = new Stack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack.peek());
    System.out.println(stack.isEmpty());
    System.out.println(stack.pop());
    System.out.println(stack.peek());
    System.out.println(stack.isEmpty());
    System.out.println(stack.pop());
    System.out.println(stack.peek());
    System.out.println(stack.isEmpty());
    System.out.println(stack.pop());
    System.out.println(stack.isEmpty());
	}
}

class Stack {
  StackNode top;
  public Stack() {
    
  }

  public void push(int val) {
    top = new StackNode(val, top);
  }

  public int peek() {
    int topVal = top.value;
    return topVal;
  }

  public int pop() {
    int topVal = top.value;
    top = top.next;
    return topVal;
  }

  public boolean isEmpty() {
    if(top == null) {
      return true;
    }
    return false;
  }
}

class StackNode {
  public int value;
  public StackNode next;

  public StackNode(int val, StackNode nxt) {
    value = val;
    next = nxt;
  }
}
