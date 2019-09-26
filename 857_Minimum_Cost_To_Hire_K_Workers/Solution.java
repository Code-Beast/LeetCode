// Solution 1: Max Heap
// Runtime: 58ms
class Solution {
  class Worker implements Comparable<Worker> {
    private int quality;
    private int wage;
    public Worker(int q, int w) {
      quality = q;
      wage = w;
    }
    
    public int getQuality() {
      return quality;
    }
    
    public double getRatio() {
      return (double) wage / quality;
    }
    
    public int compareTo(Worker otherWorker) {
      if (this.getRatio() < otherWorker.getRatio()) {
        return -1;
      } else if (this.getRatio() > otherWorker.getRatio()) {
        return 1;
      } else {
        return 0;
      }
    }
  }
  
  public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
    int n = quality.length;
    Worker[] workers = new Worker[n];
    
    for (int i = 0; i < n; i ++) {
      workers[i] = new Worker(quality[i], wage[i]);
    }
    
    Arrays.sort(workers);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    double res = Double.MAX_VALUE;
    int totalQuality = 0;
    for (int i = 0; i < n; i ++) {
      maxHeap.offer(workers[i].quality);
      totalQuality += workers[i].quality;
      
      if (maxHeap.size() > K) {
        totalQuality -= maxHeap.poll();
      }
      
      if (maxHeap.size() == K) {
        res = Math.min(res, workers[i].getRatio() * totalQuality);
      }
    }
    
    return res;
  }
}