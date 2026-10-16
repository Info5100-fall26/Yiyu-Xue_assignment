package HW10;
public class Aircraft extends Vehicle {
    private int passengerCapacity;

    public Aircraft(String brand, int maxSpeed, int passengerCapacity) {
        super(brand, maxSpeed);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " flies in the air with capacity for " + passengerCapacity + " passengers.");
    }
}
