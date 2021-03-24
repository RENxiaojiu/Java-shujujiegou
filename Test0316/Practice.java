package Test0316;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}


public class Practice {
    // 层序
    public static void sequence(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> s = new LinkedList<>();
        s.offer(root);
        while (true) {
            TreeNode cur = s.poll();
            if (cur == null) {
                break;
            }
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                s.offer(cur.left);
            }
            if (cur.right != null) {
                s.offer(cur.right);
            }
        }
    }

    // 判断一棵树是不是完全二叉树
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isLevel = false;
        Queue<TreeNode> s = new LinkedList<>();
        s.offer(root);
        while (true) {
            TreeNode cur = s.poll();
            if (cur == null) {
                break;
            }
            if (!isLevel) {
                if (cur.left != null && cur.right != null) {
                    s.offer(cur.left);
                    s.offer(cur.right);
                }
                if (cur.left != null && cur.right == null) {
                    s.offer(cur.left);
                    isLevel = true;
                }
                if (cur.left == null && cur.right != null) {
                    return false;
                }
                if (cur.left == null && cur.right == null) {
                    isLevel = true;
                }
            } else {
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
        return true;
    }

    // 判断是不是完全二叉树
    public static boolean isCompleteTree2(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isLevel = false;
        Queue<TreeNode> s = new LinkedList<>();
        s.offer(root);
        while (true) {
            TreeNode cur = s.poll();
            if (cur == null) {
                break;
            }
            if (!isLevel) {
                if (cur.left != null && cur.right != null) {
                    s.offer(cur.left);
                    s.offer(cur.right);
                }
                if (cur.left != null && cur.right == null) {
                    s.offer(cur.left);
                    isLevel = true;
                }
                if (cur.left == null && cur.right != null) {
                    return false;
                }
                if (cur.left == null && cur.right == null) {
                    isLevel = true;
                }
            } else {
                if (cur.left != null && cur.right != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
}