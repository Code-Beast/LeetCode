// Author: Code-Beast

// MY SOLUTION 1 (Recursion)
// Rumtime: 2ms
class Solution {
    public String countAndSay(int n) {
    	String res = "1";
        for (int i = 2; i <= n; i ++) {
        	res = countAndSayHelper(res);
        }

        return res;
    }

    public String countAndSayHelper(String lastSay) {
    	char lastNum = lastSay.charAt(0);
    	int count = 0;
    	StringBuilder say = new StringBuilder();

    	int i = 0;
    	while (i < lastSay.length()) {
    		if (lastSay.charAt(i) == lastNum) {
    			count ++;
    		} else {
    			say.append(count);
    			say.append(lastNum);
    			count = 1;
    			lastNum = lastSay.charAt(i);
    		}

    		i ++;
    	}

		say.append(count);
		say.append(lastNum);

    	return say.toString();
    }
}