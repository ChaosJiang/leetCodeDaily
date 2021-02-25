import java.util.ArrayList;
import java.util.List;

/**
 * Project Name: leetcode
 * File Name: No144_BinaryTreePreorderTraversal
 * Created by Chiangsir.
 * Date: AD 2021/02/25
 */
public class No144_BinaryTreePreorderTraversal {
    /**
     * Given the root of a binary tree, return the preorder traversal of its nodes' values.
     * Input: root = [1,null,2,3]
     * Output: [1,2,3]
     * Example 2:
     * <p>
     * Input: root = []
     * Output: []
     * Example 3:
     * <p>
     * Input: root = [1]
     * Output: [1]
     * <p>
     * Input: root = [1,2]
     * Output: [1,2]
     * <p>
     * Input: root = [1,null,2]
     * Output: [1,2]
     *  
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the tree is in the range [0, 100].
     * -100 <= Node.val <= 100
     */
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }
    public void preorder(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
