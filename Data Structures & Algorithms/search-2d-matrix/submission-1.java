class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int bot = 0, top = ROWS - 1;
        while(bot <= top) {
            int row = bot + ((top - bot) / 2); 
            if(target > matrix[row][COLS-1]) {
                bot = row + 1;
            } else if(target < matrix[row][0]) {
                top = row - 1;
            } else {
                break;
            }
        }

        if(!(bot <= top)) return false;

        int L = 0, R = COLS - 1, row = (top + bot) / 2;
        while(L <= R) {
            int m = L + ((R - L) / 2);
            if(matrix[row][m] < target) L = m + 1;
            else if(matrix[row][m] > target) R = m - 1;
            else return true;
        }

        return false;
    }
}
