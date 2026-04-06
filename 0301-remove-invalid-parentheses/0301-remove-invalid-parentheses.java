import java.util.*;

class Solution {

    Set<String> result = new HashSet<>();
    int minRemoved = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        backtrack(s, 0, 0);
        return new ArrayList<>(result);
    }

    private void backtrack(String s, int start, int removed) {

        if (removed > minRemoved) return;

        if (isValid(s)) {
            if (removed < minRemoved) {
                result.clear();
                minRemoved = removed;
            }
            result.add(s);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

            String next = s.substring(0, i) + s.substring(i + 1);
            backtrack(next, i, removed + 1);
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}