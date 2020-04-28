package Heaps;

/**
 * A max-heap is a complete binary tree in which the value in each internal node is greater than or equal to the values
 * in the children of that node.
 *
 * Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored
 * at index 2k+1 and its right child at index 2k+2.
 *
 * How is Max Heap represented?
 * A Max Heap is a Complete Binary Tree. A Max heap is typically represented as an array. The root element will be at
 * Arr[0]. Below table shows indexes of other nodes for the ith node, i.e., Arr[i]:
 * Arr[(i-1)/2] Returns the parent node.
 * Arr[(2*i)+1] Returns the left child node.
 * Arr[(2*i)+2] Returns the right child node.
 *
 * Operations on Max Heap:
 * 1) getMax(): It returns the root element of Max Heap. Time Complexity of this operation is O(1).
 *
 * 2) extractMax(): Removes the maximum element from MaxHeap. Time Complexity of this Operation is O(Log n) as this
 * operation needs to maintain the heap property (by calling heapify()) after removing root.
 *
 * 4) insert(): Inserting a new key takes O(Log n) time. We add a new key at the end of the tree. If new key is smaller
 * than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.
 */

public class MaxHeapImplementation {
    final private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeapImplementation(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize + 1];
        this.heap[0] = Integer.MAX_VALUE;
    }

    /**
     * Inserts new node into MaxHeap
     */
    public void insert(int value) {
        heap[++size] = value;

        // Traverse up and fix violated property
        int currentPosition = size;
        while(heap[currentPosition] > heap[parentPosition(currentPosition)]) {
            swap(currentPosition, parentPosition(currentPosition));
            currentPosition = parentPosition(currentPosition);
        }
    }

    /**
     * @param index - index of current node
     * @return position of the parent.
     */
    private int parentPosition(int index) {
        return index / 2;
    }

    /**
     * Swaps current node with parent node.
     * @param currentPosition - of current node
     * @param parentPosition - of the parent node
     */
    private void swap(int currentPosition, int parentPosition) {
        int tempNode = heap[currentPosition];
        heap[currentPosition] = heap[parentPosition];
        heap[parentPosition] = tempNode;
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.println(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2 * i] +
                    ((size >= 2 * i + 1) ? " RIGHT CHILD : " + heap [2 * i + 1] : ""));
        }
    }

    /**
     * Extracts maximum node-value.
     * @return maximum value of the MaxHeap
     */
    public int extractMax() {
        int popped = heap[1];
        heap[1] = heap[size--];
        maxHeapify(1);
        return popped;
    }

    /**
     * A recursive function to max heapify the given subtree. This function assumes that the left and right subtrees
     * are already heapified, we only need to fix the root.
     * @param position - position to start from to heapify
     */
    private void maxHeapify(int position) {
        if (isLeaf(position)) {
            return;
        }
        if (heap[position] < heap[leftChild(position)] || heap[position] < heap[rightChild(position)]) {
            if (heap[leftChild(position)] < heap[rightChild(position)]) {
                swap(position, rightChild(position));
                maxHeapify(rightChild(position));
            } else {
                swap(position, leftChild(position));
                maxHeapify(leftChild(position));
            }
        }
    }

    /**
     * Determines if node is a leaf
     * @param position - current position of the node
     * @return true of false whether node is leaf
     */
    private boolean isLeaf(int position) {
        if (position >= (size / 2) && position <= size) {
            return true;
        }
        return false;
    }

    /**
     * @param currentPosition of the node
     * @return position of the left child based on current position
     */
    private int leftChild(int currentPosition) {
        return 2 * currentPosition;
    }

    /**
     * @param currentPosition of the node
     * @return position of the right child based on current position
     */
    private int rightChild(int currentPosition) {
        return 2 * currentPosition + 1;
    }
}
