package Test0315;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
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

public class Solution {

    //先序
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> s = new ArrayList<>();
        if (root == null) {
            return s;
        }
        s.add(root.val);
        s.addAll(preorderTraversal(root.left));
        s.addAll(preorderTraversal(root.right));
        return s;
    }

    // 中序
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> s = new ArrayList<>();
        if (root == null) {
            return s;
        }
        s.addAll(inorderTraversal(root.left));
        s.add(root.val);
        s.addAll(inorderTraversal(root.right));
        return s;
    }

    // 后序
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> s = new ArrayList<>();
        if (root == null) {
            return s;
        }
        s.addAll(postorderTraversal(root.left));
        s.addAll(postorderTraversal(root.right));
        s.add(root.val);
        return s;
    }

    // 判断两棵树是否一样
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //  572. 另一个树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        boolean ret = isSameTree(s, t);
        if (ret) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // 求一颗二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int a = maxDepth(root.left);
        int b = maxDepth(root.right);
        return 1 + (a > b ? a : b);
    }

    // LeetCode 110. 平衡二叉树
    //给定一个二叉树，判断它是否是高度平衡的二叉树。
    //本题中，一棵高度平衡二叉树定义为：
    //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int a = getHight(root.left);
        int b = getHight(root.right);
        if (a - b > 1 || a - b < -1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int a = getHight(root.left);
        int b = getHight(root.right);
        return 1 + (a > b ? a : b);
    }

    // LeetCode  101. 对称二叉树
    // 给定一个二叉树，检查它是否是镜像对称的。
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}