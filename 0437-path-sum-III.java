/*
  Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
  
  The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

  Time: O(n^2) - Worst Case, O(nlogn) - Tree is balanced.
  Space: O(n)

  Planning to return to this problem, for better time complexity.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        return rec(root, targetSum, 0);
    }

    private int rec(TreeNode root, long targetSum, int numCalls) {
        if (root == null) {
            return 0;
        }

        int result = rec(root.left, targetSum - root.val, numCalls + 1) + rec(root.right, targetSum - root.val, numCalls + 1);
        if (numCalls == 0) {
            result += rec(root.left, targetSum, 0) + rec(root.right, targetSum, 0);
        }

        if (targetSum - root.val == 0) {
            return result + 1;
        } else {
            return result;
        }
    }
}
