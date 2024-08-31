public class staticKeyword {
    public static void main(String[] args) {
        Student1 s1 = new Student1();
        s1.schoolName = "TIET";
        System.out.println(s1.getPercentage(86,97,95));

        Student1 s2 = new Student1();
        System.out.println(s2.schoolName);
        System.out.println(s2.getPercentage(96, 78, 93));

    }
}

class Student1 {
    static String course;
    String name;
    int rollNo;

    static String schoolName; //Static property

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    static int getPercentage(int Maths, int Chem, int Phys) { //Static Function
        return (Maths + Chem + Phys) / 3;
    }
}