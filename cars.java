import java.awt.*;

public abstract class cars implements Movable {
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

    public abstract double speedFactor();

    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    public void gas(double amount) { incrementSpeed(amount); }

    public void brake(double amount) { decrementSpeed(amount); }

    private double x;
    private double y;
    private int direction; // 0 = north, 1 = east, 2 = south, 3 = west

    @Override
    public void move() {
        if (direction == 0) {
            y = y + currentSpeed;
        }
    }

    @Override
    public void turnRight() {
        direction = direction + 1;
        if (direction == 4) {
            direction = 0;
        }
    }

}