package CommonProblems;

public class ProgrammingAssignment {
    public static void main (String []args) {
        // doTuples();
        // doFibonacci();
        // doFIndLeafs();
        // doTwoSum();
        // doLinkedListInReverse();
        // doLongestSubstringWithoutRepeatingCharacter();
        // doLongestPalindromicSubstring();
        // doSpiralIn2DArray();
        // doBalancedBrackets();
        doPartialNames();
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

    private static void doLinkedListInReverse() {
        LinkedListInReverse linkedListInReverse = new LinkedListInReverse();
        linkedListInReverse.addTwoLists();
    }

    private static void doLongestSubstringWithoutRepeatingCharacter() {
        LongestSubstring longestSubstring = new LongestSubstring();
        longestSubstring.findLongestSubstringWithoutRepeatingCharacter();
    }

    private static void doLongestPalindromicSubstring() {
        LongestPalindromic longestPalindromic = new LongestPalindromic();
        longestPalindromic.findLongestPalindromicSubstring();
    }

    private static void doSpiralIn2DArray() {
        Spiral2DArray spiral2DArray = new Spiral2DArray();
        spiral2DArray.iterateInSpiral();
    }

    private static void doBalancedBrackets() {
        BalancedBrackets balancedBrackets = new BalancedBrackets();
    }

    private static void doPartialNames() {
        PartialNames partialNames = new PartialNames();
        partialNames.findPartialNames();
    }
}
