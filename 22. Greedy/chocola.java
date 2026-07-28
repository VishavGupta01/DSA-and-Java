import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class chocola {
    // We are given a bar of chocolate of m x n square pieces.
    // One should break the chocolate into single squares.
    // Each break of a part of the chocolate is charged a cost expressed by a positive integer.
    // The cost does not depend of the size of the part that is being broken but only depends on the line the break goes along.
    // Let us denote the costs of breaking along consecutive vertical lines with x1, x2, ..., xm-1 & along horizontal lines with y1, y2, ..., yn-1.
    // Compute the minimal cost of breaking the whole chocolate into single squares.

    public static int solution(Integer[] x, Integer[] y) {
        int hp = 1, vp = 1;
        int totalCost = 0;

        Arrays.sort(x, Collections.reverseOrder());
        Arrays.sort(y, Collections.reverseOrder());

        int i = 0, j = 0;
        while(i < x.length && j < y.length) {
            if(x[i] > y[j]) {
                totalCost += (x[i++] * hp);
                vp++;
            } else {
                totalCost += (y[j++] * vp);
                hp++;
            }
        }

        while(i < x.length) {
            totalCost += (x[i++] * hp);
            vp++;
        }

        while(j < y.length) {
            totalCost += (y[j++] * vp);
            hp++;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Integer[] verticalCutCosts = {2, 1, 3, 1, 4};
        Integer[] horizontalCutCosts = {4, 1, 2};

        System.out.println(solution(verticalCutCosts, horizontalCutCosts));
    }
}
