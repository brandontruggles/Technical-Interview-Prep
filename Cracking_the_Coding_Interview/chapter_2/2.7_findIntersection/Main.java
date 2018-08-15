/*

*/

import java.util.Random;

public class Main {
  static Random r = new Random();

  public static void main(String [] args) {
    Node list1 = generateList(10);
    Node list2 = generateList(5);
    list2.next = list1;
    outputList(list1);
    outputList(list2);
    Node intersection = BestSolution.findIntersection(list1, list2);
    if(intersection != null) {
      System.out.println(intersection.value);
    }
    else {
      System.out.println(intersection);
    }
    
    list1 = generateList(10);
    list2 = generateList(5);
    list1.next = list2;
    outputList(list1);
    outputList(list2);
    intersection = BestSolution.findIntersection(list1, list2);
    if(intersection != null) {
      System.out.println(intersection.value);
    }
    else {
      System.out.println(intersection);
    }
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
  public static Node findIntersection(Node h1, Node h2) {
    if(h1 == null || h2 == null) {
      return null;
    }
    Node ptr = h1;
    Node ptrTwo = h2;
    int size = 0;
    int size2 = 0;
    while(ptr != null && ptr.next != null) {
      size++;
      ptr = ptr.next;
    }

    while(ptrTwo != null && ptrTwo.next != null) {
      size2++;
      ptrTwo = ptrTwo.next;
    }

    if(ptr != ptrTwo) {
      return null;
    }

    int diff = Math.abs(size - size2);
    ptr = h1;
    ptrTwo = h2;
    int counter = 0;

    if(size < size2) {
      while(counter <  diff) {
        ptrTwo = ptrTwo.next;
        counter++;
      }
    }
    else {
      while(counter <  diff) {
        ptr = ptr.next;
        counter++;
      }
    }

    //Lists are now both the same length.
    while(ptr != null) {
      if(ptr == ptrTwo) {
        return ptr;
      }
      ptr = ptr.next;
      ptrTwo = ptrTwo.next;
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
