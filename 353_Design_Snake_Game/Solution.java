class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    private int width;
    private int height;
    private int score; // can be used to index food
    private int[][] food;
    
    private Deque<int[]> snake;
    private Set<String> body;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;       
        this.score = 0;
        this.food = food;
        
        snake = new ArrayDeque<int[]>();
        snake.offer(new int[]{0, 0});
        
        body = new HashSet<>();
        body.add("0-0");
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] head = snake.peekFirst();
        int[] next = new int[2];
        
        next[0] = head[0];
        next[1] = head[1];
        
        if (direction.equals("U")) {
            next[0] --;
        } else if (direction.equals("L")) {
            next[1] --;
        } else if (direction.equals("R")) {
            next[1] ++;
        } else if (direction.equals("D")) {
            next[0] ++;
        }
        
        // Remove the tail
        int[] tail = snake.removeLast();
        body.remove(tail[0] + "-" + tail[1]);
        
        // Return -1 if game over
        if (next[0] < 0 || next[0] >= height
           || next[1] < 0 || next[1] >= width
           || body.contains(next[0] + "-" + next[1])) {
            return -1;
        }
        
        // Updaet the body and snake
        body.add(next[0] + "-" + next[1]);
        snake.addFirst(next);
        
        if (score < food.length && next[0] == food[score][0] && next[1] == food[score][1]) {
            body.add(tail[0] + "-" + tail[1]);
            snake.addLast(tail);
            score ++;
        } 
        
        // Return score after the move
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */