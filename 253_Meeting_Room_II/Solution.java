class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        
        if (n == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> allocator = new PriorityQueue<>(n, (a, b) -> a - b);
        allocator.add(intervals[0][1]);
        
        for (int i = 1; i < n; i ++) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
        
            allocator.add(intervals[i][1]);
        }
    
        return allocator.size();
    }
}