package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;


public class BreadthFirstSearch {
    private BinaryTree binaryTree;
    public BreadthFirstSearch(BinaryTree binaryTree) {
        this.binaryTree = binaryTree;
    }

    public void breadthFirstSearchPrint() {
        if (binaryTree.getRoot() == null) {
            System.out.println("Binary tree is empty");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> list;
        queue.add(binaryTree.getRoot());

        while (!queue.isEmpty()) {
            list = new ArrayList();
            while (!queue.isEmpty()) {
                list.add(queue.remove());
            }

            for (Node node : list) {
                if (node.leftChild != null) {
                    queue.add(node.leftChild);
                }
                if (node.rightChild != null) {
                    queue.add(node.rightChild);
                }
                System.out.print(node.value + " ");
            }
            System.out.println();
        }
    }

    public void insertAtFirstAvailableSpot(int value) {
        if (binaryTree.getRoot() == null) {
            binaryTree.insertKeepingStructure(value);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(binaryTree.getRoot());
        ArrayList<Node> list;

        while(!queue.isEmpty()) {
            list = new ArrayList<>();
            while(!queue.isEmpty()) {
                list.add(queue.remove());
            }
            for (Node node : list) {
                if (node.leftChild == null) {
                    node.leftChild = new Node(value);
                    queue.clear();
                    break;
                } else {
                    queue.add(node.leftChild);
                }
                if (node.rightChild == null) {
                    node.rightChild = new Node(value);
                    queue.clear();
                    break;
                } else {
                    queue.add(node.rightChild);
                }
            }
        }
    }

    public void printAverageOfEachLevel() {
        if (binaryTree.getRoot() == null) {
            System.out.println("Binary Tree is empty: Avg = 0");
            return;
        }

        Map<Integer, Integer> averagePerDepth = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(binaryTree.getRoot());
        ArrayList<Node> list;
        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            list = new ArrayList<>();

            int sum = 0;
            int average = 0;

            while (!queue.isEmpty()) {
                list.add(queue.remove());
            }

            for (Node node : list) {
                sum += node.value;
            }
            average = sum / list.size();
            averagePerDepth.put(depth, average);

            for (Node node : list) {
                if (node.leftChild != null) {
                    queue.add(node.leftChild);
                }
                if (node.rightChild != null) {
                    queue.add(node.rightChild);
                }
            }
        }

        System.out.println("The average of each level in Binary Tree is following:");
        for (Map.Entry<Integer, Integer> entry : averagePerDepth.entrySet()) {
            System.out.println("Level " + entry.getKey() + " and Average = " + entry.getValue());
        }

    }
}
