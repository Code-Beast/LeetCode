// Solution 1: DFS
// Runtime: 7ms
/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    public void cleanRoom(Robot robot) {
        Set<String> set = new HashSet<>();
        // 0: up, 90: right, 180: down, 270: left
        int dir = 0;
        dfs(robot, set, 0, 0, 0);
    }
    
    private void dfs(Robot robot, Set<String> set, int i, int j, int dir) {
        String path = i + "->" + j;
        if (set.contains(path)) return;
        robot.clean();
        set.add(path);
        
        // clean in four directions
        for (int k = 0; k < 4; k ++) {
            if (robot.move()) {
                int x = i, y = j;

                switch(dir) {
                    case 0: {
                        x = i - 1;
                        break;
                    }
                        
                    case 90: {
                        y = j + 1;
                        break;
                    }
                        
                    case 180: {
                        x = i + 1;
                        break;
                    }
                        
                    case 270: {
                        y = j - 1;
                        break;
                    }
                        
                    default: break;
                }

                dfs(robot, set, x, y, dir);

                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
        
            robot.turnRight();
            dir += 90;
            dir %= 360;
        }
    }
}