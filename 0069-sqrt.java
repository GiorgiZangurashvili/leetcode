/*
  Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
  
  You must not use any built-in exponent function or operator.
  
  For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

  Time: O(logn)
  Space: O(1)
*/

class Solution {
    public int mySqrt(int x) {
        long left = 0, right = x;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return (int)mid;
            } else if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 1;
    }
}
