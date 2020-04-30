package Heaps;

public class HeapsTest {
    public static void main (String []args) {
        doMaxHeap();
        doMinHeap();
    }

    private static void doMaxHeap() {
        maxHeapImplementationTest();
        maxHeapTest();
    }

    private static void doMinHeap() {
        minHeapImplementationTest();
        minHeapTest();
    }

    public static void maxHeapImplementationTest() {
        MaxHeapImplementation maxHeapImplementation = new MaxHeapImplementation(10);
        maxHeapImplementation.insert(5);
        maxHeapImplementation.insert(3);
        maxHeapImplementation.insert(17);
        maxHeapImplementation.insert(10);
        maxHeapImplementation.insert(84);
        maxHeapImplementation.insert(19);
        maxHeapImplementation.insert(6);
        maxHeapImplementation.insert(22);
        maxHeapImplementation.insert(9);

        maxHeapImplementation.print();
        System.out.println(maxHeapImplementation.extractMax());
        maxHeapImplementation.print();
    }

    public static void maxHeapTest() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();

        System.out.println(maxHeap.extractMax());
        maxHeap.print();

        maxHeap.removeNode(17);
        maxHeap.print();
    }

    public static void minHeapImplementationTest() {
        MinHeapImplementation minHeapImplementation = new MinHeapImplementation(10);
        minHeapImplementation.insert(5);
        minHeapImplementation.insert(3);
        minHeapImplementation.insert(17);
        minHeapImplementation.insert(10);
        minHeapImplementation.insert(84);
        minHeapImplementation.insert(19);
        minHeapImplementation.insert(6);
        minHeapImplementation.insert(22);
        minHeapImplementation.insert(9);

        minHeapImplementation.print();
        System.out.println(minHeapImplementation.extractMin());
        minHeapImplementation.print();
    }

    public static void minHeapTest() {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.print();

        System.out.println(minHeap.extractMin());
        minHeap.print();

        minHeap.removeNode(17);
        minHeap.print();
    }
}
