package HW10;

public class Car extends Vehicle {
    private int doors;

    public Car(String brand, int maxSpeed, int doors) {
        super(brand, maxSpeed);
        this.doors = doors;
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " drives on roads with " + doors + " doors.");
    }
}
