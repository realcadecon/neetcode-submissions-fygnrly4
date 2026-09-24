class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<List<Integer>> stk = new Stack<>();
        int[] res = new int[temperatures.length];

        stk.push(List.of(temperatures[0], 0));
        for(int i=1; i<temperatures.length; i++) {
            while(!stk.isEmpty() && temperatures[i] > stk.peek().get(0)) {
                List<Integer> day = stk.pop();
                res[day.get(1)] = i - day.get(1);
            }
            stk.push(List.of(temperatures[i], i));
        }
        
        return res;
    }
}
