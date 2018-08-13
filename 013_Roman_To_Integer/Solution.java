// Author: Code-Beast

// MY SOLUTION 2
class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return -1;
        
        Map<Character, Integer> valueMap = new HashMap<>();
        valueMap.put('M', 1000);
        valueMap.put('D', 500);
        valueMap.put('C', 100);
        valueMap.put('L', 50);
        valueMap.put('X', 10);
        valueMap.put('V', 5);
        valueMap.put('I', 1);
        int sum = 0;    
        for(int i = s.length() - 1; i >= 0; i --) {
            int ch = valueMap.get(s.charAt(i));
            int nextCh = (i == 0 ? 0 : valueMap.get(s.charAt(i - 1)));
            if (ch > nextCh) {
                sum += (ch - nextCh);
                i --;
            } else {
                sum += ch;
            }
        }
        return sum;
    }
}



// // MY SOLUTION 1
// class Solution {
//     public int romanToInt(String s) {
//         if (s == null || s.length() == 0) return -1;
        
//         Map<Character, Integer> valueMap = new HashMap<>();
//         valueMap.put('M', 1000);
//         valueMap.put('D', 500);
//         valueMap.put('C', 100);
//         valueMap.put('L', 50);
//         valueMap.put('X', 10);
//         valueMap.put('V', 5);
//         valueMap.put('I', 1);

//         int sum = valueMap.get(s.charAt(s.length() - 1));    
//         for(int i = s.length() - 2; i >= 0; i --) {
//             int ch = valueMap.get(s.charAt(i));
//             int nextCh = valueMap.get(s.charAt(i + 1));
//             if (ch >= nextCh) {
//                 sum += ch;
//             } else {
//                 sum -= ch;
//             }
//         }
//         return sum;
//     }
// }