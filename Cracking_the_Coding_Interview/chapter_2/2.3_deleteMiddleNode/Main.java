/*
  This solution takes O(n) time complexity and O(1) space complexity. Note that this would only work for a node that is not the first or last in the list, as it requires both a node before and after the one to remove.
*/

import java.util.Random;

public class Main {
  static Random r = new Random();

	public static void main(String [] args) {
    Node list1 = generateList(10);
    outputList(list1);
    Node removalNode = list1.next.next.next;
    BestSolution.deleteMiddleNode(list1, removalNode);
    outputList(list1);
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
  public static void deleteMiddleNode(Node head, Node node) {
   if(node != null) {
     Node pointer = head;
     while(pointer.next != node) {
        pointer = pointer.next;
     }
     pointer.next = node.next;
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
