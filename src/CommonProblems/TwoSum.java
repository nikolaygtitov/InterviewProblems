package CommonProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    private int[] array = {2, 7, 11, 15, 5, 5};
    private int target = 10;
    private Map<Integer, Set<Integer>> map;
    public TwoSum() {
        map = new HashMap<>();
    }

    private int[] inefficientFindIndexForTarget() throws Exception {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target && i != j) {
                    return new int[] {i, j};
                }
            }
        }
        throw new Exception("No two sums are found to meet target " + target);
    }

    private int[] efficientFindIndexForTarget() throws Exception {
        // Put in HashMap<number -> Set<index1, index2,...>>
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                return new int[] {map.get(target - array[i]).iterator().next(), i};
            }
            if (map.containsKey(array[i])) {
                map.get(array[i]).add(i);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(array[i], set);
            }
        }
        throw new Exception("No two sums are found to meet target " + target);
    }

    public void printTwoIndexes() {
        try {
            System.out.println(Arrays.toString(inefficientFindIndexForTarget()));
            System.out.println(Arrays.toString(efficientFindIndexForTarget()));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
