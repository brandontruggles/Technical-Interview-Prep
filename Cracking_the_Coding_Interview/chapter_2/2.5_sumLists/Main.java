/*
  Solution is O(n+m) time complexity with O(c) space complexity, where c is the number of digits in the final sum.
 */

import java.util.Random;

public class Main {
  static Random r = new Random();

  public static void main(String [] args) {
    Node list1 = generateList(5);
    outputList(list1);
    Node list2 = generateList(5);
    outputList(list2);
    outputList(BestSolution.sumLists(list1, list2));
    Node list3 = generateList(3);
    outputList(list3);
    Node list4 = generateList(5);
    outputList(list4);
    outputList(BestSolution.sumLists(list3, list4));
    Node list5 = generateList(7);
    outputList(list5);
    Node list6 = generateList(5);
    outputList(list6);
    outputList(BestSolution.sumLists(list5, list6));
    Node list7 = generateList(1);
    outputList(list7);
    Node list8 = generateList(0);
    outputList(list8);
    outputList(BestSolution.sumLists(list7, list8));
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

  public static Node sumLists(Node h1, Node h2) {
    Node sumHead = null;
    Node sumPtr = null;
    int num1 = 0;
    int num2 = 0;
    Node pointer = h1;
    int base = 1;
    while(pointer != null) {
      num1 += pointer.value * base;
      base *= 10;
      pointer = pointer.next;
    }
    base = 1;
    pointer = h2;
    while(pointer != null) {
      num2 += pointer.value * base;
      base *= 10;
      pointer = pointer.next;
    }
    int sum = num1 + num2;
    String sumStr = "" + sum;
    for(int i = sumStr.length() - 1; i >= 0; i--) {
      if(sumHead == null) {
        sumHead = new Node(Character.getNumericValue(sumStr.charAt(i)));
        sumPtr = sumHead;
      }
      else {
        sumPtr.next = new Node(Character.getNumericValue(sumStr.charAt(i)));
        sumPtr = sumPtr.next;
      }
    }
    return sumHead;
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
