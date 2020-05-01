package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * We use PriorityQueue class to implement Heaps in Java. By default Min Heap is implemented by this class.
 * To implement Max Heap, we use Collections.reverseOrder()
 * program to demonstrate working of PriorityQueue a Max Heap
 */
public class BinaryMaxHeap {
    final private PriorityQueue<Integer> priorityQueue;

    public BinaryMaxHeap() {
        this.priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    }

    /**
     * Inserts node into MaxHeap
     * @param value - node
     */
    public void insert(int value) {
        priorityQueue.add(value);
    }

    public void print() {
        int[] array = new int[priorityQueue.size() + 1];
        int size = 0;
        for (int i : priorityQueue) {
            array[++size] = i;
        }

        for (int i = 1; i <= array.length / 2; i++) {
            if (array.length > 2 * i) {
                System.out.println(" PARENT : " + array[i] + " LEFT CHILD : " + array[2 * i] +
                        ((array.length > 2 * i + 1) ? " RIGHT CHILD : " + array[2 * i + 1] : ""));
            }
        }
    }

    /**
     * Extracts maximum node-value.
     * @return maximum value of the MaxHeap
     */
    public int extractMax() {
        try {
            return priorityQueue.poll();
        } catch (NullPointerException e) {
            System.out.println("Error: Max Heap is empty!");
            return -1;
        }
    }

    /**
     * Removes Node from the MaxHeap
     * @param value - node to be removed from MaxHeap
     */
    public void removeNode(int value) {
        System.out.println("Removing node " + value);
        priorityQueue.remove(value);
    }
}
