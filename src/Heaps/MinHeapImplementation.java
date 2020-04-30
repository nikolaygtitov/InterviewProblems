package Heaps;

/**
 * A Min-Heap is a complete binary tree in which the value in each internal node is smaller than or equal to the values
 * in the children of that node.
 * Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored
 * at index 2k + 1 and its right child at index 2k + 2.
 *
 * How is Min Heap represented?
 * A Min Heap is a Complete Binary Tree. A Min heap is typically represented as an array.
 * The root element will be at Arr[0]. For any ith node, i.e., Arr[i]:
 *
 * Arr[(i -1) / 2] returns its parent node.
 * Arr[(2 * i) + 1] returns its left child node.
 * Arr[(2 * i) + 2] returns its right child node.
 *
 * Operations on Min Heap:
 * getMin(): It returns the root element of Min Heap. Time Complexity of this operation is O(1).
 *
 * extractMin(): Removes the minimum element from MinHeap. Time Complexity of this Operation is O(Log n) as this
 * operation needs to maintain the heap property (by calling heapify()) after removing root.
 *
 * insert(): Inserting a new key takes O(Log n) time. We add a new key at the end of the tree. If new key is larger
 * than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap
 * property.
 */
public class MinHeapImplementation {
    final int[] heap;
    private int size;
    private final int maxSize;

    private static final int FRONT = 1;

    public MinHeapImplementation(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    /**
     * Inserts new node into MinHeap
     */
    public void insert(int value) {
        try {
            heap[++size] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Maximum size of the MinHeap is reached! Can not insert any more!");
            return;
        }

        // Traverse up and fix violated property
        int currentPosition = size;
        while(heap[currentPosition] < heap[parentPosition(currentPosition)]) {
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
     * Extracts minimum node-value.
     * @return maximum value of the MinHeap
     */
    public int extractMin() {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    /**
     * A recursive function to minHeapify the given subtree. This function assumes that the left and right subtrees
     * are already heapified, we only need to fix the root.
     * @param position - position to start from to heapify
     */
    private void minHeapify(int position) {
        if (isLeaf(position)) {
            return;
        }
        if (heap[position] > heap[leftChild(position)] || heap[position] > heap[rightChild(position)]) {
            if (heap[leftChild(position)] < heap[rightChild(position)]) {
                swap(position, leftChild(position));
                minHeapify(leftChild(position));
            } else {
                swap(position, rightChild(position));
                minHeapify(rightChild(position));
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
