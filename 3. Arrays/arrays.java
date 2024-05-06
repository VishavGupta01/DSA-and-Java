import java.util.*;

public class arrays {
    public static void main(String args[]) {
        binarySearch();
    }

    public static void creatingArrays() {
        int num[] = new int[10]; // creation without initialization
        char alphabets[] = {'a' , 'b' , 'c'}; //creating with initialization
        boolean tORf[] = {true , false , true};
        String words[] = {"Hello" , "World", "!"};
        String fruits[] = new String[10];
        Boolean fruit[] = new Boolean[10];

        for(int i = 0; i < 10; i++) {
            System.out.println(fruit[i]);
        }
    }

    public static void workingWithArrays() {
        Scanner sc = new Scanner(System.in);
        int marks[] = new int[3];
        //Inputting marks
        marks[0] = sc.nextInt();
        marks[1] = sc.nextInt();
        marks[2] = sc.nextInt();
        //outputting marks
        for(int i = 0; i<3; i++) {
            System.out.println(marks[i]);
        }

        //Updating Marks
        marks[2] = marks[2] + 1;
        System.out.println(marks[2]);

        //length of array
        System.out.println(marks.length);
    }

    public static void arguementsWithArrays(int marks[]) {
        for(int i = 0; i < marks.length ;i++) {
            marks[i] = marks[i] + 1;
        }
    }

    public static void workingWithArrays1() {
        int marks[] = {94, 96, 98};
        for(int i = 0; i< marks.length ; i++) {
            System.out.print(marks[i] + " ");
        }
        arguementsWithArrays(marks);
        for(int i = 0; i < marks.length ; i++) {
            System.out.println(marks[i] + " ");
        }
    }

    public static void linearSearch() {
        int numbers[] = {1,3,5,9,20,5,34,20,34,26};
        int key = 10; //Search Element
        boolean flag = false;
        for(int i = 0; i < numbers.length; i++) { //Time Complexity = O(n)
            if (numbers[i] == key) {
                System.out.println("Element found at " + i);
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println("Element not Found!");
        }
    }

    public static void largestInArray() {
        int number[] = {100,3,5,9,20,5,34,20,34,56};
        int largest = Integer.MIN_VALUE; //-infinity
        int smallest =  Integer.MAX_VALUE; //+infinity
        for(int i = 0; i < number.length; i++) { //Time Complexity = O(n)
            if (largest < number[i]) {
                largest = number[i];
            }
            if (smallest > number[i]) {
                smallest = number[i];
            }
        }
        System.out.println("Largest Number is " + largest);
        System.out.println("Smallest Number is " + smallest);
    }

    public static void binarySearch() {
        int number[] = {3,5,9,20,34,56,100}; //Sorted Array
        int key = 9;
        int LB = 0;
        int UB = number.length - 1;
        while (LB <= UB) {
            int mid = (LB + UB)/2;
            if (key == number[mid]) {
                System.out.println("Element found at "+ mid);
                break;
            } else if ( key > number[mid] ) { //right side
                LB = mid + 1;
            } else { //left side
                UB = mid - 1;
            }
        }
    }
}