class Solution {
    public int search(int[] nums, int target) {
        int L=0, R=nums.length-1;
        int pivot = findPivot(L, R, nums);
        
        if(nums[pivot] <= target && target <= nums[R]) {
            L = pivot;
        } else {
            R = pivot - 1;
        }   
        return solve(L, R, nums, target);
    }

    public int solve(int L, int R, int[] nums, int target) {
        if(L > R) return -1;

        int m = (L + R)/2;
        if(nums[m] == target) return m;

        return target < nums[m] ? 
                solve(L, m-1, nums, target) :
                solve(m+1, R, nums, target);
    }

    public int findPivot(int L, int R, int[] nums) {
        if(L == R) return L;

        int m = (L+R)/2;
        if(nums[m] > nums[R]) {
            return findPivot(m+1, R, nums);
        }
        return findPivot(L, m, nums);
    }
}
