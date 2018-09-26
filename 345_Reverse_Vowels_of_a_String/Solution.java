// Author: Code-Beast

// // MY SOLUTION 1 (Using Double Pointers and Using String as Container)
// // Runtime: 6ms
// class Solution {
//     public String reverseVowels(String s) {
//     	String vowels = "aeouiAEOUI";
//         int left = 0, right = s.length() - 1;
//         char[] result = new char[s.length()];

//         while (left <= right) {
//         	char leftChar = s.charAt(left), rightChar = s.charAt(right);
//         	boolean leftVowel = vowels.indexOf(leftChar) != -1, rightVowel = vowels.indexOf(rightChar) != -1;

//         	if (leftVowel && rightVowel) {
//         		result[left] = rightChar;
//         		result[right] = leftChar;
//         		left ++;
//         		right --;
//         	}

//         	if (!leftVowel) {
//         		result[left] = leftChar;
//         		left ++;
//         	}

//         	if (!rightVowel) {
//         		result[right] = rightChar;
//         		right --;
//         	}
//         }

//         return new String(result);
//     }

//     public static void main(String[] args) {
//     	System.out.println(new Solution().reverseVowels("hello"));
//     	System.out.println(new Solution().reverseVowels("aA"));
//     }
// }



// // MY SOLUTION 2 (Using Double Pointers and Using Hashset as Container)
// // Runtime: 11ms
// import java.util.HashSet;
// import java.util.Arrays;

// class Solution {
//     public String reverseVowels(String s) {
//     	HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'o', 'u', 'i', 'A', 'E', 'O', 'U', 'I'));
//         int left = 0, right = s.length() - 1;
//         char[] result = new char[s.length()];

//         while (left <= right) {
//         	char leftChar = s.charAt(left), rightChar = s.charAt(right);
//         	boolean leftVowel = vowels.contains(leftChar), rightVowel = vowels.contains(rightChar);

//         	if (leftVowel && rightVowel) {
//         		result[left] = rightChar;
//         		result[right] = leftChar;
//         		left ++;
//         		right --;
//         	}

//         	if (!leftVowel) {
//         		result[left] = leftChar;
//         		left ++;
//         	}

//         	if (!rightVowel) {
//         		result[right] = rightChar;
//         		right --;
//         	}
//         }

//         return new String(result);
//     }

//     public static void main(String[] args) {
//     	System.out.println(new Solution().reverseVowels("hello"));
//     	System.out.println(new Solution().reverseVowels("aA"));
//     }
// }



// MY SOLUTION 3 (Refactored Solution 1)
// Runtime: 4ms
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public String reverseVowels(String s) {
    	String vowels = "aeouiAEOUI";
        int left = 0, right = s.length() - 1;
        char[] result = new char[s.length()];

        while (left <= right) {
        	char leftChar = s.charAt(left), rightChar = s.charAt(right);

        	if (vowels.indexOf(leftChar) == -1) {
        		result[left ++] = leftChar;
        	} else if (vowels.indexOf(rightChar) == -1) {
        		result[right --] = rightChar;
        	} else {
        		result[left ++] = rightChar;
        		result[right --] = leftChar;
        	}
        }

        return new String(result);
    }

    public static void main(String[] args) {
    	System.out.println(new Solution().reverseVowels("hello"));
    	System.out.println(new Solution().reverseVowels("aA"));
    }
}
