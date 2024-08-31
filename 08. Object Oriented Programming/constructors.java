
public class constructors {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.rollNo = 5;
        //s1.marks[0] = 100;

        Student s2 = new Student(s1);
        s1.rollNo = 6;
        //s1.marks[0] = 90;
        System.out.println(s2.rollNo);
        //System.out.println(s2.marks[0]);
    }
}

//Constructors
class Student {
    String name;
    int rollNo;
    int[] marks = new int[3];

    //Non-Parameterized Constructors
    Student() {

    }

    //Parameterized Constructors
    Student(String name1) {
        this.name = name1;
        System.out.println(this.name);
        marks = new int[3];
    }
    Student(int roll) {
        this.rollNo = roll;
        marks = new int[3];
    }
    Student(String name1, int roll) {
        this.name = name1;
        this.rollNo = rollNo;
        marks = new int[3];
    }

    //Copy Constructor
    Student(Student s1) {
        marks = new int[3];
        this.name = s1.name;
        this.rollNo = s1.rollNo;
        //Shallow Copy
        //this.marks = s1.marks; //Copying the reference to other s1.marks array
        //Deep Copy
        this.marks = new int[3]; //Creating a new array for Deep Copy.
        for(int i = 0; i < this.marks.length; i++) { // Storing all the values of s1.marks[] to s2.marks[]
            this.marks[i] = s1.marks[i];
        }
    }

}