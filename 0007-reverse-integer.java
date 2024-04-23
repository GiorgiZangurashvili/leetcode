/*
  Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

  Time: O(n)
  Space: O(1)
*/

class Solution {
    public int reverse(int x) {
        long res = 0;
        int sign = 1;
        if (x < 0) {
            sign = -1;
        }
        x = Math.abs(x);
        while (x > 0) {
            int rem = x % 10;
            x /= 10;

            res += rem;
            if (x > 0)
                res *= 10;
                if (res > (long)Integer.MAX_VALUE) {
                    return 0;
                }
        }

        return (int)res * sign;
    }
}
