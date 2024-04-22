/*
  Given a string s, return the longest palindromic substring in s.

  Time: O(n^2)
  Space: O(1)
*/

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        int maxLength = Integer.MIN_VALUE;
        String result = "" + s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            int leftIdx = i - 1, rightIdx = i + 1;

            while (leftIdx >= 0 && rightIdx < s.length()) {
                if (s.charAt(leftIdx) == s.charAt(rightIdx)) {
                    int length = rightIdx - leftIdx + 1;
                    if (length > maxLength) {
                        maxLength = length;
                        result = s.substring(leftIdx, rightIdx + 1);
                    }
                } else {
                    break;
                }
                leftIdx--;
                rightIdx++;
            }

            leftIdx = i - 1; 
            rightIdx = i;
            
            while (leftIdx >= 0 && rightIdx < s.length()) {
                if (s.charAt(leftIdx) == s.charAt(rightIdx)) {
                    int length = rightIdx - leftIdx + 1;
                    if (length > maxLength) {
                        maxLength = length;
                        result = s.substring(leftIdx, rightIdx + 1);
                    }
                } else {
                    break;
                }
                leftIdx--;
                rightIdx++;
            }
        }

        return result;
    }
}
