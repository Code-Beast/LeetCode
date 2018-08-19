// Author: Code-Beast

// // MY SOLUTION 1 (Backtracking || DFS || Recursion)
// // Runtime: 25ms
// class Solution {
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         List<List<Integer>> combs = new ArrayList<>();
//         Arrays.sort(candidates);
//         backtrack(combs, new ArrayList<>(), target, candidates, 0);
//         return combs;
//     }

//     private void backtrack(List<List<Integer>> combs, List<Integer> attempt, int target, int[] candidates, int start) {
//         if (target == 0) {
//             combs.add(new ArrayList<>(attempt));
//         } else if (target > 0) {
//             for (int i = start; i < candidates.length; i ++) {
//                 if (i > start && candidates[i] == candidates[i - 1]) { 
//                     continue;
//                 } else {
//                     attempt.add(candidates[i]);
//                     backtrack(combs, attempt, target - candidates[i], candidates, i + 1);
//                     attempt.remove(attempt.size() - 1);
//                 }
//             }   
//         }
        
//         return;
//     }
// }



// // MY SOLUTION 2 (Recursion)
// // Note: without the largest candidate or with the largest candidate
// // Runtime: 15ms
// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> combs = new ArrayList<>();
//         Arrays.sort(candidates);
//         combinationSumHelper(combs, new ArrayList<>(), target, candidates, candidates.length - 1);
//         return combs;
//     }

//     private void combinationSumHelper(List<List<Integer>> combs, List<Integer> attempt, int target, int[] candidates, int end) {
//         if (target == 0) {
//             combs.add(new ArrayList<>(attempt));
//         } else if (target > 0) {
//             if (end < 0 || end == 0 && target % candidates[end] != 0) {
//                 return;
//             } else {
//                 if (end == candidates.length - 1 || end < candidates.length - 1 && candidates[end] == candidates[end + 1]) {
//                     attempt.add(candidates[end]);
//                     combinationSumHelper(combs, attempt, target - candidates[end], candidates, end - 1);
//                     attempt.remove(attempt.size() - 1);
//                 }
//                 combinationSumHelper(combs, attempt, target, candidates, end - 1);
//             }
//         }
//         return;
//     }
// }



// A SOLUTION BASED ON (Dynamic Programming) FROM 
// https://leetcode.com/problems/combination-sum/discuss/16509/Iterative-Java-DP-solution
// Runtime: 80ms
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // dp records combinations for numbers from 1 to target
        List<List<List<Integer>>> dp = new ArrayList<>();
        Arrays.sort(candidates);

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < candidates.length; i ++) {
            countMap.put(candidates[i], countMap.getOrDefault(candidates[i], 0) + 1);
        }

        for (int sum = 1; sum <= target; sum ++) {
            List<List<Integer>> currCombs = new ArrayList();
            // Only candidates less than or equal to sum can be used
            for (int i = 0; i < candidates.length && candidates[i] <= sum; i ++) {
                if (sum == candidates[i]) {
                    currCombs.add(Arrays.asList(candidates[i]));
                } else {
                    for (List<Integer> comb : dp.get(sum - candidates[i] - 1)) {
                        // if candidates[i] is larger than the first element of a combination in the combs of (target - candidates[i])
                        // because we know that element has already been used as a candidate, we omit that combination.
                        if (candidates[i] < comb.get(0)) {
                            // Eastablish the current combination
                            List<Integer> currComb = new ArrayList<>();
                            currComb.add(candidates[i]); 
                            currComb.addAll(comb);

                            // Add this combination to the combinations list of sum
                            currCombs.add(currComb);
                        } else if (candidates[i] == comb.get(0)) {
                            int countComb = 0,
                                j = 0;

                            while (j < comb.size()) {
                                if (comb.get(j) != candidates[i]) {
                                    break;
                                }
                                j ++;
                            }

                            if (j >= countMap.get(candidates[i])) {
                                continue;
                            }

                            // Eastablish the current combination
                            List<Integer> currComb = new ArrayList<>();
                            currComb.add(candidates[i]); 
                            currComb.addAll(comb);

                            // Add this combination to the combinations list of sum
                            currCombs.add(currComb);
                        }
                    }
                }
            }
            dp.add(currCombs);
        }
        return new ArrayList<List<Integer>>(new HashSet<List<Integer>>(dp.get(target - 1)));
    }
}