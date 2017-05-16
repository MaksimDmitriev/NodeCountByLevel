package ru.maksim.nodecountbylevel.api;

public class BinarySearchTree {

    private Node root = null;
    private int size = 0;

    public BinarySearchTree(int... keys) {
        insertAll(keys);
    }

    Node getRoot() {
        return root;
    }

    public void insertAll(int... keys) {
        for (int key : keys) {
            insert(key);
        }
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            Node current = root;
            Node parent = null;
            while (current != null) {
                parent = current;
                current = (key < current.getKey()) ? current.getLeft() : current.getRight();
            }
            if (key < parent.getKey()) {
                parent.setLeft(new Node(key));
            } else {
                parent.setRight(new Node(key));
            }
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
