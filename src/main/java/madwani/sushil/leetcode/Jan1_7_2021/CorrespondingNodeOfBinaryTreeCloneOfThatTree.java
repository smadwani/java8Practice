package madwani.sushil.leetcode.Jan1_7_2021;

import madwani.sushil.model.TreeNode;

public class CorrespondingNodeOfBinaryTreeCloneOfThatTree {

    public static void main(String[] args) {
        Integer [] orig = {1,2,3,4,5,6,7,8,9,10};
        TreeNode original = insertLevelOrder(orig, null, 0);
        TreeNode cloned = insertLevelOrder(orig, null, 0);
        TreeNode target = new TreeNode(5);
        target.left = new TreeNode(10);
        target.right = null;
        getTargetCopy(original, cloned, target);
    }

    static TreeNode res = null;

    public static TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || cloned == null || target == null) {
            return null;
        }
        if (original == target) {
            res = cloned;
        }
        getTargetCopy(original.left, cloned.left, target);
        getTargetCopy(original.right, cloned.right, target);
        return res;
    }

    // Function to insert nodes in level order 
    public static TreeNode insertLevelOrder(Integer[] arr, TreeNode root, int i)
    {
        // Base case for recursion 
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child 
            root.left = insertLevelOrder(arr, root.left,2 * i + 1);

            // insert right child 
            root.right = insertLevelOrder(arr, root.right,2 * i + 2);
        }
        return root;
    }
}
