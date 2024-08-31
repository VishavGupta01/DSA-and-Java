public class interfacesMultipleInheritance {
    public static void main(String[] args) {
        Bear b = new Bear();
        b.eatsGrass();
        b.eatsMeat();
    }
}

interface Herbivore {
    void eatsGrass();
}

interface Carnivore {
    void eatsMeat();
}

class Bear implements Herbivore, Carnivore {
    public void eatsGrass() {
        System.out.println("Eats Grass!");
    }
    public void eatsMeat() {
        System.out.println("Eats Meat!");
    }
}
