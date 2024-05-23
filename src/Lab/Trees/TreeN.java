package Lab.Trees;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeN {
    int val;
    TreeN left;
    TreeN right;

    TreeN(int val) {
        this.val = val;
    }

    TreeN(int val, TreeN left, TreeN right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class UniqueBST {

    public List<TreeN> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return generateTrees(1, n);
    }

    private List<TreeN> generateTrees(int start, int end) {
        List<TreeN> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {

            List<TreeN> leftTrees = generateTrees(start, i - 1);
            List<TreeN> rightTrees = generateTrees(i + 1, end);

            for (TreeN left : leftTrees) {
                for (TreeN right : rightTrees) {
                    TreeN currentTree = new TreeN(i);
                    currentTree.left = left;
                    currentTree.right = right;
                    allTrees.add(currentTree);
                }
            }
        }

        return allTrees;
    }

    private List<Integer> serializeTree(TreeN root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            result.add(null);
            return result;
        }

        Queue<TreeN> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeN node = queue.poll();
            if (node == null) {
                result.add(null);
                continue;
            }

            result.add(node.val);
            queue.add(node.left);
            queue.add(node.right);
        }


        int lastIndex = result.size() - 1;
        while (lastIndex >= 0 && result.get(lastIndex) == null) {
            result.remove(lastIndex);
            lastIndex--;
        }

        return result;
    }

    public void printTrees(List<TreeN> trees) {
        List<List<Integer>> serializedTrees = new LinkedList<>();
        for (TreeN tree : trees) {
            serializedTrees.add(serializeTree(tree));
        }
        System.out.println(serializedTrees);
    }

    public static void main(String[] args) {
        UniqueBST solution = new UniqueBST();
        int n = 3;
        List<TreeN> trees = solution.generateTrees(n);
        solution.printTrees(trees);
    }
}
