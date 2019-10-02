// Solution 1
class Solution {
    private int[][] points;
    
    public int[][] kClosest(int[][] points, int K) {
        // CC: no
        // time: 
        // space:
        
        /**
         * (PQ)
         * comparator: pow(a, 2) + pow(b, 2)
         * keep the size = K
         */
        
        this.points = points;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new PointComparator());
        
        for (int i = 0; i < points.length; i ++) {
            pq.add(i);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        
        int[][] closestPoints = new int[K][];
        for (int i = 0; i < K; i ++) {
            closestPoints[i] = points[pq.poll()];
        }
        
        return closestPoints;
    }
    
    public class PointComparator implements Comparator<Integer> {
        
        public int compare(Integer a, Integer b) {
            int distance_a = points[a][0] * points[a][0] + points[a][1] * points[a][1];
            int distance_b = points[b][0] * points[b][0] + points[b][1] * points[b][1];
            
            if (distance_a < distance_b) {
                return 1;
            } else if (distance_a > distance_b) {
                return -1;
            } else {
                return 0;
            }
        }
    } 
}


// Solution 2
class Solution {
    
    public int[][] kClosest(int[][] points, int K) {
        // CC: no
        // time: O(nlogn)
        // space:
        
        /**
         * (PQ)
         * comparator: pow(a, 2) + pow(b, 2)
         * keep the size = K
         */
        
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]));
        
        return Arrays.copyOfRange(points, 0, K);
    }
}