/*

*/

import java.util.Random;
import java.util.Stack;

public class Main {
  static Random r = new Random();

  public static void main(String [] args) {
    Node list1 = generateList("kayak");
    outputList(list1);
    System.out.println(BestSolution.isPalindrome(list1));
  }

  //Helper function to generate a linked list of a given word.
  public static Node generateList(String word) {
    Node head = null;
    Node curr = null;
    for(int i = 0; i < word.length(); i++) {
      if(i == 0) {
        head = new Node(word.charAt(i));
        curr = head;
      }
      else {
        curr.next = new Node(word.charAt(i));
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
  public static boolean isPalindrome(Node head) {
    if(head == null) {
      return true;
    }
    Stack<Character> charStack = new Stack<Character>();
    Node ptr = head;
    Node ptrTwo = head.next;
    while(ptrTwo != null && ptrTwo.next != null && ptrTwo.next.next != null) {
      charStack.push(ptr.value);
      ptr = ptr.next;
      ptrTwo = ptrTwo.next.next;
    }
    
    /*while(charStack.pop() == ptr.value) {
      
    }*/

    return true;
  }
}

//Node class which holds an integer value for simplicity.
class Node {
  public char value;
  public Node next;
  public Node(char val) {
    value = val;
  }
}
