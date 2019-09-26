// Solution 1
// Runtime: 1ms
public class Solution extends Reader4 {
    private char[] tmp = new char[4];
    private int tmpPtr = 0;
    private int tmpCnt = 0;
    
    public int read(char[] buf, int n) {
        int total = 0;
        
        while (total < n) {
            if (tmpPtr == 0) {
                tmpCnt = read4(tmp);
            }
            
            if (tmpCnt == 0) break;
            while (total < n && tmpPtr < tmpCnt) {
                buf[total ++] = tmp[tmpPtr ++];
            }
            
            if (tmpPtr == tmpCnt) tmpPtr = 0;
            if (tmpCnt < 4) break;
        }
        
        return total;
    }
}