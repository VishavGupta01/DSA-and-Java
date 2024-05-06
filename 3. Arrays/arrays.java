import java.util.*;

public class arrays {
    public static void main(String args[]) {
        workingWithArrays();
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

}