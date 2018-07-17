/*

*/



public class Main {
	public static void main(String [] args) {
		char[] inputArr = new char[] {'a', 'p', 'p', 'l', 'e', ' ', 'p', 'i', 'e', 0, 0, 0, 0 };
		char[] inputArr2 = new char[] {'a', 'p', ' ', 'p', 'l', 'e', ' ', 'p', 'i', ' ', 'e', 0, 0, 0 , 0, 0, 0};
		System.out.println(new String(BestSolution.URLify(inputArr, 9)));
		System.out.println(new String(BestSolution.URLify(inputArr2, 11)));
	}
}

class BestSolution {
	public static char[] URLify(char[] input, int length) {
		int spaceCount = countSpaces(input);

		for(int i = length - 1; i >=0; i--) {
			if(input[i] != ' ') {
				int finalSpot = 2 * spaceCount + i;
				input[finalSpot] = input[i];
			}
			else {
				spaceCount--;
				int finalSpot = 2 * spaceCount +  i;
				input[finalSpot] = '%';
				input[finalSpot +  1] = '2';
				input[finalSpot + 2] = '0';
			}
		}
		return input;
	}

	public static int countSpaces(char[] input) {
		int count = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] == ' ') {
				count++;
			}
		}
		return count;
	}
}
