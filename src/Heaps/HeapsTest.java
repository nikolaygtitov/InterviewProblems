package Heaps;

public class HeapsTest {
    public static void main (String []args) {
        //doMaxHeap();
        doMinHeap();
        //doHeapSort();
    }

    private static void doMaxHeap() {
        maxHeapImplementationTest();
        maxHeapTest();
    }

    private static void doMinHeap() {
        //minHeapImplementationTest();
        minHeapTest();
    }

    public static void maxHeapImplementationTest() {
        BinaryMaxHeapImplementation binaryMaxHeapImplementation = new BinaryMaxHeapImplementation(10);
        binaryMaxHeapImplementation.insert(5);
        binaryMaxHeapImplementation.insert(3);
        binaryMaxHeapImplementation.insert(17);
        binaryMaxHeapImplementation.insert(10);
        binaryMaxHeapImplementation.insert(84);
        binaryMaxHeapImplementation.insert(19);
        binaryMaxHeapImplementation.insert(6);
        binaryMaxHeapImplementation.insert(22);
        binaryMaxHeapImplementation.insert(9);

        binaryMaxHeapImplementation.print();
        System.out.println(binaryMaxHeapImplementation.extractMax());
        binaryMaxHeapImplementation.print();
    }

    public static void maxHeapTest() {
        BinaryMaxHeap binaryMaxHeap = new BinaryMaxHeap();
        binaryMaxHeap.insert(5);
        binaryMaxHeap.insert(3);
        binaryMaxHeap.insert(17);
        binaryMaxHeap.insert(10);
        binaryMaxHeap.insert(84);
        binaryMaxHeap.insert(19);
        binaryMaxHeap.insert(6);
        binaryMaxHeap.insert(22);
        binaryMaxHeap.insert(9);

        binaryMaxHeap.print();

        System.out.println(binaryMaxHeap.extractMax());
        binaryMaxHeap.print();

        binaryMaxHeap.removeNode(17);
        binaryMaxHeap.print();
    }

    public static void minHeapImplementationTest() {
        BinaryMinHeapImplementation binaryMinHeapImplementation = new BinaryMinHeapImplementation(10);
        binaryMinHeapImplementation.insert(5);
        binaryMinHeapImplementation.insert(3);
        binaryMinHeapImplementation.insert(17);
        binaryMinHeapImplementation.insert(10);
        binaryMinHeapImplementation.insert(84);
        binaryMinHeapImplementation.insert(19);
        binaryMinHeapImplementation.insert(6);
        binaryMinHeapImplementation.insert(22);
        binaryMinHeapImplementation.insert(9);

        binaryMinHeapImplementation.print();
        System.out.println(binaryMinHeapImplementation.extractMin());
        binaryMinHeapImplementation.print();
    }

    public static void minHeapTest() {
        BinaryMinHeap binaryMinHeap = new BinaryMinHeap();
        binaryMinHeap.insert(5);
        binaryMinHeap.insert(3);
        binaryMinHeap.insert(17);
        binaryMinHeap.insert(10);
        binaryMinHeap.insert(84);
        binaryMinHeap.insert(19);
        binaryMinHeap.insert(6);
        binaryMinHeap.insert(22);
        binaryMinHeap.insert(9);

        binaryMinHeap.print();

        System.out.println(binaryMinHeap.extractMin());
        binaryMinHeap.print();

        binaryMinHeap.removeNode(17);
        binaryMinHeap.print();
    }

    public static void doHeapSort() {
        HeapSort heapSort = new HeapSort();
        heapSort.sort();
    }
}
