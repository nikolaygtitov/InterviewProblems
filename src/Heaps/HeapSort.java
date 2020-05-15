package Heaps;

import java.util.Arrays;

public class HeapSort {
    BinaryMaxHeapImplementation binaryMaxHeapImplementation = new BinaryMaxHeapImplementation(10);
    int[] array = new int [] {8, 5, 4, 9, 1, 3, 0, 7, 6, 2};
    public HeapSort() {}

    public void sort() {
        for (Integer i : array) {
            binaryMaxHeapImplementation.insert(i);
        }
        binaryMaxHeapImplementation.print();
        int index = array.length - 1;
        while (!binaryMaxHeapImplementation.isEmpty()) {
            array[index--] = binaryMaxHeapImplementation.extractMax();
        }
        System.out.println("Heap Sorted Array is: " + Arrays.toString(array));
    }
}
