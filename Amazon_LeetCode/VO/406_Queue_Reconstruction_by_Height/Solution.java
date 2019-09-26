// Solution 1
class Solution {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        for (int[] p : people) {
            result.add(p[1], p);
        }
        return result.toArray(new int[people.length][]);
        // return result.toArray(people);
    }
}



// Solution 2
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // [<7,0>, [4,4], [7,1], [5,0], [6,1], [5,2]]
        // [[7,0], [7,1], [5,0], [6,1], <4,4>, [5,2]]
        // [[7,0], <7,1>, [5,0], [6,1], [4,4], [5,2]]
        // [<5,0>, [7,0], [7,1], [6,1], [4,4], [5,2]]
        // [[5,0], <7,0>, [7,1], [6,1], [4,4], [5,2]]
        // [[5,0], [7,0], <7,1>, [6,1], [4,4], [5,2]]
        // [[5,0], [7,0], <6,1>, [7,1], [4,4], [5,2]]
        // [[5,0], [7,0], [6,1], <7,1>, [4,4], [5,2]]
        // [[5,0], [7,0], [6,1], [7,1], <4,4>, [5,2]]
        // [[5,0], [7,0], <5,2>, [6,1], [7,1], [4,4]]
        // [[5,0], [7,0], [5,2], <6,1>, [7,1], [4,4]]
        // [[5,0], [7,0], [5,2], [6,1], <7,1>, [4,4]]
        // [[5,0], [7,0], [5,2], [6,1], <4,4>, [7,1]]
        // [[5,0], [7,0], [5,2], [6,1], [4,4], <7,1>]
        
        // [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        if (people == null || people.length == 0)
            return new int[0][];
        
        Arrays.sort(people, new Comparator<int[]>() { 
            public int compare(int[] a, int[] b) {
                return (b[0] - a[0]) == 0 ? a[1] - b[1] : b[0] - a[0];
            }
        });
        List<int[]> resList = new LinkedList<>();
        for (int[] p : people) {
            resList.add(p[1], p);
        }
        
        for (int i = 0; i < people.length; i ++) {
            people[i] = resList.get(i);
        }
        
        return people;
    }
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // [<7,0>, [4,4], [7,1], [5,0], [6,1], [5,2]]
        // [[7,0], [7,1], [5,0], [6,1], <4,4>, [5,2]]
        // [[7,0], <7,1>, [5,0], [6,1], [4,4], [5,2]]
        // [<5,0>, [7,0], [7,1], [6,1], [4,4], [5,2]]
        // [[5,0], <7,0>, [7,1], [6,1], [4,4], [5,2]]
        // [[5,0], [7,0], <7,1>, [6,1], [4,4], [5,2]]
        // [[5,0], [7,0], <6,1>, [7,1], [4,4], [5,2]]
        // [[5,0], [7,0], [6,1], <7,1>, [4,4], [5,2]]
        // [[5,0], [7,0], [6,1], [7,1], <4,4>, [5,2]]
        // [[5,0], [7,0], <5,2>, [6,1], [7,1], [4,4]]
        // [[5,0], [7,0], [5,2], <6,1>, [7,1], [4,4]]
        // [[5,0], [7,0], [5,2], [6,1], <7,1>, [4,4]]
        // [[5,0], [7,0], [5,2], [6,1], <4,4>, [7,1]]
        // [[5,0], [7,0], [5,2], [6,1], [4,4], <7,1>]
        
        // [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        if (people == null || people.length == 0)
            return new int[0][];
        
        Arrays.sort(people, new Comparator<int[]>() { 
            public int compare(int[] a, int[] b) {
                return (b[0] - a[0]) == 0 ? a[1] - b[1] : b[0] - a[0];
            }
        });
        List<int[]> resList = new LinkedList<>();
        for (int[] p : people) {
            resList.add(p[1], p);
        }
        
        for (int i = 0; i < people.length; i ++) {
            people[i] = resList.get(i);
        }
        
        return people;
    }
}}
