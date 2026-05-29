class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        Set<String> seen = new HashSet<>();

        for(int i=0; i<nums.length-1; i++) {
          for(int j=i+1; j<nums.length-1; j++) {
            // System.out.printf("*i = %d, *j = %d, L = %d, R = %d\n", nums[i], nums[j], j+1, nums.length-1);
            int k = solve(-1 * (nums[i] + nums[j]), j+1, nums.length-1, nums);
            String key = String.format("%d%d%d", nums[i], nums[j], k);
            if(k != 100001 && !seen.contains(key)) {
              seen.add(key);
              res.add(List.of(nums[i], nums[j], k));
            }
          }
        }

        return res;
    }

    private int solve(int search, int L, int R, int[] nums) {
      int M = (L + R) / 2;
      if(L > R) {
        return 100001;
      }

      if(nums[M] == search) {
        return nums[M];  
      }

      if(nums[M] < search) {
        return solve(search, M+1, R, nums);
      }
      else {
        return solve(search, L, R-1, nums);
      }
    }
}

// -4, -1, -1, 0, 1, 2