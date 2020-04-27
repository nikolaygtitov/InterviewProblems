package BinaryTree;

import java.util.Stack;

public class DepthFistSearch {
    private BinaryTree binaryTree;
    public DepthFistSearch(BinaryTree binaryTree) {
        this.binaryTree = binaryTree;
    }

    public void depthFistSearchPrint() {
        if (binaryTree.getRoot() == null) {
            System.out.println("The binary tree is empty");
            return;
        }
        Node node = binaryTree.getRoot();
        Stack<Node> stack = new Stack<>();
        stack.add(node);

        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node.rightChild != null) {
                stack.add(node.rightChild);
            }
            if (node.leftChild != null) {
                stack.add(node.leftChild);
            }
            System.out.println(node.value + " ");
        }
    }

    public void backwardDepthFistSearchPrint() {
        if (binaryTree.getRoot() == null) {
            System.out.println("The binary tree is empty");
            return;
        }
        Node node = binaryTree.getRoot();
        Stack<Node> stack = new Stack<>();
        addInStack(stack, node);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().value);
        }

    }

    private void addInStack(Stack stack, Node node) {
        stack.add(node);

        if (node.leftChild == null && node.rightChild == null) {
            return;
        }
        if (node.rightChild != null) {
            addInStack(stack, node.rightChild);
        }
        if (node.leftChild != null) {
            addInStack(stack, node.leftChild);
        }
    }
}
