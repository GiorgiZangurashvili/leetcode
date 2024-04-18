/*
  Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum.  
  Each path should be returned as a list of the node values, not node references.  

  A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.  

  Time: O(n)
  Space: O(n)
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();

        rec(root, targetSum, currList, result);
        
        return result;
    }

    private void rec(TreeNode node, int targetSum, List<Integer> currList, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        currList.add(node.val);
        if (targetSum - node.val == 0 && node.left == null && node.right == null) {
            result.add(new ArrayList<>(currList));
            currList.remove(currList.size() - 1);
            return;
        }

        rec(node.left, targetSum - node.val, currList, result);
        rec(node.right, targetSum - node.val, currList, result);
        currList.remove(currList.size() - 1);
    }
}
