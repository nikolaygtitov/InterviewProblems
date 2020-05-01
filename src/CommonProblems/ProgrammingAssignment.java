package CommonProblems;

public class ProgrammingAssignment {
    public static void main (String []args) {
        // doTuples();
        // doFibonacci();
        // doFIndLeafs();
        doTwoSum();
    }

    private static void doTuples() {
        int[] x = {1, 2, 7};
        int[] y = {3, 4, 9};
        int[] z = {5, 6, 3};

        Tuples tuples = new Tuples(x, y, z);
        tuples.printTuplesXYZ();
    }

    private static void doFibonacci() {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.calculate(9);
    }

    private static void doFIndLeafs() {
        LeafsInTree leafsInTree = new LeafsInTree();
        leafsInTree.buildMap();
    }

    private static void doTwoSum() {
        TwoSum twoSum = new TwoSum();
        twoSum.printTwoIndexes();
    }
}
