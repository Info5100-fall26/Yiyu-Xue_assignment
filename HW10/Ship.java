package HW10;
public class Ship extends Vehicle {
    private int crewSize;

    public Ship(String brand, int maxSpeed, int crewSize) {
        super(brand, maxSpeed);
        this.crewSize = crewSize;
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " sails on water with a crew of " + crewSize + ".");
    }
}
