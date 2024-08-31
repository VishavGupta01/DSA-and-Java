public class stackOverflowDemo {
    public static void main(String[] args) {
        recursiveMethod(1);
    }

    public static void recursiveMethod(int count) {
        System.out.println("Recursion depth: " + count);
        recursiveMethod(count + 1);
    }
}
