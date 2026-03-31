class Solution {
    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        Map<Character, Character> key = new HashMap<>();
        key.put('{', '}');
        key.put('[', ']');
        key.put('(', ')');

        for(Character c : s.toCharArray()) {
            if(!stk.isEmpty() && key.get(stk.peekFirst()) == c) {
                stk.pollFirst();
            } else {
                stk.addFirst(c);
            }
        }

        return stk.isEmpty();
    }
}
