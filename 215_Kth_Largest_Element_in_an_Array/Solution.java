// Author: Code-Beast

// // MY SOLUTION 1 (Sort)
// // Runtime: 4ms
// // Time Complexity: O(n*longn)
// // Space Complexity: O(1)
// import java.util.Arrays;

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         Arrays.sort(nums);
//         return nums[nums.length - k];
//     }

//     public static void main(String[] args) {
//     	System.out.println(new Solution().findKthLargest(new int[]{1, 3, 4, 2, 6, 3, 5, 8, 2}, 3));
//     }
// }



// // MY SOLUTION 2 (Heap Sort)
// // Runtime: 13ms
// // Time Complexity: O(n*longn)
// // Space Complexity: O(1)
// import java.util.PriorityQueue;

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for (int val : nums) {
//         	pq.add(val);
//         	if (pq.size() > k) {
//         		pq.poll();
//         	}
//         }

//         return pq.peek();
//     }

//     public static void main(String[] args) {
//     	System.out.println(new Solution().findKthLargest(new int[]{1, 3, 4, 2, 6, 3, 5, 8, 2}, 3));
//     }
// }



// // MY SOLUTION 3 (Quick Sort: Sort the whole array, then find the 4th to the end)
// // Runtime: 90s
// // Time Complexity: O(n*longn)
// // Space Complexity: O(1)
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         if (nums == null || nums.length < k) {
//             throw new IllegalArgumentException("Please provide enough numbers!");
//         } else if (k == 0) {
//             throw new IllegalArgumentException("k should be positive!");
//         }

//         quickSort(nums, 0, nums.length - 1);

//         return nums[nums.length - k];
//     }

//     private void quickSort(int[] nums, int start, int end) {
//         if (start >= end) {
//             return;
//         }

//         int pivot = nums[end];
//         int left = start;
//         int right = end - 1;

//         while (left < right) {
//             if (nums[left] > pivot && nums[right] <= pivot) {
//                 swap(nums, left, right);
//                 left ++;
//                 right --;
//                 continue;
//             } 

//             if (nums[left] <= pivot) {
//                 left ++;
//             }

//             if (nums[right] > pivot) {
//                 right --;
//             }
//         }

//         if (nums[left] <= pivot) {
//             swap(nums, left + 1, end);
//         } else {
//             swap(nums, left, end);
//         }

//         quickSort(nums, start, left);
//         quickSort(nums, left + 1, end);
//     }

//     private void swap(int[] nums, int pos1, int pos2) {
//         int temp = nums[pos1];
//         nums[pos1] = nums[pos2];
//         nums[pos2] = temp;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().findKthLargest(new int[]{3, 1, 2, 4}, 2));
//     }
// }



// MY SOLUTION 4 (Quick Sort)
// Runtime: 40ms
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            throw new IllegalArgumentException("Please provide enough numbers!");
        } else if (k == 0) {
            throw new IllegalArgumentException("k should be positive!");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int pos = partition(nums, left, right);
            if (pos == k - 1) break;
            else if (pos > k - 1) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }

        return nums[k - 1];
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int left = start;
        int right = end - 1;

        while (left <= right) {
            if (nums[left] <= pivot && nums[right] > pivot) {
                swap(nums, left, right);
                left ++;
                right --;
                continue;
            } 

            if (nums[left] > pivot) left ++;
            if (nums[right] <= pivot) right --;
        }

        swap(nums, left, end);
        return left;
    }

    private void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3, 1, 2, 4}, 2));
    }
}


