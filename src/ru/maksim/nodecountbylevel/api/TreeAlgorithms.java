package ru.maksim.nodecountbylevel.api;

import com.sun.istack.internal.NotNull;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeAlgorithms {

    private static final Node END_OF_LEVEL = new Node(0);
    public static final int TREE_EMPTY = -1;
    public static final int NO_SUCH_LEVEL = -2;

    private TreeAlgorithms() {
        throw new AssertionError();
    }

    public static int getNodeCountByLevel(@NotNull BinarySearchTree tree, final int level) {
        if (level < 0) {
            throw new IllegalArgumentException("level cannot be negative");
        }
        if (tree.isEmpty()) {
            return TREE_EMPTY;
        }

        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(tree.getRoot());
        nodes.add(END_OF_LEVEL);
        int currentLevel = 0;
        while (currentLevel < level) {
            Node node = nodes.remove();
            if (node == END_OF_LEVEL) {
                nodes.add(END_OF_LEVEL);
                currentLevel++;
                continue;
            }
            Node left = node.getLeft();
            if (left != null) {
                nodes.add(left);
            }
            Node right = node.getRight();
            if (right != null) {
                nodes.add(right);
            }
            if (nodes.size() == 1) {
                return NO_SUCH_LEVEL;
            }
        }
        return nodes.size() - 1;
    }
}
