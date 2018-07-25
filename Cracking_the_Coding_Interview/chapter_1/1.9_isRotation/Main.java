/*

*/

public class Main {
	public static void main(String [] args) {
		System.out.println(BestSolution.isRotation("apple", "pleap"));
		System.out.println(BestSolution.isRotation("ape", "pleap"));
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

	public static boolean isSubstring(String s1, String s2) {
		int pointerIdx = 0;
		for(int i = 0; i < s2.length(); i++) {
			if(s2.charAt(i) == s1.charAt(pointerIdx)) {
				pointerIdx++;
				if(pointerIdx == s1.length() - 1) {
					return true;
				}
			}
			else {
				pointerIdx = 0;
			}
		}
		return false;
	}
}
