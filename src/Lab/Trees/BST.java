package Lab.Trees;

class TreeNode1 {
    int key;
    TreeNode1 left, right;
    int height;

    public TreeNode1(int item) {
        key = item;
        left = right = null;
        height = 1;
    }
}

class BST {
    private TreeNode1 root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    // Method to insert a key into the BST
    public void insert(int key) {
        root = insertRec(root, key, 0);
    }

    private TreeNode1 insertRec(TreeNode1 node, int key, int level) {
        if (node == null) {
            size++;
            System.out.println("Inserted key " + key + " at level " + level);
            return new TreeNode1(key);
        }

        if (key < node.key) {
            node.left = insertRec(node.left, key, level + 1);
        } else if (key > node.key) {
            node.right = insertRec(node.right, key, level + 1);
        } else {
            return node;  // Duplicate keys not allowed
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return node;
    }

    // Method to delete a key from the BST
    public void delete(int key) {
        root = deleteRec(root, key, 0);
    }

    private TreeNode1 deleteRec(TreeNode1 node, int key, int level) {
        if (node == null) {
            return node;
        }

        if (key < node.key) {
            node.left = deleteRec(node.left, key, level + 1);
        } else if (key > node.key) {
            node.right = deleteRec(node.right, key, level + 1);
        } else {
            System.out.println("Deleted key " + key + " at level " + level);
            if (node.left == null) {
                size--;
                return node.right;
            } else if (node.right == null) {
                size--;
                return node.left;
            }

            node.key = minValue(node.right);
            node.right = deleteRec(node.right, node.key, level + 1);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return node;
    }

    private int minValue(TreeNode1 node) {
        int minv = node.key;
        while (node.left != null) {
            minv = node.left.key;
            node = node.left;
        }
        return minv;
    }

    // Method to search for a key in the BST
    public boolean search(int key) {
        return searchRec(root, key, 0);
    }

    private boolean searchRec(TreeNode1 node, int key, int level) {
        if (node == null) {
            System.out.println("Key " + key + " not found at level " + level);
            return false;
        }

        if (node.key == key) {
            System.out.println("Key " + key + " found at level " + level);
            return true;
        }

        return key < node.key ? searchRec(node.left, key, level + 1) : searchRec(node.right, key, level + 1);
    }

    // Method to get the current height of the BST
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreeNode1 node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Method to get the total number of nodes in the BST
    public int getSize() {
        return size;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test suite for the BST
        runTests();
    }

    private static void runTests() {
        BST bst = new BST();

        // Test insertion and size/height tracking
        int[] elements = {15, 10, 20, 8, 12, 16, 25};
        for (int el : elements) {
            bst.insert(el);
        }


        System.out.println("Size: " + bst.getSize() + " (Expected: 7)");
        System.out.println("Height: " + bst.getHeight() + " (Expected: 3)");

        // Verify the search function
        bst.search(10);
        bst.search(100);

        // Test deletion
        bst.delete(20);
        System.out.println("\nTest Delete 20:");
        System.out.println("Size: " + bst.getSize() + " (Expected: 6)");
        System.out.println("Height: " + bst.getHeight() + " (Expected: 3)");
        bst.search(20);

        bst.delete(15);
        System.out.println("\nTest Delete 15:");
        System.out.println("Size: " + bst.getSize() + " (Expected: 5)");
        System.out.println("Height: " + bst.getHeight() + " (Expected: 3)");
        bst.search(15);

        bst.delete(8);
        System.out.println("\nTest Delete 8:");
        System.out.println("Size: " + bst.getSize() + " (Expected: 4)");
        System.out.println("Height: " + bst.getHeight() + " (Expected: 3)");
        bst.search(8);

        System.out.println("\nAll tests completed.");
    }
}

