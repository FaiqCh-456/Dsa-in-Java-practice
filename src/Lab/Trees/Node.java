package Lab.Trees;

class Node {
    int key, height;
    Node left, right;

    Node(int item) {
        key = item;
        height = 1;
    }
}

class AVLTree {
    Node root;

    // Get height of the node
    int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // Get balance factor of node
    int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // Right rotate subtree rooted with y
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotate subtree rooted with x
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Insert a node
    Node insert(Node node, int key) {
        // Perform normal BST insertion
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        // Update height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor of this ancestor node
        int balance = getBalance(node);

        // If the node becomes unbalanced, there are 4 cases

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the unchanged node
        return node;
    }

    // Get the inorder successor of the given node
    Node minValueNode(Node node) {
        Node current = node;

        // Find the leftmost leaf
        while (current.left != null)
            current = current.left;

        return current;
    }

    // Delete a node
    Node deleteNode(Node root, int key) {
        // Perform standard BST delete
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
        else {
            // Node with only one child or no child
            if (root.left == null || root.right == null) {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case
                    root = temp; // Copy the contents of the non-empty child

                temp = null;
            } else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }

        // If the tree had only one node, then return
        if (root == null)
            return root;

        // Update height of the current node
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // Get the balance factor
        int balance = getBalance(root);

        // If the node becomes unbalanced, there are 4 cases

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Function to perform inorder traversal of the tree
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    // Driver method
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the example */
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 21);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 13);
        tree.root = tree.insert(tree.root, 25);
        tree.root = tree.insert(tree.root, 2);

        System.out.println("Inorder traversal of the AVL tree:");
        tree.inorder(tree.root);
        System.out.println();

        // Delete node 15
        tree.root = tree.deleteNode(tree.root, 15);

        System.out.println("Inorder traversal after deleting 15:");
        tree.inorder(tree.root);
    }
}
