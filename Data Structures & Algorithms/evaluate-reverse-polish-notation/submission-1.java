class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> operators = Set.of("+", "-", "*", "/");

        for(String token : tokens) {
            if(operators.contains(token)) {
                int x = stack.pollFirst();
                int res = stack.pollFirst();
                switch(token) {
                    case "+":
                        res += x;
                        break;
                    case "-":
                        res -= x;
                        break;
                    case "*":
                        res *= x;
                        break;
                    case "/":
                        //TODO: check divide / 0
                        res /= x;
                        break;
                }
                stack.addFirst(res);
            } else {
                stack.addFirst(Integer.parseInt(token));
            }
        }
        return stack.pollFirst();
    }
}
