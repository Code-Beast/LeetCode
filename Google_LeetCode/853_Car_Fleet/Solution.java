// Solution 1: Sort + DP + Short Form of Camparator
// Runtime: 45ms
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || speed == null || position.length == 0 || speed.length == 0 || position.length != speed.length) {
            return 0;
        }
        
        int n = position.length;
        Car[] cars = new Car[n];
        
        for (int i = 0; i < n; i ++) {
            int pos = position[i];
            cars[i] = new Car(pos, (double)(target-pos) / speed[i]);
        }
        
        Arrays.sort(cars, (a, b) -> b.pos - a.pos);
        
        int count = 1;
        double curFleetTime = cars[0].time;
        for (int i = 1; i < n; i ++) {
            if (cars[i].time > curFleetTime) {
                count ++;
                curFleetTime = cars[i].time;
            }
        }
        
        return count;
    }
    
    private class Car {
        public int pos;
        public double time;
        
        public Car(int pos, double time) {
            this.pos = pos;
            this.time = time;
        }
    }
    
    private class CarComparator implements Comparator<Car> {
        public int compare(Car a, Car b) {
            return a.pos - b.pos;
        }
    }
}



// Solution 2: Sort + DP + Camparator Class
// Runtime: 17ms
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || speed == null || position.length == 0 || speed.length == 0 || position.length != speed.length) {
            return 0;
        }
        
        int n = position.length;
        Car[] cars = new Car[n];
        
        for (int i = 0; i < n; i ++) {
            int pos = position[i];
            cars[i] = new Car(pos, (double)(target-pos) / speed[i]);
        }
        
        Arrays.sort(cars, new CarComparator());
        
        int count = 1;
        double curFleetTime = cars[0].time;
        for (int i = 1; i < n; i ++) {
            if (cars[i].time > curFleetTime) {
                count ++;
                curFleetTime = cars[i].time;
            }
        }
        
        return count;
    }

    private class Car {
        public int pos;
        public double time;
        
        public Car(int pos, double time) {
            this.pos = pos;
            this.time = time;
        }
    }

    private class CarComparator implements Comparator<Car> {
        public int compare(Car a, Car b) {
            return b.pos - a.pos;
        }
    }
}



// Solution 3: Sort + DP + Inline Camparator Class
// Runtime: 16ms
class Solution {
  public int carFleet(int target, int[] position, int[] speed) {
      if (position == null || speed == null || position.length == 0 || speed.length == 0 || position.length != speed.length) {
          return 0;
      }
      
      int n = position.length;
      Car[] cars = new Car[n];
      
      for (int i = 0; i < n; i ++) {
          int pos = position[i];
          cars[i] = new Car(pos, (double)(target-pos) / speed[i]);
      }
      
      Arrays.sort(cars, new Comparator<Car>() {
          public int compare(Car a, Car b) {
              return b.pos - a.pos;
          }
      });
      
      int count = 1;
      double curFleetTime = cars[0].time;
      for (int i = 1; i < n; i ++) {
          if (cars[i].time > curFleetTime) {
              count ++;
              curFleetTime = cars[i].time;
          }
      }
      
      return count;
  }
  
  private class Car {
      public int pos;
      public double time;
      
      public Car(int pos, double time) {
          this.pos = pos;
          this.time = time;
      }
  }
}



// Solution 4: TreeMap
// Runtime: 20ms
class Solution {
  public int carFleet(int target, int[] position, int[] speed) {
      if (position == null || speed == null || position.length == 0 || speed.length == 0 || position.length != speed.length) {
          return 0;
      }
      
      int n = position.length;
      Map<Integer, Double> map = new TreeMap<>(Collections.reverseOrder());
      
      for (int i = 0; i < n; i ++) {
          map.put(position[i], (double)(target - position[i]) / speed[i]);
      }
      
      int count = 0;
      double curFleetTime = -1;
      List<Double> sortedTimes = new ArrayList<>(map.values());
      for (int i = 0; i < n; i ++) {
          if (sortedTimes.get(i) > curFleetTime) {
              count ++;
              curFleetTime = sortedTimes.get(i);
          }
      }
      
      return count;
  }
}