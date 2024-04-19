/*
  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
  
  An input string is valid if:
  
  1. Open brackets must be closed by the same type of brackets.
  2. Open brackets must be closed in the correct order.
  3. Every close bracket has a corresponding open bracket of the same type.

  Time: O(n)
  Space: O(n)
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() && (ch == ')' || ch == ']' || ch == '}')) {
                return false;
            }
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            if (ch == ')' && stack.pop() != '(') {
                return false;
            }
            if (ch == ']' && stack.pop() != '[') {
                return false;
            }
            if (ch == '}' && stack.pop() != '{') {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
