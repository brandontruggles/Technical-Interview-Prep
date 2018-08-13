/*
  This problem has no clear-cut "best solution". The better solution depends if you want lower space or time complexity. Below I'm using a solution with O(n) space complexity and O(n) time complexity, but there is also another solution with O(1) space complexity and O(n^2) time complexity.
*/

import java.util.Random;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
  static Random r = new Random();

	public static void main(String [] args) {
    Node list1 = generateList(10);
    outputList(list1);
    BestSolution.removeDups(list1);
    outputList(list1);
    Node list2 = generateList(0);
    outputList(list2);
    BestSolution.removeDups(list2);
    outputList(list2);
    Node list3 = generateList(20);
    outputList(list3);
    BestSolution.removeDups(list3);
    outputList(list3);
    Node list4 = generateList(1);
    outputList(list4);
    BestSolution.removeDups(list4);
    outputList(list4);
	}

  //Helper function to generate a linked list of length n.
  public static Node generateList(int length) {
    Node head = null;
    Node curr = null;
    for(int i = 0; i < length; i++) {
      if(i == 0) {
        head = new Node(r.nextInt(10));
        curr = head;
      }
      else {
        curr.next = new Node(r.nextInt(10));
        curr = curr.next;
      }
    }
    return head;
  }

  //Helper function to output a linked list.
  public static void outputList(Node head) {
    Node curr = head;
    while(curr != null) {
      System.out.print(curr.value + "->");
      curr = curr.next;
    }
    System.out.println("null");
  }
}

class BestSolution {

	/*public static void removeDups(Node head) {
    HashSet<Integer> uniqueSet = new HashSet<Integer>();
    Node pointer;
    pointer = head;
    while(pointer != null) {
      uniqueSet.add(pointer.value);
      pointer = pointer.next;
    }
    pointer = head;
    int count = 0;
    for(Iterator<Integer> iterator = uniqueSet.iterator(); iterator.hasNext();) {
      pointer.value = iterator.next();
      count++;
      if(count < uniqueSet.size()) {
        pointer = pointer.next;
      }
    }
    if(pointer != null) {
      pointer.next = null;
    }
	}*/

  /*This is the O(n^2) solution with O(1) space complexity mentioned in the comments above.*/

	public static void removeDups(Node head) {
    Node pointer = head;
    while(pointer != null) {
      Node pointerTwo = pointer;
      int currVal = pointer.value;
      while(pointerTwo != null) {
        if(pointerTwo.next != null) {
          if(pointerTwo.next.value == currVal) {
            pointerTwo.next = pointerTwo.next.next;
          }
          else {
            pointerTwo = pointerTwo.next;
          }
        }
        else {
          pointerTwo = pointerTwo.next;
        }
      }
      pointer = pointer.next;
    }
	}
}

//Node class which holds an integer value for simplicity.
class Node {
  public int value;
  public Node next;
  public Node(int val) {
    value = val;
  }
}
