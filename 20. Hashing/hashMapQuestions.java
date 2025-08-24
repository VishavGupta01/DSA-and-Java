import java.util.HashMap;
import java.util.TreeMap;

public class hashMapQuestions {
    public static void majorityElement(int[] arr) { // more than floor(n/3) times
        int n = arr.length;
        int k = n / 3;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key : map.keySet()) {
            if(map.get(key) > k) {
                System.out.print(key + " ");
            }
        }
    }

    public static boolean validAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        TreeMap<Character, Integer> map1 = new TreeMap<>();
        TreeMap<Character, Integer> map2 = new TreeMap<>();

        for(char ch : s1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        for(char ch : s2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        return map1.equals(map2);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        majorityElement(arr);

        System.out.println(validAnagram("lipid", "tulip"));
    }
}
