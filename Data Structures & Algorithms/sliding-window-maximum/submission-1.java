class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 1) {
            return new int[]{nums[0]};
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int[] res = new int[nums.length-k+1];
        int L = 0;
        for(int R=0; R<nums.length; R++) {
            pq.add(nums[R]);
            if(R-L+1 == k) {
                res[L] = pq.peek();
                pq.remove(nums[L]);
                L++;
            }
        }

        return res;
    }
}
