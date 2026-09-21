class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getFirst() - a.getFirst());
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i : nums) {
          freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        freqMap.forEach((num, freq) -> {
          maxHeap.add(List.of(freq, num));
        });

        int[] res = new int[k];
        for(int i=0; i<k; i++) {
          res[i] = maxHeap.poll().get(1);
        }

        return res;
    }
}
