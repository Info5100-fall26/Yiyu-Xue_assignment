import java.util.ArrayList;

public class ArrayListAssignment {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<String>();
        cities.add("Austin");
        cities.add("Houston");
        cities.add("Oakland");
        cities.add("Paris");
        cities.add("San Francisco");
        cities.add("Seattle");
        // remove "Paris" from the list
        cities.remove("Paris");
        System.out.println("After removing Paris: " + cities);
    }
}
