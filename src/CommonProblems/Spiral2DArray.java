package CommonProblems;

public class Spiral2DArray {
    private int[][] array;

    public Spiral2DArray() {
        array = new int[][] {
                {0, 1, 2, 3},
                {9, 10, 11, 4},
                {8, 7, 6, 5}
                // {15 ,26, 25, 24, 23, 8},
                //
                // {14, 13, 12, 11,10,9}
                // {11, 12, 13, 14, 5},
                // {10, 9, 8, 7, 6}
                // {13, 12,  11, 10, 9, 8},
        };
    }

    public void iterateInSpiral() {
        int rowStart, columnStart;
        rowStart = columnStart = 0;
        int rowFinish = array.length;
        int columnFinish = array[0].length;
        /** Print by squares - from outer to inner square */
        while (rowStart < rowFinish && columnStart < columnFinish) {
            // Print top row of the square by iterating over columns --> (from right to left)
            for (int i = columnStart; i < columnFinish; i++) {
                System.out.print(array[rowStart][i] + " ");
            }
            // Move to the below row
            rowStart++;

            // Print right-most column of the square by iterating over rows V (from top to bottom)
            for (int i = rowStart; i < rowFinish; i++) {
                System.out.print(array[i][columnFinish - 1] + " ");
            }
            // Move to the left-inner column from right-most column
            columnFinish--;

            // Check if top row and bottom row did not overlap
            if (rowStart < rowFinish) {
                // Print bottom row fo the square by iterating over columns <-- (from left to right)
                for (int i = columnFinish - 1; i >= columnStart; i--) {
                    System.out.print(array[rowFinish - 1][i] + " ");
                }
            }
            // Move to the next top row from the most bottom row
            rowFinish--;

            // Print left-most column of the square by iterating over rows /\ (from top to bottom)
            for (int i = rowFinish - 1; i >= rowStart; i--) {
                System.out.print(array[i][columnStart] + " ");
            }
            // Move to the right inner column from left-most column
            columnStart++;
        }
    }
}
