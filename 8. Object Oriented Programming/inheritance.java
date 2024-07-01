public class inheritance {
    public static void main(String[] args) {
        Fish f1 = new Fish();
        f1.name = "GoldFish";
        f1.swims();
    }
}

//Parent Class
class Animal {
    String name;
    String sound;

    void eat() {
        System.out.println(this.name + " eats!");
    }
    void breathe() {
        System.out.println(this.name + " breathes!");
    }
}

//Derived/Child Class
class Fish extends Animal {
    int Fins;

    void swims() {
        System.out.println(this.name + " swims!");
    }
}
