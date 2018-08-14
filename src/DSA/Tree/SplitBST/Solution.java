package DSA.Tree.SplitBST;

import DSA.Tree.TreeNode;
/*
 * Given a Binary Search Tree (BST) with root node root, and a target value V, split the tree into two subtrees where one subtree has nodes that are all smaller or equal to the target value, while the other subtree has all nodes that are greater than the target value.  It's not necessarily the case that the tree contains a node with value V.

Additionally, most of the structure of the original tree should remain.  Formally, for any child C with parent P in the original tree, if they are both in the same subtree after the split, then node C should still have the parent P.

You should output the root TreeNode of both subtrees after splitting, in any order.

Basical tree recursion ops
 */
public class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {

        TreeNode[] result = new TreeNode[2];

        if (root == null) {
            return result;
        }

        if (root.val <= V) {
            result[0] = root;
            TreeNode[] rightRes = splitBST(root.right, V);
            root.right = rightRes[0];
            result[1] = rightRes[1];
        } else {
            result[1] = root;
            TreeNode[] leftRes = splitBST(root.left, V);
            root.left = leftRes[1];
            result[0] = leftRes[0];
        }

        return result;
    }
}
