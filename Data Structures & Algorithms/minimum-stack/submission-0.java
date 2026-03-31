class MinStack {

    private List<Integer> stack;

    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
    }
    
    public void pop() {
        if(stack.isEmpty()) return;

        stack.remove(stack.size()-1);
    }
    
    public int top() {
        // if(stack.isEmpty()) return null;

        return stack.get(stack.size()-1);

    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int i : stack) {
            if(i < min) {
                min = i;
            }
        }
        return min;
    }
}
