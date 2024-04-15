/*
  You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

  You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

  Time: O(n)
  Space: O(1)
*/

class Solution {
    public void rotate(int[][] matrix) {
        int left = 0, right = matrix.length - 1;

        while (left < right) {
            for (int i = 0; i < right - left; i++) {
                int savedValue = matrix[left][left + i];
                matrix[left][left + i] = matrix[right - i][left];
                matrix[right - i][left] = matrix[right][right - i];
                matrix[right][right - i] = matrix[left + i][right];
                matrix[left + i][right] = savedValue;
            }
            right--;
            left++;
        }
    }
}
