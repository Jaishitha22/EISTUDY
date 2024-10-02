import java.util.*;

abstract class SmartDevice {
    protected String id;

    public SmartDevice(String id) {
        this.id = id;
    }

    public abstract String getStatus();
}

class Light extends SmartDevice {
    private boolean isOn;

    public Light(String id) {
        super(id);
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    @Override
    public String getStatus() {
        return "Light " + id + (isOn ? " is On" : " is Off");
    }
}

class Thermostat extends SmartDevice {
    private int temperature;

    public Thermostat(String id, int temperature) {
        super(id);
        this.temperature = temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String getStatus() {
        return "Thermostat " + id + " is set to " + temperature + " degrees";
    }
}

class DoorLock extends SmartDevice {
    private boolean isLocked;

    public DoorLock(String id) {
        super(id);
        this.isLocked = true; // Default is locked
    }

    public void unlock() {
        isLocked = false;
    }

    public void lock() {
        isLocked = true;
    }

    @Override
    public String getStatus() {
        return "DoorLock " + id + (isLocked ? " is Locked" : " is Unlocked");
    }
}

class SmartHomeSystem {
    private Map<String, SmartDevice> devices;
    private List<String> schedules;
    private List<String> triggers;

    public SmartHomeSystem() {
        devices = new HashMap<>();
        schedules = new ArrayList<>();
        triggers = new ArrayList<>();
        initializeDevices();
    }

    private void initializeDevices() {
        devices.put("1", new Light("1"));
        devices.put("2", new Thermostat("2", 70));
        devices.put("3", new DoorLock("3"));
        System.out.println("Light 1 has been added to the system.");
        System.out.println("Thermostat 2 has been added to the system.");
        System.out.println("DoorLock 3 has been added to the system.");
    }

    public void turnOnDevice(String id) {
        if (devices.containsKey(id) && devices.get(id) instanceof Light) {
            ((Light) devices.get(id)).turnOn();
            System.out.println("Light " + id + " is On.");
        } else {
            System.out.println("Device not found or cannot be turned on.");
        }
    }

    public void turnOffDevice(String id) {
        if (devices.containsKey(id) && devices.get(id) instanceof Light) {
            ((Light) devices.get(id)).turnOff();
            System.out.println("Light " + id + " is Off.");
        } else {
            System.out.println("Device not found or cannot be turned off.");
        }
    }

    public void setSchedule(String id, String time, String command) {
        schedules.add("Schedule for Device " + id + ": " + command + " at " + time);
        System.out.println("Schedule set for Device " + id + ": " + command + " at " + time);
    }

    public void addTrigger(String condition, String action) {
        triggers.add("When " + condition + ", do " + action);
        System.out.println("Trigger added: When " + condition + ", do " + action);
    }

    public void showStatus() {
        for (SmartDevice device : devices.values()) {
            System.out.println(device.getStatus());
        }
    }

    public void triggerTemperature(int currentTemperature) {
        if (currentTemperature > 75) {
            turnOffDevice("1"); // Assumes that device ID "1" is the light to turn off
        }
    }
}

public class SmartHome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartHomeSystem smartHomeSystem = new SmartHomeSystem();
        boolean running = true;

        while (running) {
            System.out.println("\n1. Turn On Device");
            System.out.println("2. Turn Off Device");
            System.out.println("3. Set Schedule");
            System.out.println("4. Add Trigger");
            System.out.println("5. Show Status");
            System.out.println("6. Trigger Temperature");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();

            scanner.nextLine(); // Clear the buffer to avoid InputMismatchException

            switch (option) {
                case 1: // Turn On Device
                    System.out.print("Enter device ID to turn on: ");
                    String idToTurnOn = scanner.nextLine();
                    smartHomeSystem.turnOnDevice(idToTurnOn);
                    break;
                case 2: // Turn Off Device
                    System.out.print("Enter device ID to turn off: ");
                    String idToTurnOff = scanner.nextLine();
                    smartHomeSystem.turnOffDevice(idToTurnOff);
                    break;
                case 3: // Set Schedule
                    System.out.print("Enter device ID to schedule: ");
                    String scheduleId = scanner.nextLine();
                    System.out.print("Enter time (e.g., 06:00): ");
                    String time = scanner.nextLine();
                    System.out.print("Enter command (Turn On/Turn Off): ");
                    String command = scanner.nextLine();
                    smartHomeSystem.setSchedule(scheduleId, time, command);
                    break;
                case 4: // Add Trigger
                    System.out.print("Enter condition (e.g., temperature > 75): ");
                    String condition = scanner.nextLine();
                    System.out.print("Enter action (e.g., turnOff(1)): ");
                    String action = scanner.nextLine();
                    smartHomeSystem.addTrigger(condition, action);
                    break;
                case 5: // Show Status
                    smartHomeSystem.showStatus();
                    break;
                case 6: // Trigger Temperature
                    System.out.print("Enter current temperature: ");
                    int currentTemperature = scanner.nextInt();
                    smartHomeSystem.triggerTemperature(currentTemperature);
                    break;
                case 7: // Exit
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        scanner.close();
    }
}


