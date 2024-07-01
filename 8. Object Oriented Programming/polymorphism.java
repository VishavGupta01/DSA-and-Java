public class polymorphism {
    public static void main(String[] args) {
        //Method Overloading
        Calculator calc = new Calculator();
        System.out.println(calc.sum(1, 2));
        System.out.println(calc.sum((float)1.5, (float)2.5));
        System.out.println(calc.sum(1, 2, 3));

        //Method Overriding
        Deer d1 = new Deer();
        d1.eat();

        Animal d2 = new Deer();
        d2.eat();

        Animal d3 = new Animal();
        d3.eat();

    }
}

//Method Overloading
class Calculator {
    int sum(int a, int b) {
        return a + b;
    }
    float sum(float a, float b) { //by Data Type
        return a + b;
    }
    int sum(int a, int b, int c) { //by Count
        return a + b + c;
    }
}

//Method Overriding
class Animal {
    void eat() {
        System.out.println("eats anything!");
    }
}
class Deer extends Animal {
    void eat() {
        System.out.println("eats Grass!");
    }
}
