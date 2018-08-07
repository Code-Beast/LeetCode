/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    if (nums1.length > nums2.length) {
        let temp = nums1;
        nums1 = nums2;
        nums2 = temp;
    }

    let m = nums1.length,  // m should be less than or equal to n
        n = nums2.length,
        minIdx = 0,
        maxIdx = m;

    while (minIdx <= maxIdx) {
        let i = Math.floor((minIdx + maxIdx) / 2),
            j = Math.floor((m + n + 1) / 2) - i;
        
        if (i > 0 && nums1[i - 1] > nums2[j]) {         // i > 0 => j < n
            maxIdx = i - 1;
        } else if (i < m && nums1[i] < nums2[j - 1]) {  // i < m => j > 0
            minIdx = i + 1;
        } else {
            if (i === 0) {
                maxLeft = nums2[j - 1];
            } else if (j === 0) {
                maxLeft = nums1[i - 1];
            } else {
                maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
            }

            if ((m + n) % 2) {
                return maxLeft;
            }

            if (i === m) {
                minRight = nums2[j];
            } else if (j === n) {
                minRight = nums1[i];
            } else {
                minRight = Math.min(nums1[i], nums2[j]);
            }
            
            return (maxLeft + minRight) / 2;
        }
    }
}

