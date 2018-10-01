// Author: Code-Beast

// // MY SOLUTION 1 (Greedy)
// // Runtime: 10ms
// class Solution {
//     public int jump(int[] nums) {
//         if (nums == null || nums.length == 0) {
//         	return 0;
//         }

//         int res = 0;
//         int currMaxArea = 0; 
//         int maxNextStep = 0;

//         for (int i = 0; i < nums.length - 1; i ++) {
//         	maxNextStep = Math.max(maxNextStep, i + nums[i]);
//         	if (i == currMaxArea) {	// Reach the last position that can be jumped to at the last step, so we need to jump again
//         		res ++;
//         		currMaxArea = maxNextStep;

//         		if (currMaxArea >= nums.length - 1) {
//         			break;
//         		}
//         	}
//         }

//         return res;
//     }

//     public static void main(String[] args) {
//     	System.out.println(new Solution().jump(new int[]{2, 3, 1, 1, 4}));
//     }
// }



// MY SOLUTION 2 (Greedy)
// Runtime: 8ms
class Solution {
    public int jump(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}

        int level = 0;
        int currMaxArea = 0;
        int maxNextStep = 0;
        int currPos = 0;

        while (currMaxArea < nums.length - 1) {
        	for (; currPos <= currMaxArea; currPos ++) {
        		maxNextStep = Math.max(maxNextStep, currPos + nums[currPos]);

	        	if (maxNextStep >= nums.length - 1) {
	        		return level + 1;
	        	}
        	}

        	currMaxArea = maxNextStep;
        	level ++;
        }

        return level;
    }

    public static void main(String[] args) {
    	System.out.println(new Solution().jump(new int[]{2, 3, 1, 1, 4}));
    }
}