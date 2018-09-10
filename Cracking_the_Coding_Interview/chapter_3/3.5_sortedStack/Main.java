/*

*/

public class Main {

	public static void main(String [] args) {
    SortedStack stack = new SortedStack();
    stack.push(5);
    stack.push(8);
    System.out.println(stack.peek());
    stack.push(1);
    stack.push(4);
    while(!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
	}

}

class BestSolution {

}

class SortedStack {

  StackNode top;
  StackNode auxTop;

  public SortedStack() {

  }

  public void push(int val) {
    if(top == null) {
      top = new StackNode(val);
    }
    else {
      StackNode tmp;
      while(top != null && val > top.value) {
        tmp = auxTop;
        auxTop = new StackNode(top.value);
        auxTop.next = tmp;
        top = top.next;
      }
      tmp = top;
      top = new StackNode(val);
      top.next = tmp;
      while(auxTop != null) {
        tmp = top;
        top = new StackNode(auxTop.value);
        top.next = tmp;
        auxTop = auxTop.next;
      }
    }
  }

  public int pop() {
    int val = top.value;
    top = top.next;
    return val;
  }

  public int peek() {
    int val = top.value;
    return val;
  }

  public boolean isEmpty() {
    return (top == null);
  }

}

class StackNode {
  public StackNode next;
  public int value;
  public StackNode(int val) {
    value = val;
  }
}
