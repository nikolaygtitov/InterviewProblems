package CommonProblems;

public class DifferentSetsOfProblems {
    public static void main (String []args) {
        int[] x = {1, 2, 7};
        int[] y = {3, 4, 9};
        int[] z = {5, 6, 3};

        ArrayManipulations arrayManipulations = new ArrayManipulations(x, y, z);
        arrayManipulations.printTuplesXYZ();
    }
}
