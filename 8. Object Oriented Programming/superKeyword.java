public class superKeyword {
    public static void main(String[] args) {
        Horse1 h = new Horse1();
        h.printColor();
        h.changeColor("Red");
        h.printColor();
    }
}

class Animal1 {
    String color = "blue";
    Animal1() {
        System.out.println("Animal1 Constructor is called!");
    }
    void getColor() {
        System.out.println(color);
    }
}

class Horse1 extends Animal1 {
    Horse1() {
        super(); //Accessing Parent's Constructor
        System.out.println("Horse1 Constructor is called!");
    }
    void printColor(){
        super.getColor(); //Accessing Parent's Method/Function
    }
    void changeColor(String color) {
        super.color = color;
    }
}

