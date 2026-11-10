import java.awt.*;

public abstract class cars {
    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;

    public cars(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }

    public int getNrDoors() { return nrDoors; }
    public double getEnginePower() { return enginePower; }
    public double getCurrentSpeed() { return currentSpeed; }
    public Color getColor() { return color; }
    public void setColor(Color clr) { color = clr; }

    public void startEngine() { currentSpeed = 0.1; }
    public void stopEngine() { currentSpeed = 0; }

    // The one thing every car calculates differently
    public abstract double speedFactor();

    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method according to assignment pm
    public void gas(double amount) { incrementSpeed(amount); }

    // TODO fix this method according to assignment pm
    public void brake(double amount) { decrementSpeed(amount); }
}