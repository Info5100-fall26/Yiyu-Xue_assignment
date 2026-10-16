package HW10;
public class Motorbike extends Vehicle {
    private boolean hasSidecar;

    public Motorbike(String brand, int maxSpeed, boolean hasSidecar) {
        super(brand, maxSpeed);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " rides on roads. Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
}
