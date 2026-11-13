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

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    private void setSpeed(double newSpeed) {
        currentSpeed = Math.max(0, Math.min(newSpeed, enginePower));
    }

    public void startEngine() {
        setSpeed (0.1);
    }

    public void stopEngine() {
        setSpeed(0);
    }

    protected abstract double speedFactor();

    private void incrementSpeed(double amount) {
        setSpeed(currentSpeed + speedFactor() * amount);
    }

    private void decrementSpeed(double amount) {
        setSpeed(currentSpeed - speedFactor() * amount);
    }

    // TODO fix this method according to assignment pm
    public void gas(double amount) {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("only accepts values in the interval [0,1]");
        }
        double before = currentSpeed;
        incrementSpeed(amount);
        if (currentSpeed < before) {
            currentSpeed = before;
        }
    }

    // TODO fix this method according to assignment pm
    public void brake(double amount) {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("only accepts values in the interval [0,1]");
        }
        double before = currentSpeed;

        decrementSpeed(amount);
        if (currentSpeed > before){
            currentSpeed = before;
        }
    }


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