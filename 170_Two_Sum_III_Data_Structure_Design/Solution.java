// Solution 1
class TwoSum {
    List<Integer> nums;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        nums = new ArrayList<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        nums.add(number);
        Collections.sort(nums);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int left = 0, right = nums.size() - 1;

        while (left < right) {
            int sum = nums.get(left) + nums.get(right);

            if (sum < value) {
                left ++;
            } else if (sum > value) {
                right --;
            } else {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */


// Solution 2
class TwoSum {
    List<Integer> nums;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        nums = new ArrayList<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        nums.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int i = 0, curNum = -1;

        for (; i < nums.size(); i ++) {
            curNum = nums.get(i);

            if (numMap.containsKey(curNum)) {
                return true;
            } else {
                numMap.put(value - curNum, i);
            }
        }
        
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */



// Solution 3
public class TwoSum {
    private List<Integer> list = new ArrayList<Integer>();
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    // Add the number to an internal data structure.
	public void add(int number) {
	    if (map.containsKey(number)) map.put(number, map.get(number) + 1);
	    else {
	        map.put(number, 1);
	        list.add(number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int i = 0; i < list.size(); i++){
	        int num1 = list.get(i), num2 = value - num1;
	        if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) return true;
	    }
	    return false;
	}
}
