import java.util.Scanner;

public class basicsBM {
    public static void main(String[] args) {
        upperCaseToLowerCase();
    }

    public static void oddEven(int num) {
        if ((num & 1) == 1) {
            System.out.println("Odd!");
        } else {
            System.out.println("Even!");
        }
    }

    public static void get_ith_Bit(int num, int i) {
        int bitMask = 1 << i;
        if ((num & bitMask) == 0) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }
    }

    public static void set_ith_Bit(int num, int i) {
        int bitMask = 1 << i;
        System.out.println(num | bitMask);
    }

    public static int clear_ith_Bit(int num, int i) {
        int bitMask = ~(1 << i);
        return num & bitMask;
    }

    public static void update_ith_Bit(int num, int i, int val) {
        // if (val == 0) {
        //     clear_ith_Bit(num, i);
        // } else if (val == 1) {
        //     set_ith_Bit(num, i);
        // } else {
        //     System.out.println("Invalid Input! Valid Inputs are 0 or 1");
        // }

        num = clear_ith_Bit(num, i); // Clearing the ith Bit
        int newBitMask = val << i;
        System.out.println(num | newBitMask);
    }

    public static void clearLastI_Bits(int num , int i) {
        int bitMask = (~0)<<i;
        System.out.println(num & bitMask);
    }

    public static void powerOfTwo(int num) {
        if ((num & num - 1) == 0) {
            System.out.println(num + " is a power of 2!");
        } else {
            System.out.println(num + " is not a power of 2!");
        }
    }

    public static void countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
                num = num >> 1;
            } else {
                num = num >> 1;
            }
        }
        System.out.println(count);
    }

    public static void fastExpo(int num, int expo) {
        int ans = 1;
        int a = num;
        while (expo > 0) {
            if ((expo & 1) == 1) {
                ans = ans * a;
            } else {
                ans = ans * 1;
            }
            a = a * a;
            expo = expo >> 1;
        }
        System.out.println(ans);
    }

    public static void swap(int a, int b) {
        System.out.println("Values before Swap: a = " + a + " b = " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("Values after Swap: a = " + a + " b = " + b);
    }

    public static void addOne(int num) {
        System.out.println(-~num);
    }

    public static void upperCaseToLowerCase() {
        Scanner sc = new Scanner(System.in);
        String LC = sc.nextLine();
        int length = LC.length();
        StringBuilder sb = new StringBuilder("");
        char ch;
        for(int i = 0; i < length; i++) {
            ch = (char)(LC.charAt(i) | ' ');
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
