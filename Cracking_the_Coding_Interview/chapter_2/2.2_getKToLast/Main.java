/*
  Assumed that our given index is between 1 and the size of the list. Also assumed that index 1 would return the last element in the list.
*/

import java.util.Random;

public class Main {
  static Random r = new Random();

	public static void main(String [] args) {
    Node list1 = generateList(10);
    outputList(list1);
    System.out.println(BestSolution.getKToLast(list1, 1).value);
    Node list2 = generateList(10);
    outputList(list2);
    System.out.println(BestSolution.getKToLast(list2, 10).value);
    Node list3 = generateList(10);
    outputList(list3);
    System.out.println(BestSolution.getKToLast(list3, 5).value);
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
  public static Node getKToLast(Node head, int k) {
    int size = 0;
    Node pointer = head;
    while(pointer != null) {
      size++;
      pointer = pointer.next;
    }
    pointer = head;
    int target = size - k + 1;
    int currIdx = 0;
    while(pointer != null) {
      currIdx++;
      if(currIdx == target) {
        return pointer;
      }
      pointer = pointer.next;
    }
    return null;
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
