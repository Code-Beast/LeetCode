// Solution 1
// Runtime: 0ms
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        if (n == 0) {
            return 0;
        }
        
        int realNum = 0;
        int readNum = 4;
        char[] temp = new char[4];
        
        while (readNum == 4 && realNum < n) {
            readNum = read4(temp);
            
            for (int i = 0; i < readNum; i ++) {
                buf[realNum + i] = temp[i];
            }
            
            realNum += readNum;
        }
        
        return realNum >= n ? n : realNum;
    }
}