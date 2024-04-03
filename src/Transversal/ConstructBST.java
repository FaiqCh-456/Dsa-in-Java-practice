package Transversal;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class ConstructBST {
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return bstrecursive(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode bstrecursive(int[] preorder, int min, int max) {
        if (index == preorder.length || preorder[index] < min || preorder[index] > max) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = bstrecursive(preorder, min, root.val);
        root.right = bstrecursive(preorder, root.val, max);
        return root;
    }


    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        ConstructBST obj = new ConstructBST();
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = obj.bstFromPreorder(preorder);
        System.out.println("In-order Traversal of constructed BST:");
        obj.inOrderTraversal(root);
    }
}
