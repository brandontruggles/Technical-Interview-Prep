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
    Node list2 = generateList("anna");
    outputList(list2);
    System.out.println(BestSolution.isPalindrome(list2));
    Node list3 = generateList("apple");
    outputList(list3);
    System.out.println(BestSolution.isPalindrome(list3));
    Node list4 = generateList("a");
    outputList(list4);
    System.out.println(BestSolution.isPalindrome(list4));
    Node list5 = generateList("ap");
    outputList(list5);
    System.out.println(BestSolution.isPalindrome(list5));
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
    while(ptrTwo != null && ptrTwo.next != null) {
      charStack.push(ptr.value);
      ptr = ptr.next;
      ptrTwo = ptrTwo.next.next;
    }
   
    charStack.push(ptr.value);
    if(ptrTwo != null) { //This will only happen in even-length lists.
      ptr = ptr.next;
    }

    
    while(charStack.size() > 0 && ptr != null) {
      char val = charStack.pop();
      if(val != ptr.value) {
        return false;
      }
      ptr = ptr.next;
    }

    if(charStack.size() > 0) {
      return false;
    }

    return true;
  }
}

//Node class which holds a char value for simplicity.
class Node {
  public char value;
  public Node next;
  public Node(char val) {
    value = val;
  }
}
