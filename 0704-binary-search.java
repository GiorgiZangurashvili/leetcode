/*
    Given sorted int array, search for a target value
    Ex. nums = [-1,0,3,5,9,12], target = 9 -> 4 (index)

    Since array is sorted, perform binary search

    Time: O(log n)
    Space: O(1)
*/

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int midPoint = left + (right - left) / 2;

            if (nums[midPoint] == target) {
                return midPoint;
            } else if (nums[midPoint] > target) {
                right = midPoint - 1;
            } else {
                left = midPoint + 1;
            }
        }

        return -1;
    }
}
