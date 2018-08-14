// Author: Code-Beast

// MY SOLUTION 2 (Using built-in stack)
import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> closeMap = new HashMap<>();
        closeMap.put('(', ')');
        closeMap.put('[', ']');
        closeMap.put('{', '}');

        Stack<Character> closeStack = new Stack<>();

        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (closeStack.size() > 0 && closeMap.containsKey(closeStack.peek()) && closeMap.get(closeStack.peek()) == ch){
                closeStack.pop();
            } else {
                closeStack.push(ch);
            }
        }
        return closeStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("([)]"));
    }
}



// // MY SOLUTION 1 (Using list as stack)
// import java.util.*;

// class Solution {
//     public boolean isValid(String s) {
//         Map<Character, Character> closeMap = new HashMap<>();
//         closeMap.put('(', ')');
//         closeMap.put('[', ']');
//         closeMap.put('{', '}');

//         List<Character> closeStack = new ArrayList<>();

//         for (int i = 0; i < s.length(); i ++) {
//             char ch = s.charAt(i);
//             if (closeStack.size() > 0 && closeMap.containsKey(closeStack.get(closeStack.size() - 1)) && closeMap.get(closeStack.get(closeStack.size() - 1)) == ch){
//                 closeStack.remove(closeStack.size() - 1);
//             } else {
//                 closeStack.add(ch);
//             }
//         }
//         return closeStack.isEmpty();
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().isValid("([)]"));
//     }
// }