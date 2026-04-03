class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer[]> bars = new Stack<>(); //[first index of height, height]
        int maxArea = 0;

        for(int i=0; i<heights.length; i++) {
            int resetIndex = i;
            while(!bars.isEmpty() && bars.peek()[1] > heights[i] ) {
                Integer[] localMax = bars.pop();
                maxArea = Math.max(maxArea, localMax[1] * (i - localMax[0]));
                resetIndex = localMax[0];
            }
            bars.push(new Integer[]{resetIndex, heights[i]});
        }

        while(!bars.isEmpty()) {
            Integer[] localMax = bars.pop();
            maxArea = Math.max(maxArea, localMax[1] * (heights.length - localMax[0]));
        }

        return maxArea;
    }
}