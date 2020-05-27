package CommonProblems;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class FindRunningMedian {
    private int[] array;
    private int size = 5;

    public FindRunningMedian() {
        array = new int[] {1, 5, 4, 3, 2};
    }

    public void findRunningMedian() {
        double[] result = runningMedian(array);
        System.out.println(Arrays.toString(result));

    }

    private double[] runningMedian(int[] a) {
        DecimalFormat df = new DecimalFormat("#.0");
        df.setRoundingMode(RoundingMode.FLOOR);

        double[] result = new double[a.length];
        result[0] = new Double(df.format(a[0]));
        System.out.println(result[0]);

        for (int i = 1; i < a.length; i++) {
            insert(result, i, a[i]);
            printMedian(result, i + 1);
        }
        return result;
    }

    private void insert(double[] a, int size, int num) {
        double temp, temp1;
        boolean set = false;
        for (int i = 0; i < size; i++) {
            if (num < a[i]) {
                set = true;
                temp = a[i];
                a[i++] = num;
                while (i <= size) {
                    temp1 = a[i];
                    a[i++] = temp;
                    temp = temp1;
                }
            }
        }
        if (!set) {
            a[size] = num;
        }
    }

    private void printMedian(double[] a, int size) {
        if (size % 2 == 0) {
            // Even
            System.out.printf("%.1f", (a[size / 2] + a[size / 2 - 1]) / 2);
            System.out.println();
        } else {
            // Odd
            System.out.println(a[size / 2]);
        }
    }
}
