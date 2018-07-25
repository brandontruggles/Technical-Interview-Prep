/*
	See "generatePermutations" under Helpful_Problems for the naive solution to this.
*/

import java.util.HashMap;

public class Main {
	public static void main(String [] args) {
		System.out.println(FirstSolution.isPalindromePerm("kayak"));
		System.out.println(FirstSolution.isPalindromePerm("kaaky"));
		System.out.println(FirstSolution.isPalindromePerm("kaya"));
		System.out.println(FirstSolution.isPalindromePerm("k"));
		System.out.println(FirstSolution.isPalindromePerm("bob"));
		System.out.println(FirstSolution.isPalindromePerm("bo"));
		System.out.println(BestSolution.isPalindromePerm("kayak"));
		System.out.println(BestSolution.isPalindromePerm("kaaky"));
		System.out.println(BestSolution.isPalindromePerm("kaya"));
		System.out.println(BestSolution.isPalindromePerm("k"));
		System.out.println(BestSolution.isPalindromePerm("bob"));
		System.out.println(BestSolution.isPalindromePerm("bo"));
	}
}

class FirstSolution {
	public static boolean isPalindromePerm(String s) {
		s = s.toLowerCase();
		HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();

		for(char c: s.toCharArray()) {
			if(countMap.get(c) == null) {
				countMap.put(c, 1);
			}
			else {
				countMap.put(c, countMap.get(c) +  1);
			}
		}
		int oddCount = 0;
		for(int i: countMap.values()) {
			if(i % 2 == 1) {
				oddCount++;
			}
		}
		return (oddCount < 2);
	}
}
class BestSolution {

	public static boolean isPalindromePerm(String s) {
		s = s.toLowerCase();
		int bitVector = 0;
		for(char c: s.toCharArray()) {
			int mask = 1 << (c - 97);
			bitVector ^= mask;
		}
		int oddCount = 0;
		for(int i = 0; i < 32; i++) {
			if((bitVector & (1 << i)) == (1 << i)) {
				oddCount++;
			}
		}
		if(oddCount > 1) {
			return false;
		}
		return true;
	}
}
