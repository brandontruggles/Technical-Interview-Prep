//Function to output all numbers with a specific number of digits in a particular base, up to base 10
//Inspired by the following video on backtracking: https://www.youtube.com/watch?v=HvGkzDT2ffI
//Solution runtime is O() and space complexity is O() (Due to StringBuilder).
public class Main {
	public static void main(String [] args) {
    Solution.printNumbersWithBase(2, 5);
    Solution.printNumbersWithBase(10, 5);
	}
}

class Solution {
  public static void printNumbersWithBase(int base, int numDigits) {
    StringBuilder output = new StringBuilder(); //Using a string builder will allow us to store each string in constant time, each with O(numDigits) space. Useful for if we were doing more than just printing out each string.
    pnwbHelper(base, numDigits, output);
  }

  public static void pnwbHelper(int base, int numDigits, StringBuilder prefix) { //Helper function to do our actual recursion.
    if(numDigits == 0) {
      System.out.println(prefix.toString());
    }
    else {
      for(int i= 0 ; i < base; i++) {
        pnwbHelper(base, numDigits - 1, prefix.append(Character.forDigit(i, 10)));
        prefix.deleteCharAt(prefix.length() - 1); //Undo our append for the next loop iteration.
      }
    }
  }
}
