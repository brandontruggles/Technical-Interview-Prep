/*

*/

import java.util.Stack;
import java.util.ArrayList;

public class Main {

	public static void main(String [] args) {
    SetOfStacks stackSet = new SetOfStacks(1);
    stackSet.push(1);
    stackSet.push(2);
    stackSet.push(3);
    stackSet.push(4);
    System.out.println(stackSet.popAt(0));
    System.out.println(stackSet.popAt(1));
    System.out.println(stackSet.pop());
    System.out.println(stackSet.pop());
	}

}

class BestSolution {

}

class SetOfStacks {
  int capacity;
  int currIdx;
  ArrayList<Stack> stackList;
  public SetOfStacks(int capacity) {
    currIdx = 0;
    this.capacity = capacity;
    stackList = new ArrayList<Stack>();
    stackList.add(new Stack<Integer>());
  }
  public void push(int val) {
    if(stackList.get(currIdx).size() == capacity) {
      currIdx++;
    stackList.add(new Stack<Integer>());
      stackList.get(currIdx).push(val);
    }
    else {
      stackList.get(currIdx).push(val);
    }
  }
  public int pop() {
    int val = (Integer)stackList.get(currIdx).pop();
    if(stackList.get(currIdx).size() == 0) {
      stackList.remove(stackList.get(currIdx));
      currIdx--;
    }
    return val;
  }
  public int popAt(int index) {
    int val = (Integer)stackList.get(index).pop();
    if(stackList.get(index).size() == 0) {
      stackList.remove(stackList.get(index));
      currIdx--;
    }
    return val;
  }
}
