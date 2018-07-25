/*

*/

public class Main {
	public static void main(String [] args) {
		System.out.println(BestSolution.isOneAway("b", "ba"));
		System.out.println(BestSolution.isOneAway("ba", "b"));
		System.out.println(BestSolution.isOneAway("bbbbbba", "bbbbba"));
		System.out.println(BestSolution.isOneAway("bbbbbba", "bbbbbb"));
		System.out.println(BestSolution.isOneAway("bbbbbba", "bbbbbbb"));
		System.out.println(BestSolution.isOneAway("bbba", "bbbbbbb"));
		System.out.println(BestSolution.isOneAway("", "bbbbbbb"));
	}
}

class BestSolution {
	public static boolean isOneAway(String first, String second) {
		int lengthDiff = Math.abs(first.length() - second.length());
		if(lengthDiff > 1) {
			return false;
		}
		int idxOne = 0;
		int idxTwo = 0;
		String shorterStr = "";
		String longerStr = "";
		if(first.length() < second.length()) {
			shorterStr = first;
			longerStr = second;
		}
		else {
			shorterStr = second;
			longerStr = first;
		}
		int diffCount = 0;
		for(idxOne = 0; idxOne < longerStr.length(); idxOne++) {
			if(longerStr.charAt(idxOne) != shorterStr.charAt(idxTwo)) {
				diffCount++;
				idxOne++;
				if(diffCount > 1) {
					return false;
				}
				else {
					idxTwo++;
				}
			}
		}
		return true;
	}
}
