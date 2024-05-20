package balancedbinarytree;

public class BalancedBinaryTree {
    
  
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

 
    private static class TreeInfo {
        int height;
        boolean isBalanced;

        TreeInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return checkBalance(root).isBalanced;
    }

    private TreeInfo checkBalance(TreeNode node) {
        if (node == null) {
            return new TreeInfo(0, true);
        }

        TreeInfo left = checkBalance(node.left);
        TreeInfo right = checkBalance(node.right);

        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;
        int height = Math.max(left.height, right.height) + 1;

        return new TreeInfo(height, isBalanced);
    }

    public static void main(String[] args) {
      
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BalancedBinaryTree treeChecker = new BalancedBinaryTree();
        System.out.println(treeChecker.isBalanced(root)); // Output: true
    }
}


