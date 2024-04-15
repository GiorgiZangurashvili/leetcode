/*
  Given the root of a binary tree, return the preorder traversal of its nodes' values.

  Ex. Input: root = [1,null,2,3]
      Output: [1,2,3]

  Time  : O(n)
  Space : O(h)
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        traverse(root, result);

        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        result.add(node.val);
        traverse(node.left, result);
        traverse(node.right, result);
    }
}
