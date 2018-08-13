/*
  Innef
*/

public class Main {
	public static void main(String [] args) {
		System.out.println(BestSolution.isRotation("apple", "pleap"));
		System.out.println(BestSolution.isRotation("ape", "pleap"));
		System.out.println(BestSolution.isRotation("kangaroo", "ooragnak"));
		System.out.println(BestSolution.isRotation("kangaroo", "arookang"));
	}
}

class BestSolution {
	public static boolean isRotation(String s1, String s2) {
		if(s1.length() == s2.length() && s1 != null && s2 != null) {
			String s1s1 = s1 + s1;
			if(isSubstring(s2, s1s1)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isSubstring(String s1, String s2) { //Using KMP algorithm for O(n) runtime, see isSubstring under Helpful_Problems for more info
    
	}
}
