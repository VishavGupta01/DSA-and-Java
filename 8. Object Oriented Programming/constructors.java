
public class constructors {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Vishav";
        s1.marks[0] = 100;
        Student s2 = new Student(s1);
        s1.marks[0] = 90;
        s1.name = "Vish";
        System.out.println(s2.marks[0]);
        System.out.println(s2.name);
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
        this.rollNo = roll;
        marks = new int[3];
    }

    //Copy Constructor
    Student(Student s1) {
        marks = new int[3];
        this.name = s1.name;
        this.rollNo = s1.rollNo;
        this.marks = s1.marks;
    }

}