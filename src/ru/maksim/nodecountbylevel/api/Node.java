package ru.maksim.nodecountbylevel.api;

class Node {

    private final int key;
    private Node left;
    private Node right;

    Node(int key) {
        this.key = key;
    }

    void setLeft(Node left) {
        this.left = left;
    }

    void setRight(Node right) {
        this.right = right;
    }

    int getKey() {
        return key;
    }

    Node getLeft() {
        return left;
    }

    Node getRight() {
        return right;
    }

    @Override
    public String toString() {
        return Integer.toString(key);
    }
}
