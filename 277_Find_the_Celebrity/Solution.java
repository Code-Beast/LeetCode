/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        /**
         * 0 knows 1 => 0 is not (1 knows 0 => 1 is not; 1 not knows 0, 1 possible)
         * n knows n + 1 => n is not
         */
        
        boolean notCelebrity[] = new boolean[n];
        int i = 0;
        int j = 0;
        
        while (i < n - 1) {
            for (j = i + 1; j <= n - 1; j ++) {
                boolean iKj = knows(i, j);
                boolean jKi = knows(j, i);
                
                if (iKj && !jKi) {
                    i = j;
                    break;
                } else if (iKj && jKi || !iKj && !jKi) {
                    i = j + 1;
                    break;
                }
            }
            
            if (j == n) break;
        }
        
        if (i == n) return -1;
        
        for (j = 0; j < i; j ++) {
            boolean iKj = knows(i, j);
            boolean jKi = knows(j, i);
            
            if (!jKi || iKj) {
                return -1;
            }
        }
        
        return i;
    }
}
