/*
  Given two strings s and t, return true if t is an anagram of s, and false otherwise.  
  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.  

  Time: O(n)
  Space: O(n)
*/

class Solution {
    public boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        var charOccurencesInStr1 = new HashMap<Character, Integer>();
        var charOccurencesInStr2 = new HashMap<Character, Integer>();

        for (int i = 0; i < str1.length(); i++) {
            char charInStr1 = str1.charAt(i);
            char charInStr2 = str2.charAt(i);

            if (!charOccurencesInStr1.containsKey(charInStr1)) {
                charOccurencesInStr1.put(charInStr1, 1);
            } else {
                charOccurencesInStr1.put(charInStr1, charOccurencesInStr1.get(charInStr1) + 1);
            }

            if (!charOccurencesInStr2.containsKey(charInStr2)) {
                charOccurencesInStr2.put(charInStr2, 1);
            } else {
                charOccurencesInStr2.put(charInStr2, charOccurencesInStr2.get(charInStr2) + 1);
            }
        }

        return charOccurencesInStr1.equals(charOccurencesInStr2);
    }
}
