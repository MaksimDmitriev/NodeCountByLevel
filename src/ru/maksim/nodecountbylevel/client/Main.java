package ru.maksim.nodecountbylevel.client;

import ru.maksim.nodecountbylevel.api.BinarySearchTree;
import ru.maksim.nodecountbylevel.api.TreeAlgorithms;

class Main {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insertAll(1, 23, 4, 20, 27, 89);
        System.out.println(TreeAlgorithms.getNodeCountByLevel(binarySearchTree, 2));
    }
}
