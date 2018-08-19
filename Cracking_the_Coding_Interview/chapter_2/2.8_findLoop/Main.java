/*
  Here I used Floyd's "Tortoise and the Hare" algorithm to detect the loop and find the start of the loop in O(n) time, with O(1) space.
*/

import java.util.Random;

public class Main {
  static Random r = new Random();

  public static void main(String [] args) {
    Node list1 = generateList(10);
    outputList(list1);
    list1.next.next = list1;
    System.out.println(BestSolution.findLoop(list1).value);
    Node list2 = generateList(5);
    outputList(list2);
    System.out.println(BestSolution.findLoop(list2));
    Node list3 = null;
    outputList(list3);
    System.out.println(BestSolution.findLoop(list3));
    Node list4 = generateList(10);
    outputList(list4);
    list4.next.next.next.next.next = list4.next;
    System.out.println(BestSolution.findLoop(list4).value);
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
  public static Node findLoop(Node head) {
    if(head == null || head.next == null) {
      return null;
    }
    Node slow = head.next; //Be careful to initialize these to the correct values...slow must be increments of 1, fast increments of 2.
    Node fast = head.next.next;
    while(slow != fast && slow.next != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    boolean isLoop = (slow == fast);
    if(isLoop) {
      slow = head;
      while(slow != fast) {
        slow = slow.next;
        fast = fast.next;
      }
      return slow;
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
