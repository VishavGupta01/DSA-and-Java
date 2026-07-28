public class maxBalancedStringPartitions {
    // We have balanced str of size N with an equal number of L and R, the task is to find a maximum number X, such that a given string can be partitioned into X balanced substring.
    // A string is called balanced if number of 'L's in the string equals to the number of 'R's.

    public static int solution(String input) {
        int res = 0;
        int count = 0;
        for(char ch : input.toCharArray()) {
            if(ch == 'L') {
                count++;
            } else {
                count--;
            }
            if(count == 0) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String input = "LRRRRLLRLLRL";
        System.out.println(solution(input));
    }
}
