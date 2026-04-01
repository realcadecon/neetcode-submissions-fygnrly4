class Solution {

    //'3' is visited
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{0, 0});

        while(!stack.isEmpty()) {
            Integer[] loc = stack.pop();
            int r = loc[0], c = loc[1];

            //check bounds
            if(r < 0 || r >= grid.length || c < 0 || c >= grid[r].length ) continue;
            //already visited
            if(grid[r][c] == '3') continue; 

            //add island neighbors to stack
            if(grid[r][c] == '1') {
                islandCount += markIsland(grid, r, c);
            }
            grid[r][c] = '3';
            stack.push(new Integer[]{r-1, c}); //up
            stack.push(new Integer[]{r+1, c}); //down
            stack.push(new Integer[]{r, c-1}); //left
            stack.push(new Integer[]{r, c+1}); //right
        }

        return islandCount;
    }


    //'2' means island is already searched
    private int markIsland(char[][] grid, int row, int col) {
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{row, col});

        while(!stack.isEmpty()) {
            Integer[] loc = stack.pop();
            int r = loc[0], c = loc[1];

            //check bounds
            if(r < 0 || r >= grid.length || c < 0 || c >= grid[r].length ) continue;

            //add island neighbors to stack
            if(grid[r][c] == '1') {
                //mark as island counted
                grid[r][c] = '2';
                stack.push(new Integer[]{r-1, c}); //up
                stack.push(new Integer[]{r+1, c}); //down
                stack.push(new Integer[]{r, c-1}); //left
                stack.push(new Integer[]{r, c+1}); //right
            }
        }

        return 1;
    }
}
