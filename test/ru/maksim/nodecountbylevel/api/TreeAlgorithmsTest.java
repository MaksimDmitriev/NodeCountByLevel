package ru.maksim.nodecountbylevel.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TreeAlgorithmsTest {

    @Test
    void assertEmptyTree() {
        BinarySearchTree tree = new BinarySearchTree();
        assertEquals(TreeAlgorithms.TREE_EMPTY, TreeAlgorithms.getNodeCountByLevel(tree, 0));
    }

    @Test
    void assertRootOnly() {
        BinarySearchTree tree = new BinarySearchTree(1);
        assertEquals(1, TreeAlgorithms.getNodeCountByLevel(tree, 0));
    }

    @Test
    void assertFirstLevelIncomplete() {
        BinarySearchTree tree = new BinarySearchTree(1, 2);
        assertEquals(1, TreeAlgorithms.getNodeCountByLevel(tree, 1));
    }

    @Test
    void assertFirstLevelComplete() {
        BinarySearchTree tree = new BinarySearchTree(2, 1, 3);
        assertEquals(2, TreeAlgorithms.getNodeCountByLevel(tree, 1));
    }

    @Test
    void assertSecondLevelIncomplete() {
        BinarySearchTree tree = new BinarySearchTree(10, 4, 16, 2, 7, 12);
        assertEquals(3, TreeAlgorithms.getNodeCountByLevel(tree, 2));
    }

    @Test
    void assertLevelGreaterThanTreeHas() {
        BinarySearchTree tree = new BinarySearchTree(10, 4, 16, 2, 7, 12);
        assertEquals(TreeAlgorithms.NO_SUCH_LEVEL, TreeAlgorithms.getNodeCountByLevel(tree, 20));
    }

    @Test
    void assertNegativeLevelPassed() {
        BinarySearchTree tree = new BinarySearchTree(10, 4, 16, 2, 7, 12);
        assertThrows(
                IllegalArgumentException.class,
                () -> TreeAlgorithms.getNodeCountByLevel(tree, -1)
        );
    }
}
