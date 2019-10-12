/*
  Given array of statue heights, and an array of cave heights, 
  find max number of statues that can fit in the cave.
  You can only insert into the cave from the opening (which is at index 0), and slide as necessary.

  For example,
  statues = [1,2,3]
  cave = [2,1,1]

  Answer: 2 because statue of height 1 can slide all the way to the back of the cave, and statue of height 2 can slide into the opening of the cave.

  Another example,
  statues = [5]
  cave = [1,20,20]

  Answer: 0 because the statue of height 5 cannot get past the opening of the cave (which is height 1).
*/

import java.util.Arrays;
import java.util.Stack;

class Solution {
  public int fitStatues1(int[] statues, int[] cave) {
    Arrays.sort(statues);
    int count = 0;
    int block = cave.length;

    for (int statue : statues) {
      if (statue > cave[0] || block == 0) {
        continue;
      }

      count ++;
      int prevBlock = block;

      for (int i = 0; i < block - 1; i ++) {
        if (statue > cave[i + 1]) {
          block = i;
          break;
        }
      }

      if (block == prevBlock) {
        block --;
      }
    }

    return count;
  }

  public int fitStatues2(int[] statues, int[] cave) {
    Arrays.sort(statues);

    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    for (int height : cave) {
      min = Math.min(min, height);
      stack.push(min);
    }

    int i = 0;
    int count = 0;
    while (i < statues.length) {
      if (stack.isEmpty()) {
        break;
      }

      if (statues[i] <= stack.peek()) {
        count ++;
        i ++;
      }

      stack.pop();
    }

    return count;
  }

  public int fitStatues3(int[] statues, int[] cave) {
    Arrays.sort(statues);
    int count = 0;
    int block = cave.length;

    for (int i = 1; i < cave.length; i ++) {
      cave[i] = Math.min(cave[i], cave[i - 1]);
    }

    for (int statue : statues) {
      if (statue > cave[0] || block == 0) {
        continue;
      }

      count ++;

      int lo = 0;
      int hi = block - 1;

      while (lo < hi) {
        int mid = lo + (hi - lo) / 2;

        if (cave[mid] < statue) {
          hi = mid;
        } else {
          lo = mid + 1;
        }
      }

      block = cave[lo] < statue ? lo - 1 : lo;
    }

    return count;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(sol.fitStatues1(new int[]{1, 2, 3}, new int[]{2, 1, 1}));
    System.out.println(sol.fitStatues1(new int[]{5}, new int[]{1, 20, 20}));
    System.out.println(sol.fitStatues1(new int[]{5, 4, 3, 2, 1}, new int[]{5, 4, 3, 2, 1}));
    System.out.println(sol.fitStatues1(new int[]{5, 4, 3, 1}, new int[]{5, 3, 2, 1}));

    System.out.println(sol.fitStatues2(new int[]{1, 2, 3}, new int[]{2, 1, 1}));
    System.out.println(sol.fitStatues2(new int[]{5}, new int[]{1, 20, 20}));
    System.out.println(sol.fitStatues2(new int[]{5, 4, 3, 2, 1}, new int[]{5, 4, 3, 2, 1}));
    System.out.println(sol.fitStatues2(new int[]{5, 4, 3, 1}, new int[]{5, 3, 2, 1}));

    System.out.println(sol.fitStatues3(new int[]{1, 2, 3}, new int[]{2, 1, 1}));
    System.out.println(sol.fitStatues3(new int[]{5}, new int[]{1, 20, 20}));
    System.out.println(sol.fitStatues3(new int[]{5, 4, 3, 2, 1}, new int[]{5, 4, 3, 2, 1}));
    System.out.println(sol.fitStatues3(new int[]{5, 4, 3, 1}, new int[]{5, 3, 2, 1}));
  }
}