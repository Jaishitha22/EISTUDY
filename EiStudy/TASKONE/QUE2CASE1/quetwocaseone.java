// Singleton Class (Database Connection Manager)
class DatabaseConnection {
    // A private static variable to hold the one instance of the class
    private static DatabaseConnection instance;
    
    // Private constructor to prevent instantiation
    private DatabaseConnection() {
        System.out.println("Database Connection Created.");
    }
    
    // Static method to provide global access to the single instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    // A method to simulate some functionality
    public void connect() {
        System.out.println("Connected to the database.");
    }
}

// Client class
public class quetwocaseone {
    public static void main(String[] args) {
        // Try to create two instances of DatabaseConnection
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        DatabaseConnection connection2 = DatabaseConnection.getInstance();
        
        // Both connection1 and connection2 should point to the same instance
        connection1.connect();
        connection2.connect();
        
        // Check if both instances are the same
        if (connection1 == connection2) {
            System.out.println("Both connections are the same instance.");
        } else {
            System.out.println("Different instances exist.");
        }
    }
}
