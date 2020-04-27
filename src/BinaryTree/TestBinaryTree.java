package BinaryTree;

import java.util.ArrayList;

public class TestBinaryTree {
    public static void main (String args[]) {
        // ArrayList<Integer> arrayList = buildArrayList();
        BinaryTree binaryTree = new BinaryTree();
        DepthFistSearch depthFistSearch = new DepthFistSearch(binaryTree);
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(binaryTree);
        buildInGivenOrder(binaryTree);
        // binaryTree.insertFromListKeepingStructure(arrayList);
        // buildBinaryTree(binaryTree);
        // binaryTree.printAverageOfEachLevel();
        // depthFistSearch.depthFistSearchPrint();
        breadthFirstSearch.breadthFirstSearchPrint();
        // depthFistSearch.backwardDepthFistSearchPrint();
        breadthFirstSearch.insertAtFirstAvailableSpot(8);
        breadthFirstSearch.breadthFirstSearchPrint();
    }

    private static void buildInGivenOrder(BinaryTree binaryTree) {
        binaryTree.insertKeepingStructure(4);
        Node node = binaryTree.getRoot();
        node.leftChild = new Node(7);
        node.rightChild = new Node(9);

        node.leftChild.leftChild = new Node(10);
        node.leftChild.rightChild = new Node(2);

        node.rightChild.rightChild = new Node(6);

        node.leftChild.rightChild.rightChild = new Node(6);

        node.leftChild.rightChild.rightChild.leftChild = new Node(2);

    }

    private static ArrayList<Integer> buildArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(4);
        arrayList.add(7);
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(2);

        return arrayList;
    }

    private static void buildBinaryTree(BinaryTree binaryTree) {
        binaryTree.insertKeepingStructure(100);
        binaryTree.insertKeepingStructure(75);
        binaryTree.insertKeepingStructure(125);
        binaryTree.insertKeepingStructure(50);
        binaryTree.insertKeepingStructure(150);
        binaryTree.insertKeepingStructure(25);
        binaryTree.insertKeepingStructure(175);
        binaryTree.insertKeepingStructure(60);
        binaryTree.insertKeepingStructure(80);
    }
}
