import java.awt.*;

public abstract class cars implements Movable {
    private final int nrDoors;
    private final double enginePower;
    private double currentSpeed;
    private Color color;
    private final String modelName;

    private double x;
    private double y;
    private int direction; // 0 = north, 1 = east, 2 = south, 3 = west

    protected cars(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        x = 0;
        y = 0;
        direction = 0;
        stopEngine();
    }

    public int getNrDoors() { return nrDoors; }
    public double getEnginePower() { return enginePower; }
    public double getCurrentSpeed() { return currentSpeed; }
    public Color getColor() { return color; }
    public void setColor(Color clr) { color = clr; }

    public double getX() { return x; }
    public double getY() { return y; }
    public int getDirection() { return direction; }

    public void startEngine() { currentSpeed = 0.1; }
    public void stopEngine() { currentSpeed = 0; }

    protected abstract double speedFactor();

    private void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    private void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method according to assignment pm
    public void gas(double amount) { incrementSpeed(amount); }

    // TODO fix this method according to assignment pm
    public void brake(double amount) { decrementSpeed(amount); }

    @Override
    public void move() {
        if (direction == 0) {
            y = y + currentSpeed;
        } else if (direction == 1) {
            x = x + currentSpeed;
        } else if (direction == 2) {
            y = y - currentSpeed;
        } else {
            x = x - currentSpeed;
        }
    }

    @Override
    public void turnRight() {
        direction = direction + 1;
        if (direction == 4) {
            direction = 0;
        }
    }

    @Override
    public void turnLeft() {
        direction = direction - 1;
        if (direction < 0) {
            direction = 3;
        }
    }
}