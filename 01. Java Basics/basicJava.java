import java.util.*;

class basicJava {
    public static void main(String args[]) {
        randomTests();
    }

    public static void pattern() {
        System.out.println("****");
        System.out.println("***");
        System.out.println("**");
        System.out.println("*");
    }

    public static void sum() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.err.println(a+b);
    }

    public static void product() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.err.println(a*b);
    }

    public static void areaCircle() {
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
        System.err.println(3.14*a*a);
    }

    public static void typeConversion() {
        int a = 1;
        char b = (char)a;
        System.out.println(b);
    }

    public static void typePromotion() {
        char a = 'a';
        char b = 'b';
        System.out.println(b-a);
    }

    public static void average() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        float avg = (a+b+c)/3;
        System.err.println(avg);
    }

    public static void areaSquare() {
        Scanner sc = new Scanner(System.in);
        int side = sc.nextInt();
        System.out.println(side*side);
    }

    public static void bill() {
        Scanner sc = new Scanner(System.in);
        float pencil = sc.nextFloat();
        float pen = sc.nextFloat();
        float eraser = sc.nextFloat();
        float total = pencil + pen + eraser ;
        double afterTax = total + (total*0.18);
        System.out.println("Total Bill without Tax : " + total);
        System.out.println("Total Bill with Tax : " + afterTax);
    }

    public static void randomTests() {
        int $ = 24;
        System.out.println($);
    }
}
