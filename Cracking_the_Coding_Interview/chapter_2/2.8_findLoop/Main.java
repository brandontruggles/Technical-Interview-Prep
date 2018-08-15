/*

*/

import java.util.Random;

public class Main {
  static Random r = new Random();

  public static void main(String [] args) {
    Node list1 = generateList(10);
    list1.next = list1;
    System.out.println(BestSolution.findLoop(list1).value);
    Node list2 = generateList(5);
    System.out.println(BestSolution.findLoop(list2));
    Node list3 = null;
    System.out.println(BestSolution.findLoop(list3));
    Node list4 = generateList(10);
    list4.next.next.next = list4;
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
    Node slow = head;
    Node fast = head.next;
    while(slow != fast && slow.next != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    boolean isLoop = (slow == fast);
    if(isLoop) {
      slow = head;
      while(slow != fast) {
        System.out.println("Slow: " + slow.value);
        System.out.println("Fast: " + fast.value);
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
