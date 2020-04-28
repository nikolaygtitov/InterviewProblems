package Heaps;

public class TestHeaps {
    public static void main (String []args) {
        maxHeapImplementationTest();
        maxHeapTest();
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
}
