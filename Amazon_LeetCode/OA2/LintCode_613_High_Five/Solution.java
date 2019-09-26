import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Record[] testRecords = new Record[20];
		testRecords[0] = new Record(1, 95);
		testRecords[1] = new Record(1, 94);
		testRecords[2] = new Record(1, 93);
		testRecords[3] = new Record(1, 86);
		testRecords[4] = new Record(1, 38);
		testRecords[5] = new Record(1, 52);
		testRecords[6] = new Record(1, 36);
		testRecords[7] = new Record(2, 68);
		testRecords[8] = new Record(2, 76);
		testRecords[9] = new Record(2, 34);
		testRecords[10] = new Record(2, 78);
		testRecords[11] = new Record(2, 88);
		testRecords[12] = new Record(2, 96);
		testRecords[13] = new Record(2, 92);
		testRecords[14] = new Record(3, 46);
		testRecords[15] = new Record(3, 92);
		testRecords[16] = new Record(3, 65);
		testRecords[17] = new Record(3, 38);
		testRecords[18] = new Record(3, 10);
		testRecords[19] = new Record(3, 39);

		System.out.println(new Solution().highFive(testRecords));
	}

	public Map<Integer, Double> highFive(Record[] results) {
		Map<Integer, Double> res = new HashMap<>();
		Map<Integer, PriorityQueue<Integer>> id2PQ = new HashMap<>();

		for (int i = 0; i < results.length; i ++) {
			int id = results[i].id;
			if (id2PQ.containsKey(id)) {
				PriorityQueue<Integer> pq = id2PQ.get(id);
				pq.add(results[i].score);
				if (pq.size() > 5) 
					pq.poll();
			} else {
				PriorityQueue<Integer> pq = new PriorityQueue<>();
				pq.add(results[i].score);
				id2PQ.put(id, pq);
			}
		}

		for (int id : id2PQ.keySet()) {
			int sum = 0;
			PriorityQueue<Integer> pq = id2PQ.get(id);
			while (pq.size() > 0) {
				sum += pq.poll();
			}
			res.put(id, sum / 5.0);
		}

		return res;
	}


	public static class Record {
	    public int id, score;

	    public Record(int id, int score){
	        this.id = id;
	        this.score = score;
	    }
	}
}