/*
  Given two integer arrays nums1 and nums2, return an array of their intersection.
  Each element in the result must be unique and you may return the result in any order.

  Time: O(n + m)
  Space: O(n + m)
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> intersectionSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersectionSet.add(num);
            }
        }

        int[] result = new int[intersectionSet.size()];
        int index = 0;

        for (int num : intersectionSet) {
            result[index++] = num;
        }

        return result;
    }
}
