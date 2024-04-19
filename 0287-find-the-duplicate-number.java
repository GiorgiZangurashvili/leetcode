/*
  Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
  
  There is only one repeated number in nums, return this repeated number.
  
  You must solve the problem without modifying the array nums and uses only constant extra space.
  
  Time: O(n)
  Space: O(1)
*/

class Solution {
    public int findDuplicate(int[] nums) {
        int num1 = 0, num2 = 0;

        while (true) {
            num1 = nums[num1];
            num2 = nums[nums[num2]];

            if (num1 == num2) {
                break;
            }
        }

        int num3 = 0;

        while (true) {
            num1 = nums[num1];
            num3 = nums[num3];

            if (num1 == num3) {
                break;
            }
        }

        return num1;
    }
}
