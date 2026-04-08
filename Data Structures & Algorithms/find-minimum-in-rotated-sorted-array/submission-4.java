class Solution {
    public int findMin(int[] nums) {
        return solve(0, nums.length-1, 1001, nums);
    }

    public int solve(int L, int R, int min, int[] nums) {
        if(L>R) return min;

        if(nums[L] < nums[R]) {
            return Math.min(min, nums[L]);
        }

        int m = (L+R)/2;
        min = Math.min(min, nums[m]);

        if(nums[L] <= nums[m]) return solve(m+1, R, min, nums);
        else return solve(L, R-1, min, nums);
    }
}
