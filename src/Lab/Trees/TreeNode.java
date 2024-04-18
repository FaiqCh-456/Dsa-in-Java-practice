package Lab.Trees;

import java.util.LinkedList;
import java.util.Queue;


class TreeNode {
    String data;
    TreeNode left;
    TreeNode right;

    public TreeNode(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }


    public void breadthFirstTraversal() {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.print(currentNode.data + " ");

            if (currentNode.left != null)
                queue.add(currentNode.left);
            if (currentNode.right != null)
                queue.add(currentNode.right);
        }
    }
}

 class Main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode("N1");
        tree.root.left = new TreeNode("N2");
        tree.root.right = new TreeNode("N3");
        tree.root.left.left = new TreeNode("N4");
        tree.root.left.right = new TreeNode("N5");
        tree.root.right.left = new TreeNode("N6");
        tree.root.right.right = new TreeNode("N7");
        tree.root.left.left.left = new TreeNode("N8");
        tree.root.left.left.right = new TreeNode("N9");



        System.out.println("Breadth-First Traversal:");
        tree.breadthFirstTraversal();
    }
}
