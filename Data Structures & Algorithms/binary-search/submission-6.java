class Solution {
    public int search(int[] nums, int target) {
        return solve(0, nums.length-1, target, nums);
    }

    public int solve(int L, int R, int target, int[] nums) {
        if(L > R) return -1;

        int idx = ((R - L) / 2) + L;
        if(nums[idx] == target) return idx;
        else if(nums[idx] < target) return solve(idx + 1, R, target, nums);
        else return solve(L, idx - 1, target, nums);
    }
}


// [-1,0,2,4,6,8] len = 6, t = 4
