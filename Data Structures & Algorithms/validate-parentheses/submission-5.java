class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        Map<Character, Character> key = new HashMap<>();
        key.put('{', '}');
        key.put('[', ']');
        key.put('(', ')');

        for(Character c : s.toCharArray()) {
            if(!stk.isEmpty() && key.get(stk.peek()) == c) {
                stk.pop();
            } else {
                stk.push(c);
            }
        }

        return stk.isEmpty();
    }
}
