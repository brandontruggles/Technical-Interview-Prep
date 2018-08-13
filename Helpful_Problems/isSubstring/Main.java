
public class Main {
	public static void main(String [] args) {
    System.out.println(Solution.isSubstring("aa", "aaaa"));
    System.out.println(Solution.isSubstring("aabc", "aaabc"));
    System.out.println(Solution.isSubstring("aapple", "aaapplee"));
	}
}

class Solution {
/*
   //This was my first O(n) solution attempt, without doing research on substring search. This is a tricky problem, because the below seems like it would work in many test cases, but it in fact fails on certain edge cases such as finding "aabc" in "aaabc" or "aapple" in "aaapplee"

   public static boolean isSubstring(String s1, String s2) {
		int pointerIdx = 0;
		for(int i = 0; i < s2.length(); i++) {
			if(s2.charAt(i) == s1.charAt(pointerIdx)) {
				pointerIdx++;
				if(pointerIdx == s1.length()) {
					return true;
				}
			}
			else {
				pointerIdx = 0;
        if(s2.charAt(i) == s1.charAt(pointerIdx)) {
          pointerIdx++;
        }
			}
		}
		return false;
	}
*/

  //Naive solution in O(n*m) time complexity, where n and m are the lengths of the first and second strings, respectively. This is fairly slow, because you can actually implement this algorithm in O(n) time with a variety of methods.
/*  public static boolean isSubstring(String s1, String s2) {
    for(int i = 0; i < s2.length(); i++) {
      for(int j = 0; j < s1.length(); j++) {
        if(s2.charAt(i) != s1.charAt(j)) {
          break;
        }
        return true;
      }
    }
    return false;
  }*/

  //Karp-Rabin is an alternative algorithm with O(n) average time, but it requires a rolling hash function, and is still O(n*m) in the worst case. Good video on Karp-Rabin: https://www.youtube.com/watch?v=BRO7mVIFt08

  //KMP algorithm runs in O(n + m) time...this is my preferred algorithm if I had to implement this from scratch.
  public static boolean isSubstring(String s1, String s2) {
    int[] lps = new int[s1.length()];
    lps[0] = 0;
    int j = 0;
    //Preprocess s1 to create lps array.
    for(int i = 1; i < lps.length; i++) {
      if(s1.charAt(j) == s1.charAt(i)) {
        lps[i] = lps[i - 1] + 1;
        i++;
        j++;
      }
      else {
      
      }
    }

    return false;
  }
}


