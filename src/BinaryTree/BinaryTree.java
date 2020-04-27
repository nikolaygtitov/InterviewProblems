package BinaryTree;

import java.util.ArrayList;

public class BinaryTree {
    private Node root;

    public BinaryTree() {}

    public Node getRoot() {
        return root;
    }

    public void insertFromListKeepingStructure(ArrayList<Integer> list) {
        for (int value : list) {
            root = insertRecursive(root, value);
        }
    }

    public void insertKeepingStructure(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.leftChild = insertRecursive(node.leftChild, value);
        } else if (value > node.value) {
            node.rightChild = insertRecursive(node.rightChild, value);
        }
        return node;
    }

    public int findMaxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = findMaxDepth(node.leftChild);
        int rightDepth = findMaxDepth(node.rightChild);

        if (leftDepth < rightDepth) {
           return rightDepth + 1;
        }
        return leftDepth + 1;
    }
}

class Node {
    int value;
    int row, column;
    Node leftChild, rightChild;

    public Node(int value) {
        this.value = value;
        row = column = 0;
        leftChild = rightChild = null;
    }
}
