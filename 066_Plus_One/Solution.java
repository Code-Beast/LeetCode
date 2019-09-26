// Solution 1
// Run Time: 0ms
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = len - 1;
        
        for (; i >= 0; i --) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] ++;
                break;
            }
        }
        
        if (i == -1 && digits[0] == 0) {
            int[] res = new int[len + 1];
            res[0] = 1;
            
            System.arraycopy(digits, 0, res, 1, len);
            return res;
        } else {
            return digits;
        }
    }
}
