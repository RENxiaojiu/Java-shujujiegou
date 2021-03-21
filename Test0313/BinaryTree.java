package Test0313;

import sun.plugin.liveconnect.OriginNotAllowedException;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class BinaryTree {
    public static TreeNode build() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = f;
        c.right = g;
        return a;
    }

    // 先序
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val + " ");
        inOrder(root.right);
    }

    // 后序
    public static void posOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        posOrder(root.left);
        preOrder(root.right);
        System.out.println(root.val + " ");
    }

    // 求节点个数
    public static int num = 0;
    public static void getSize0(TreeNode root) {
        if (root == null) {
            return;
        }
        num++;
        getSize0(root.left);
        getSize0(root.right);
    }
    public static int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int a = getSize(root.left);
        int b = getSize(root.right);
        return 1 + a + b;
    }

    // 求叶子节点个数
    public static int getLeafSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    public static int num2 = 0;
    public static void getLeafSize2(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            num2++;
        }
        getLeafSize2(root.left);
        getLeafSize2(root.right);
    }

    // 求第 k 层节点个数
    public static int getKLevelSize(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);
    }

    // 获取二叉树的高度
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int a = getHeight(root.left);
        int b = getHeight(root.right);
        return 1 + (a > b ? a : b);
    }

    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    public static TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode result = find(root.left, val);
        if (result != null) {
            return result;
        }
        return find(root.right, val);
    }

    // 层序
    public static void levelOrderTraversal(TreeNode root) {
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
                } else if (cur.left == null && cur.right != null) {
                    return false;
                } else if (cur.left != null && cur.right == null) {
                    s.offer(cur.left);
                    isLevel = true;
                } else if(cur.left == null && cur.right == null) {
                    isLevel = true;
                }
            } else {
                if (cur.left != null || cur.right != null) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        TreeNode root = build();
        preOrder(root);
        System.out.println();
        int a = getSize(root);
        System.out.println(a);
        getSize0(root);
        System.out.println(num);
        int b = getLeafSize(root);
        System.out.println(b);
        getLeafSize2(root);
        System.out.println(num2);
        int c = getKLevelSize(root, 4);
        System.out.println(c);
        int d =getHeight(root);
        System.out.println(d);
        TreeNode result = find(root, 6);
        System.out.println(result.val);
        levelOrderTraversal(root);
        System.out.println();
        boolean t = isCompleteTree(root);
        System.out.println(t);
    }
}

