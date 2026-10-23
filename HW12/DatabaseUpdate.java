import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class DatabaseUpdate {

    // ---- Change these to match your own MySQL installation ----
    static final String URL      = "jdbc:mysql://localhost:3306/testDB";
    static final String USER     = "root";
    static final String PASSWORD = "20040426Xyy.";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            // Step 1: Register the Driver class
            // (newer driver name; the slides use the older "com.mysql.jdbc.Driver")
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create connection (try-with-resources closes it automatically)
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                System.out.println("Connected to the database.");

                // ---------- Read one record ----------
                int id = readInt(input, "\nEnter the id of the student to read: ");
                if (!printStudent(conn, id, "Record read from the database")) {
                    System.out.println("No student with id " + id + " was found.");
                    return;
                }

                // Save the original values in Java so we can restore them later
                String originalName = getName(conn, id);
                int originalAge = getAge(conn, id);

                // ---------- Modify the record in the Java program ----------
                System.out.println("\n--- Modify the record ---");
                System.out.print("Enter a new name (press Enter to keep \"" + originalName + "\"): ");
                String newName = input.nextLine().trim();
                if (newName.isEmpty()) {
                    newName = originalName;
                }
                int newAge = readInt(input, "Enter a new age: ");

                // ---------- Update the record in the database ----------
                updateStudent(conn, id, newName, newAge);
                printStudent(conn, id, "Record after UPDATE");

                System.out.println("\nYou can now check the change in MySQL, for example:");
                System.out.println("    SELECT * FROM students WHERE id = " + id + ";");
                System.out.print("Press Enter to restore the original record...");
                input.nextLine();

                // ---------- Restore (rollback) the previous information ----------
                updateStudent(conn, id, originalName, originalAge);
                printStudent(conn, id, "Record after RESTORE (original data)");

            } // the connection is closed here
            System.out.println("\nConnection closed. Done.");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found. Add the MySQL Connector/J .jar to the classpath.");
        } catch (SQLException e) {
            // If a database operation fails, JDBC raises an SQLException
            System.out.println("Database error: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("\nNo more input available. The program will stop.");
        } finally {
            input.close();
        }
    }

    /** SELECT one student and print it. Returns false if the id does not exist. */
    static boolean printStudent(Connection conn, int id, String title) throws SQLException {
        String sql = "SELECT id, name, age FROM students WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);   // replace the ? placeholder
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("\n" + title + ":");
                    System.out.println("  id = " + rs.getInt("id")
                            + ", name = " + rs.getString("name")
                            + ", age = " + rs.getInt("age"));
                    return true;
                }
                return false;
            }
        }
    }

    /** Returns the student's name. */
    static String getName(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT name FROM students WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getString("name");
            }
        }
    }

    /** Returns the student's age. */
    static int getAge(Connection conn, int id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT age FROM students WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt("age");
            }
        }
    }

    /**
     * UPDATE one student inside a transaction (pattern from the slides):
     * commit if everything works, rollback if anything fails.
     */
    static void updateStudent(Connection conn, int id, String name, int age) throws SQLException {
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";
        boolean autoCommitDefault = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);           // start the transaction
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setInt(2, age);
                ps.setInt(3, id);
                int rows = ps.executeUpdate();
                System.out.println(rows + " row(s) updated.");
            }
            conn.commit();                       // save the change
        } catch (SQLException e) {
            conn.rollback();                     // undo the change if something failed
            System.out.println("Update failed - changes were rolled back.");
            throw e;
        } finally {
            conn.setAutoCommit(autoCommitDefault);
        }
    }

    /** Reads a whole number from the terminal, asking again on bad input (Chapter 11). */
    static int readInt(Scanner input, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: please enter a whole number.");
            }
        }
    }
}
