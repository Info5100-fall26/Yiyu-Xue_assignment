package HW10;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("Toyota", 180, 4),
            new Motorbike("Honda", 160, false),
            new Aircraft("Boeing", 900, 180),
            new Ship("Ocean Star", 45, 30)
        };

        System.out.println("Vehicle information and movement:");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            vehicle.move();
            System.out.println();
        }

        Vehicle fastest = vehicles[0];
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMaxSpeed() > fastest.getMaxSpeed()) {
                fastest = vehicle;
            }
        }
        System.out.println("Fastest vehicle: " + fastest.getBrand()
                + " (" + fastest.getMaxSpeed() + " km/h)");
    }
}
