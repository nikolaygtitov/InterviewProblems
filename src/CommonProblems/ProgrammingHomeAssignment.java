package CommonProblems;

public class ProgrammingHomeAssignment {
    public static void main (String []args) {
        int[] x = {1, 2, 7};
        int[] y = {3, 4, 9};
        int[] z = {5, 6, 3};

        Tuples tuples = new Tuples(x, y, z);
        tuples.printTuplesXYZ();
    }
}
