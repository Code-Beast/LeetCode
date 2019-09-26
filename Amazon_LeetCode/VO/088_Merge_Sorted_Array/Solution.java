/*
  Because m is not actually equal to nums.length; instead, we should assume that nums1.length >= m + n and we are told to use nums1 to contain the final sorted array.
  If we started from 0, we would have to move all elements after the current index in nums1 so that the rest numbers of nums1 would not be messed up.
  Thus, instead, we start from the end of the array, so any time idx > idx1 and it all works out!
*/

/*
  If m >> n, 应该用二分找到nums2里的每个元素在新array里的位置，然后再统一把两个array合并到一个新的array里面。
  也就是说，确定nums2里每个元素的位置，存起来，然后把nums1里的元素布满除这些位置以外的位置，然后再把这几个元素插进去。不先把nums2里的元素复制进去是为了不覆盖掉nums1里的元素。
  这样的好处是，我们只会用到m+n次memory复制和O(nlogm)次比较，而不是m+n次memory复制和O(m+n)次比较。最适用于比较的元素不是int而是更复杂的数据结构比如一个有自定义Comparator的Object。
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // corner cases: null, len = 0
        if (m == 0) {
            for (int i = 0; i < n; i ++) {
                nums1[i] = nums2[i];
            }
        }
        
        int idx = m + n - 1, idx1 = m - 1, idx2 = n - 1;
        
        while (idx1 >= 0 && idx2 >= 0) {
            if (nums1[idx1] >= nums2[idx2]) {
                nums1[idx --] = nums1[idx1 --];
            } else {
                nums1[idx --] = nums2[idx2 --];
            }
        }
        
        if (idx1 == -1) {
            while (idx2 >= 0) {
                nums1[idx --] = nums2[idx2 --];
            }
        } else {
            while (idx1 >= 0) {
                nums1[idx --] = nums1[idx1 --];
            }
        }
    }
}
