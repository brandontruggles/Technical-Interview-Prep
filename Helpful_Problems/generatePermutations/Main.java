import java.util.HashMap;

public class Main {
	public static void main(String [] args) {
		char[] test = {'a', 'p', 'p', 'l', 'e'};
    System.out.println("Generate permutations:");
		Solution.generatePermutations(test, 0, test.length - 1);
    System.out.println("Generate permutations without duplicates:");
    HashMap<String, Integer> dupeMap = new HashMap<String, Integer>();
		Solution.generatePermsNoDuplicates(test, 0, test.length - 1, dupeMap);
	}
}

class Solution {
  public static void generatePermsNoDuplicates(char[] input, int start, int end) {

  }

  public static void gpndHelper(char[] input, int start, int end, HashMap<String, Integer> dupeMap) {

  }

	public static void generatePermutations(char[] input, int start, int end) {
    if(start == end) {
        outputString(input); //
    }
    else {
      for(int i = start; i <= end; i++) {
        swap(input, start, i); //Swap each character to the start
        generatePermutations(input, start+1, end); //Generate all permutations of the remaining characters
        swap(input, start, i); //Undo our swap to return the char[] to normal.
      }
    }
	}

	public static void swap(char[] input, int i, int j) {
		char tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}

	public static void outputString(char[] input) {
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
		}
		System.out.println();
	}
}
