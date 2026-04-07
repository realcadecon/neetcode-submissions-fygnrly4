class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int L = 1, R = Arrays.stream(piles).max().getAsInt();
        return solve(L, R, h, piles, R);
    }

    public int solve(int L, int R, int h, int[] piles, int minK) {
        if(L > R) return minK;

        int k = (L + R) / 2;
        int time = Arrays.stream(piles).reduce(0, (a, b) -> a + (int) Math.ceil((double) b / k));
        if(time > h) return solve(k+1, R, h, piles, minK); 
        
        minK = Math.min(minK, k);
        return solve(L, k-1, h, piles, minK);
    }
}
