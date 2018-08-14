// Author: Code-Beast

// A Better Solution Using Recursion Cited From:
// https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max * 2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if(close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }
}



// // MY SOLUTION 1 (Recursion)
// class Solution {
//     public List<String> generateParenthesis(int n) {

//         if (n == 0) return new ArrayList<String>();

//         return addParenthesis("", n, n);
//     }
    
//     private List<String> addParenthesis(String prev, int numToOpen, int numToClose) {
//         List<String> res = new ArrayList<>();
//         if (numToOpen == 0) {
//             for (int i = 0; i < numToClose; i ++) {
//                 prev += ')';
//             }
//             res.add(prev);
//         } else if (numToClose != 0 && numToOpen <= numToClose){
//             List<String> comb1 = addParenthesis(prev + '(', numToOpen - 1, numToClose),
//                          comb2 = addParenthesis(prev + ')', numToOpen, numToClose - 1);
//             res.addAll(comb1);
//             res.addAll(comb2);
//         }
//         return res;
//     }
// }