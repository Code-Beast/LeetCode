import java.util.*;

// MY SOLUTION 1
// Runtime: 76ms

// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         // initialize the priority queue (the priority is how close arr[i] and x are)
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(a - x) == Math.abs(b - x) ? a - b : Math.abs(a - x) - Math.abs(b - x));
        
//         // start adding elements to pq
//         for (int i = 0; i < arr.length; i ++)
//             pq.add(arr[i]);
        
//         // add all elements left in pq to the res list
//         List<Integer> res = new ArrayList<>();
//         while (res.size() < k) 
//             res.add(pq.poll());
        
//         // sort the return list
//         Collections.sort(res);
        
//         return res;
//     }
// }



// MY SOLUTION 2
// Runtime: 34ms

// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         // initialize the priority queue (the priority is how close arr[i] and x are)
//         PriorityQueue<Integer> pq = new PriorityQueue<>(new CompareElements(x));
        
//         // start adding elements to pq
//         for (int i = 0; i < arr.length; i ++)
//             pq.add(arr[i]);
        
//         // add all elements left in pq to the res list
//         List<Integer> res = new ArrayList<>();
//         while (res.size() < k) 
//             res.add(pq.poll());
        
//         // sort the return list
//         Collections.sort(res);
        
//         return res;
//     }
    
//     // Difine the comparator class for priority queue
//     private class CompareElements implements Comparator<Integer> {
//         private int x;
        
//         public CompareElements(int x) {
//             this.x = x;
//         }
        
//         public int compare(Integer num1, Integer num2) {
//             int diff1 = Math.abs(num1 - x);
//             int diff2 = Math.abs(num2 - x);
//             return diff1 == diff2 ? num1 - num2 : diff1 - diff2;
//         }
//     }
// }



// MY SOLUTION 3
// Runtime: 9ms

// You cannot use Arrays.asList() to transform an int array to an Integer List, because Arrays.asList() only accept object array;
// You can not use Arrays.sort(arr, comparator) or Collections.sort(arr, comparator) on an int array, becuase they need an Object Array;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low, high;
        
        if (x <= arr[0]) {
            low = 0;
            high = k;
        } else if (x >= arr[arr.length - 1]) {
            low = arr.length - k;
            high = arr.length;
        } else {
            int idx = binarySearch(arr, x);
            low = idx;
            high = idx + 1;
            while (high - low <= k) {
                if (high == arr.length) {
                    low --;
                } else if (low == -1) {
                    high ++;
                } else if (arr[high] + arr[low] >= 2 * x) {
                    low --;
                } else {
                    high ++;
                }
            }
            low ++;
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = low; i < high; i ++) {
            res.add(arr[i]);
        }
        
        return res;
    }
    
    private int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == x) return mid;
            else if (arr[mid] < x) {
                low ++;
            } else {
                high --;
            }
        }
        System.out.print(low --);
        return low --;
    }
}
