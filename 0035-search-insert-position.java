/*
  Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
  
  You must write an algorithm with O(log n) runtime complexity.

  Time: O(logn)
  Space: O(1)
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(right >= left){
            int index = left + (right - left) / 2;

            if(target == nums[index]){
                return index;
            }else if(nums[index] > target){
                right = index - 1;
            }else{
                left = index + 1;
            }
        }

        left = 0;
        right = nums.length - 1;

        while(right >= left){
            int index = left + (right - left) / 2;

            if(index - 1 >= 0 && target > nums[index - 1] && target < nums[index]){
                return index;
            }else if(index + 1 < nums.length && target < nums[index + 1] && target > nums[index]){
                return index + 1;
            }else if(index - 1 < 0 && target < nums[index]){
                return index;
            }else if(index + 1 >= nums.length && target > nums[index]){
                return index + 1;
            }else if(target > nums[index]){
                left = index + 1;
            }else if(target < nums[index]){
                right = index - 1;
            }
        }

        return -1;
    }
}
