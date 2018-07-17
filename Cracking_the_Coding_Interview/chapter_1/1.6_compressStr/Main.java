/*

*/

public class Main {
	public static void main(String [] args) {
		System.out.println(BestSolution.compressStr("aaabbbbbc"));
		System.out.println(BestSolution.compressStr("dddkkm"));
		System.out.println(BestSolution.compressStr("zzzz"));
		System.out.println(BestSolution.compressStr("a"));
		System.out.println(BestSolution.compressStr(""));
	}
}

class BestSolution {
	public static String compressStr(String input) {
		StringBuilder builder = new StringBuilder();
		char lastChar = 0;
		int charCount = 1;
		for(char c: input.toCharArray()) {
			if(c != lastChar) {
				if(lastChar != 0) {
					builder.append(lastChar);
					builder.append((Character.forDigit(charCount, 10)));
					lastChar = c;
					charCount++;
				}
				else {
					lastChar = c;
					charCount++;
				}
			}
			if(charCount > 1) {
				builder.append(lastChar);
				builder.append(Character.forDigit(charCount, 10));
			}
			String newStr = builder.toString();
			if(newStr.length() < input.length()) {
				return newStr;
			}
		}
		return input;
	}
}
