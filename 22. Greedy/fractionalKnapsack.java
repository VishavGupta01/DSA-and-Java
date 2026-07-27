import java.util.*;

public class fractionalKnapsack {
    // Given the weights and the values of N items, put these items in a knapsack of
    // capacity W to get the maximum total value of the knapsack.
    public static void solution(int[] value, int[] weight, int w) {
        double[][] list = new double[value.length][4];

        for (int i = 0; i < value.length; i++) {
            list[i][0] = i;
            list[i][1] = value[i];
            list[i][2] = weight[i];
            list[i][3] = (double) value[i] / weight[i];
        }

        Arrays.sort(list, (a, b) -> Double.compare(b[3], a[3]));

        ArrayList<Integer> res = new ArrayList<>();
        double profit = 0;

        for (int i = 0; i < value.length; i++) {
            if (w <= 0)
                break;
            if (list[i][2] <= w) {
                profit += list[i][1];
                w -= list[i][2];
                res.add((int) list[i][0]);
            } else {
                profit += (list[i][3] * w);
                res.add((int) list[i][0]);
                break;
            }
        }

        System.out.println("Total Profit: " + profit);
        for (int r : res) {
            System.out.print("Item:" + r + " ");
        }
    }

    public static void main(String[] args) {
        int[] value = { 60, 100, 120 };
        int[] weight = { 10, 20, 30 };
        int w = 50;

        solution(value, weight, w);
    }
}