/*First approach:
  -Loop through each character and increment a counter corresponding to that char in a HashMap
  -If a counter goes above 1, return false. Else, return true.

  Time complexity: O(n) Space Complexity: O(n)

  Better approach if char[] is passed:
  -Sort the chars in the array and check for duplicates.

  Time complexity: O(n) Space Complexity: O(1)

  Best approach if the String is only composed of letters in the English alphabet:
  Use a bit vector stored in an int to toggle bits when a particular char is encountered. If the bit in the vector at that position is already set, a duplicate was encountered, and we can return false.

  Time complexity: O(n) Space Complexity: O(1)

*/

import java.util.HashMap;

public class Main {
	public static void main(String [] args) {
		System.out.println(FirstSolution.isUnique("abcd"));
		System.out.println(FirstSolution.isUnique("abbcd"));
		System.out.println(FirstSolution.isUnique("bbbcad"));
		System.out.println(BestSolution.isUnique("abcd"));
		System.out.println(BestSolution.isUnique("abcdd"));
	}
}

class FirstSolution {
	public static boolean isUnique(String s) {
		s = s.toLowerCase();
		HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
		for(char c: s.toCharArray()) {
			if(countMap.get(c) == null) {
				countMap.put(c, 1);
			}
			else {
				return false;
			}
		}
		return true;
	}
}

class BestSolution {
	public static boolean isUnique(String s) {
		s = s.toLowerCase();
		int bitVector = 0;
		for(char c: s.toCharArray()) {
			int bitValue = 1 << (c - 97);
			if((bitValue & bitVector) != 0) {
				return false;
			}
			bitVector |= bitValue; 
		}
		return true;
	}
}
