public class basicsStrings {
    public static void main(String[] args) {
        String palindrome = "madam";
        System.out.println(palindrome(palindrome));

        String path = "WNEENESENNN";
        System.out.println(shortestPath(path));

        //SubStrings
        String a1 = "Hello World";
        System.out.println(a1.substring(3, 8));

        String[] fruits = {"apple", "mango", "banana"};
        largestString(fruits);
    }


    public static boolean palindrome(String word) {
        for(int i = 0; i < word.length()/2; i++) {
            if (word.charAt(i) != word.charAt(word.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

    public static double shortestPath(String path) {
        int x = 0;
        int y = 0;
        for(int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
                case 'E':
                    x++;
                    break;
            }
        }
        double shortest = Math.sqrt((Math.pow(x, 2)) + (Math.pow(y, 2)));
        return shortest;
    }

    public static void largestString(String[] fruits) {// Time Complexity => O(x * n) {x is the size of the longest string}
        String largest = fruits[0];
        for(int i = 1; i < fruits.length; i++) {
            if (largest.compareTo(fruits[i]) < 0) { //for smallest (largest.compareTo(fruits[i] > 0))
                largest = fruits[i];
            }
        }
        System.out.println("Largest String is " + largest);
    }
}
