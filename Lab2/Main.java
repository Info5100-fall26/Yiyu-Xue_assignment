public class Main {
    public static void main(String[] args) {
        Animals[] animals = {
            new Bird("Eagle", 90, 5, true, 200),
            new LandAnimal("Elephant", 650, 6000, false, 4),
            new Fish("Shark", 450, 1100, true, 8)
        };

        for (Animals a : animals) {
            a.describe();
            System.out.println();
        }
    }
}


class Animals {
    String name;        
    double size;       
    double weight;      
    boolean isPredator; 

    Animals(String name, double size, double weight, boolean isPredator) {
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.isPredator = isPredator;
    }

    void describe() {
        System.out.println("Name: " + name);
        System.out.println("  Size: " + size + " cm, Weight: " + weight + " kg");
        System.out.println("  Diet: " + (isPredator ? "Predator" : "Vegetarian"));
    }
}


class Bird extends Animals {
    double wingspan;

    Bird(String name, double size, double weight, boolean isPredator, double wingspan) {
        super(name, size, weight, isPredator);
        this.wingspan = wingspan;
    }

    @Override
    void describe() {
        super.describe();
        System.out.println("  Type: Bird, Wingspan: " + wingspan + " cm");
    }
}

class LandAnimal extends Animals {
    int legs;

    LandAnimal(String name, double size, double weight, boolean isPredator, int legs) {
        super(name, size, weight, isPredator);
        this.legs = legs;
    }

    @Override
    void describe() {
        super.describe();
        System.out.println("  Type: Land animal, Legs: " + legs);
    }
}


class Fish extends Animals {
    int fins;

    Fish(String name, double size, double weight, boolean isPredator, int fins) {
        super(name, size, weight, isPredator);
        this.fins = fins;
    }

    @Override
    void describe() {
        super.describe();
        System.out.println("  Type: Fish, Fins: " + fins);
    }
}