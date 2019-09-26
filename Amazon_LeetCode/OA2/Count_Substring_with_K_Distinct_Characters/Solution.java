import java.util.*;

public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().countkDistinct("aabbccabbcca", 3));
	}

	private static int countkDistinct(String inputString, int num){
	    Map<Character,Integer> charToNum;
		int count = 0;

		for(int i = 0; i < inputString.length(); i++){
		    charToNum = new HashMap<>();
		    for(int j = i; j < inputString.length(); j++){
		        char c = inputString.charAt(j);
		        charToNum.put(c, charToNum.getOrDefault(c, 0) + 1);
				if (charToNum.keySet().size() == num) {
					count ++;
				}
			}
		}
	    return count;
	}
}