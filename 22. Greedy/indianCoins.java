import java.util.LinkedHashMap;

public class indianCoins {
    // We are given infinite supply of denominations = [1, 2, 5, 10, 20, 50, 100, 500, 2000]
    // Find the min no of coins/notes to make change for a value "V"

    public static final int[] DENOMINATIONS = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

    public static LinkedHashMap<Integer, Integer> getBreakdown(int v) {
        LinkedHashMap<Integer, Integer> res = new LinkedHashMap<>();

        int i = DENOMINATIONS.length - 1;
        while(i > 0) {
            if(DENOMINATIONS[i] <= v) {
                int count = v / DENOMINATIONS[i];

                res.put(DENOMINATIONS[i], count);

                v %= DENOMINATIONS[i];
            }
            i--;
        }

        return res;
    }

    public static void main(String[] args) {
        int value = 590;

        LinkedHashMap<Integer, Integer> breakdown = getBreakdown(value);

        System.out.println(breakdown);
    }
}

