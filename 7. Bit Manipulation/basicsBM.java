public class basicsBM {
    public static void main(String[] args) {
        clearLastI_Bits(7, 2);
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
}
