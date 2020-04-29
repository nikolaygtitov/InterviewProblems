package CommonProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Tuples {
    Map<Integer, ArrayList<Integer>> map;
    private List<Integer> arrayX, arrayY, arrayZ;

    /**
     * There are two different constructors to accommodate various inputs for this class since requirements
     * specifications were not clear whether it takes 3 arrays, or 3 arrayLists.
     * This constructor takes 3 arrays of integers.
     *
     * @param arrayX - array X of integers
     * @param arrayY - array Y of integers
     * @param arrayZ - array Z of integers
     */
    public Tuples(int[] arrayX, int[] arrayY, int[] arrayZ) {
        this.arrayX = new ArrayList<>();
        for (int x : arrayX) {
            this.arrayX.add(x);
        }
        this.arrayY = new ArrayList<>();
        for (int y : arrayY) {
            this.arrayY.add(y);
        }
        this.arrayZ = new ArrayList<>();
        for (int z : arrayZ) {
            this.arrayZ.add(z);
        }
        map = new HashMap<>();
    }

    /**
     * This is second constructor that takes 3 ArrayLists of integers.
     *
     * @param arrayX - ArrayList X of integers
     * @param arrayY - ArrayList Y of integers
     * @param arrayZ - ArrayList Z of integers
     */
    public Tuples(ArrayList<Integer> arrayX, ArrayList<Integer> arrayY, ArrayList<Integer> arrayZ) {
        this.arrayX = arrayX;
        this.arrayY = arrayY;
        this.arrayZ = arrayZ;
        map = new HashMap<>();
    }

    /**
     * Given three list of arrays X, Y, Z; each of which contains same number of non-zero integer elements. Write a
     * program to print tuples of the form (x, y, z) such that x belongs to X, y belongs to Y, and z belongs to Z and
     * z - y = x
     *
     * NOTE: This method does NOT print duplicated tuples!!!
     * In order to print duplicated tuples, comment out "removeDuplicates()" helper method.
     */
    public void printTuplesXYZ() {
        try {
            isArrayListsValid();
            removeDuplicates();

            // Store all x's elements of arrayX into HashMap<x -> [y1, y2, y3, ...]>
            for (Integer x : arrayX) {
                map.put(x, new ArrayList<>());
            }

            // Calculate z - y and check if result is in the Map
            // If result is in the Map, add y into list of Ys
            // Note: does not need to store z since z can be calculated as z = x + y
            int tempX;
            for (Integer z : arrayZ) {
                for (Integer y : arrayY) {
                    tempX = z - y;
                    if (map.containsKey(tempX)) {
                        map.get(tempX).add(y);
                    }
                }
            }

            // Print results
            // z = x + y
            for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
                for (Integer y : entry.getValue()) {
                    System.out.println("(" + entry.getKey() + ", " + y + ", " + (entry.getKey() + y) + ")");
                }
            }
        } catch (Exception e) {
            System.out.println(e + "\nPlease try it again.");
        }
    }

    /**
     * Validates whether list of arrays have expected data.
     *
     * @throws Exception if i) list of arrays are differ by their size, ii) list of arrays are empty, iii) either one
     * of list of arrays contains 0.
     */
    private void isArrayListsValid() throws Exception {
        if (arrayX.size() != arrayY.size() || arrayY.size() != arrayZ.size()) {
            throw new Exception("Error: List of Arrays are differ by their size!");
        } else if (arrayX.size() == 0) {
            throw new Exception("Error: List of Arrays are empty!");
        } else if (arrayX.contains(0) || arrayY.contains(0) || arrayZ.contains(0)) {
            throw new Exception("Error: One of Arrays contains 0 integer element!");
        }
    }

    /**
     * Removes duplicates from ArrayLists in order to reduce i) running time complexity: does not need to perform
     * calculation for duplicates and ii) space complexity: does not need to store duplicated tuples.
     */
    private void removeDuplicates() {
        arrayX = arrayX.stream().distinct().collect(Collectors.toList());
        arrayY = arrayY.stream().distinct().collect(Collectors.toList());
        arrayZ = arrayZ.stream().distinct().collect(Collectors.toList());
    }
}
