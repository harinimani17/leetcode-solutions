import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Base score for the current level

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0); // Entering a new nested level
            } else {
                int innerScore = stack.pop();
                int currentScore = stack.pop();
                // If innerScore is 0, it means we had "()", score is 1.
                // Otherwise, we had "(A)", score is 2 * innerScore.
                int addedScore = innerScore == 0 ? 1 : 2 * innerScore;
                stack.push(currentScore + addedScore);
            }
        }

        return stack.pop();
    }
}
