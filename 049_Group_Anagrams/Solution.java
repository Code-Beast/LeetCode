// Author: Code-Beast

// // MY SOLUTION 1 
// // Runtime: 26ms
// // Time Complexity: O(m * n * logn)
// // Space Complexity: O(n)
// import java.util.ArrayList;
// import java.util.List;
// import java.util.HashMap;
// import java.util.Arrays;

// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//     	List<List<String>> res = new ArrayList<>();

//         if (strs == null || strs.length == 0) {
//         	return res;
//         }

//         HashMap<String, Integer> map = new HashMap<>();

//         for (String str : strs) {
//         	char[] charArray = str.toCharArray();
//         	Arrays.sort(charArray);
//         	String orderedStr = new String(charArray);

//         	if (map.containsKey(orderedStr)) {
//         		List<String> list = res.get(map.get(orderedStr));
//         		list.add(str);
//         	} else {
//         		List<String> list = new ArrayList<>();
//         		map.put(orderedStr, res.size());
//         		list.add(str);
//         		res.add(list);
//         	}
//         }

//         return res;
//     }

//     public static void main(String[] args) {
//     	System.out.println(new Solution().groupAnagrams(new String[]{"ate", "eat", "tea", "ban", "anb", "sss"}));
//     }
// }



// MY SOLUTION 2 (Counting Sort) 
// Runtime: 30ms
// Time Complexity: O(m * n)
// Space Complexity: O(n)
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> res = new ArrayList<>();

        if (strs == null || strs.length == 0) {
        	return res;
        }

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
        	char[] charArray = str.toCharArray();
        	int[] count = new int[26];
        	String countStr = "";
        	
        	for (char ch : str.toCharArray()) {
        		count[ch - 'a'] ++;
        	}

        	for (int i = 0; i < count.length; i ++) {
        		if (count[i] != 0) {
        			countStr += String.valueOf(count[i]) + String.valueOf((char)(i + 'a'));
        		}
        	}

        	if (map.containsKey(countStr)) {
        		map.get(countStr).add(str);
        	} else {
        		List<String> list = new ArrayList<>();
        		list.add(str);
        		res.add(list);
        		map.put(countStr, list);
        	}
        }

        return res;
    }

    public static void main(String[] args) {
    	System.out.println(new Solution().groupAnagrams(new String[]{"ate", "eat", "tea", "ban", "anb", "sss"}));
    }
}