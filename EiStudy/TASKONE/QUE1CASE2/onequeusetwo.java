// Command Interface
interface Command {
    void execute();
}

// Receiver Classes
class Light {
    public void on() {
        System.out.println("The light is on.");
    }
    public void off() {
        System.out.println("The light is off.");
    }
}

class Fan {
    public void on() {
        System.out.println("The fan is on.");
    }
    public void off() {
        System.out.println("The fan is off.");
    }
}

// Concrete Command Classes for Light
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

// Concrete Command Classes for Fan
class FanOnCommand implements Command {
    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }
}

class FanOffCommand implements Command {
    private Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.off();
    }
}

// Invoker Class (Remote Control)
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Client
public class CommandPatternDemo {
    public static void main(String[] args) {
        // Receivers
        Light livingRoomLight = new Light();
        Fan livingRoomFan = new Fan();

        // Commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command fanOn = new FanOnCommand(livingRoomFan);
        Command fanOff = new FanOffCommand(livingRoomFan);

        // Invoker (Remote Control)
        RemoteControl remote = new RemoteControl();

        // Turn the light on
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn the fan on
        remote.setCommand(fanOn);
        remote.pressButton();

        // Turn the light off
        remote.setCommand(lightOff);
        remote.pressButton();

        // Turn the fan off
        remote.setCommand(fanOff);
        remote.pressButton();
    }
}
