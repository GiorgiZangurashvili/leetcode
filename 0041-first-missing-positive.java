/*
  Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

  You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.


  Time: O(n)
  Space: O(1)
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int idx = Math.abs(nums[i]) - 1;
            if (idx >= nums.length) {
                continue;
            }

            if (nums[idx] > 0) {
                nums[idx] *= -1;
            } else if (nums[idx] == 0) {
                nums[idx] = -1 * (nums.length + 1);
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
