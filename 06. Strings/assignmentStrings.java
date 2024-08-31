import java.util.Arrays;

public class assignmentStrings {
    public static void main(String[] args) {
        String str = "Hello World";
        //vowelCount(str);
        System.out.println(anagrams("care", "race"));
    }

    //Question1. Count how many times lowercase vowels occurred in a String entered by the user.
    public static void vowelCount(String str) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        System.out.println(count);
    }

    //Question 2. Determine if 2 Strings are anagrams of each other.
    public static boolean anagrams(String str1, String str2) {
        if (str1.length() == str2.length()) {
            str1.toLowerCase();
            str2.toLowerCase();
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            if (Arrays.equals(arr1, arr2) == true) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
}
