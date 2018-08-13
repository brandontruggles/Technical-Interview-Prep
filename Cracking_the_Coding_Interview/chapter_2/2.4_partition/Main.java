/*
   There are two possible solutions here, one that uses O(n) space and time complexity, and one that uses O(n^2) time complexity and O(1) space complexity.
*/

import java.util.Random;

public class Main {
  static Random r = new Random();

	public static void main(String [] args) {
    Node list1 = generateList(10);
    outputList(list1);
    outputList(BestSolution.partition(list1, 5));
    Node list2 = generateList(10);
    outputList(list2);
    outputList(BestSolution.partition(list2, 1));
    Node list3 = generateList(10);
    outputList(list3);
    outputList(BestSolution.partition(list3, 10));
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
    /* This is the shorter solution with O(n) space and time complexity. */
  /*
  public static Node partition(Node head, int x) {
    Node newHead = null;
    Node newPtr = head;
    Node pointer = head;
    while(pointer != null) {
      if(pointer.value < x) {
        if(newHead == null) {
          newHead = new Node(pointer.value);
          newPtr = newHead;
        }
        else {
          newPtr.next = new Node(pointer.value);
          newPtr = newPtr.next;
        }
      }
      pointer = pointer.next;
    }
    pointer = head;
    while(pointer != null) {
      if(pointer.value >= x) {
        if(newHead == null) {
          newHead = new Node(pointer.value);
          newPtr = newHead;
        }
        else {
          newPtr.next = new Node(pointer.value);
          newPtr = newPtr.next;
        }
      }
      pointer = pointer.next;
    }
    return newHead;
  } */

  /* This is the more complex solution with O(n^2) time complexity and O(1) space complexity. */
  public static Node partition(Node head, int x) {
    Node pointer = head;
    while(pointer != null) {
      if(pointer.value >= x) {
        Node siftPointer = pointer;
        while(siftPointer.next != null) {
          siftPointer = siftPointer.next;
        }
        swap(pointer, siftPointer);
      }
      pointer = pointer.next;
    }
    return head;
  } 

  //Helper function to swap the values of two Node objects.
  public static void swap(Node one, Node two) {
    int tmp = one.value;
    one.value = two.value;
    two.value = tmp;
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
