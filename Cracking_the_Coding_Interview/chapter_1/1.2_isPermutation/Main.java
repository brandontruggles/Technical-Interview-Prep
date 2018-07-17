/*

*/

import java.util.HashMap;

public class Main {
	public static void main(String [] args) {
		System.out.println(BestSolution.isPermutation("tacocat", "bear"));
		System.out.println(BestSolution.isPermutation("taco", "cato"));
		System.out.println(BestSolution.isPermutation("kayak", "yakka"));
		System.out.println(BestSolution.isPermutation("cat", "ta"));
	}
}

class BestSolution {
	public static boolean isPermutation(String a, String b) {
		if(a.length() != b.length()) {
			return false;
		}
		HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
		for(char c: a.toCharArray()) {
			if(countMap.get(c) == null) {
				countMap.put(c, 1);
			}
			else {
				countMap.put(c, countMap.get(c) + 1);
			}
		}
		for(char c: b.toCharArray()) {
			if(countMap.get(c) == null) {
				return false;
			}
			else {
				countMap.put(c, countMap.get(c) - 1);
				if(countMap.get(c) < 0) {
					return false;
				}
			}
		}
		return true;
	}
}
