/*
  You are climbing a staircase. It takes n steps to reach the top.
  
  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

  Solution: Recursion with memoization.

  Time: O(n)
  Space: O(n)

  P.S. O(1) space is possible, will do an improvement some other time.
*/

class Solution {
    public int climbStairs(int n) {
        return climbStairsWithMemo(n, new HashMap<Integer, Integer>());
    }

    private int climbStairsWithMemo(int n, Map<Integer, Integer> map) {
       if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }

        map.put(n, climbStairsWithMemo(n - 1, map) + climbStairsWithMemo(n - 2, map));
        return map.get(n);
    }
}
