import java.lang.reflect.Constructor;

public class abstraction {
    public static void main(String[] args) {
        Horse h = new Horse();
        h.name = "Horse";
        h.walk();
        h.eat();

        //Animal a = new Animal(); //This will give error as abstract classes cannot be instantiated

        System.out.println(h.color); // O/P: brown
        //Changing color
        h.changeColor("black");
        System.out.println(h.color); // O/P: black

        //Constructor Calling Hierarchy Test
        // Mustang h = new Mustang();
        //Output:
        // Animal Constructor called!
        // Horse Constructor called!
        // Mustang Constructor called!
    }
}

//Abstract Class
abstract class Animal {
    String color;
    Animal() { //Constructors in abstract class are used to initialize the color variable to a default value till child class alters it.
        color = "brown";
        System.out.println("Animal Constructor called!");
    }

    //Non-Abstract Method
    void eat() {
        System.out.println("Eats Anything!");
    }

    //Abstract Method
    abstract void walk(); //Abstract methods are not implemented in abstract class they are implemented in the sub class.
}

class Horse extends Animal{ //If the inherited abstract walk() method is not implemented here it will give an error. (The type Horse must implement the inherited abstract method Animal.walk())
    String name;
    void walk() {
        System.out.println(this.name  + " walks on 4 legs!"); //Abstract Method Implementation
    }

    void changeColor(String color) {
        this.color = color;
    }

    Horse() {
        System.out.println("Horse Constructor called!");
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang Constructor called!");
    }
}

