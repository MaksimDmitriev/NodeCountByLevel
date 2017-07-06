package ru.maksim.nodecountbylevel.api;

import com.sun.istack.internal.NotNull;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeAlgorithms {

    public static final int NO_SUCH_LEVEL = -2;

    private TreeAlgorithms() {
        throw new AssertionError();
    }

    public static int getNodeCountByLevel(@NotNull BinarySearchTree tree, final int level) {
        if (level < 0) {
            throw new IllegalArgumentException("level cannot be negative");
        }
        if (tree.isEmpty()) {
            return 0;
        }

        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(tree.getRoot());
        int currentLevel = 0;
        while (currentLevel < level) {
            int count = nodes.size();
            for (int i = 0; i < count; i++) {
                Node node = nodes.poll();
                Node left = node.getLeft();
                if (left != null) {
                    nodes.add(left);
                }
                Node right = node.getRight();
                if (right != null) {
                    nodes.add(right);
                }
            }
            currentLevel++;
            if (nodes.isEmpty()) {
                return NO_SUCH_LEVEL;
            }
        }
        return nodes.size();
    }
}
