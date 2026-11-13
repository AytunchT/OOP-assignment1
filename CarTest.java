public class CarTest {
    private static void reportResult(String testName, boolean success) {
        IO.println((success ? "SUCCESS: " : "FAILURE: ") + testName);
    }

    /**
     * Tests whether a Saab95 with turbo enabled
     * gains more speed than one without.
     */
    private static void testTurbo() {
        Saab95 slowSaab = new Saab95();
        Saab95 fastSaab = new Saab95();
        fastSaab.setTurboOn();
        slowSaab.setTurboOff();
        fastSaab.gas(0.5);
        slowSaab.gas(0.5);
        boolean result = slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();
        reportResult("Turbo yields more speed", result);
    }

    /**
     * Tests whether car is speeding
     */
    private static void testGas() {
        Saab95 car = new Saab95();
        double currentSpeed = car.getCurrentSpeed();
        car.gas(0.5);
        double speeding = car.getCurrentSpeed();
        boolean result = currentSpeed < speeding;
        reportResult("Speeding", result);
    }

    /**
     * Test whether car brakes
     */
    private static void testBrake(){
            Saab95 car = new Saab95();
            double currentSpeed = car.getCurrentSpeed();
            car.gas(0.5);
            double speeding = car.getCurrentSpeed();
            car.brake(0.2);
            double braking = car.getCurrentSpeed();
            boolean result = currentSpeed < braking & braking < speeding;
            reportResult("Braking", result);
    }

    /**
     * Test whether car turns right
     */
    private static void testTurnRight(){
        Saab95 car = new Saab95();
        car.turnRight();
        int direction = car.getDirection();
        boolean result = direction == 1;
        reportResult("Turning Right", result);
        }

    /**
     * Test whether car turns left
     */
    private static void testTurnLeft(){
        Saab95 car = new Saab95();
        car.turnLeft();
        int direction = car.getDirection();
        boolean result = direction == 3;
        reportResult("Turning Left", result);
    }

    /**
     * Tests whether the car moves in the right direction.
     */
    private static void moveTest(){
        Saab95 car = new Saab95();
        double currentY = car.getY();
        double currentX = car.getX();
        car.gas(0.5);
        //Goes North
        car.move(); // direction = 0
        double moveY = car.getY();
        boolean result = currentY < moveY;
        reportResult("Moving To North", result);
        currentY = moveY;
        //Goes East
        car.turnRight(); //direction = 1
        car.move();
        double moveX = car.getX();
        result = currentX < moveX;
        reportResult("Moving To East", result);
        currentX = moveX;
        //Goes South
        car.turnRight(); // direction = 2
        car.move();
        moveY = car.getY();
        result = currentY > moveY;
        reportResult("Moving To South", result);
        //Goes West
        car.turnRight(); // direction = 3
        car.move();
        moveX = car.getX();
        result = currentX > moveX;
        reportResult("Moving To West", result);
    }





    static void main() {
        testTurbo();
        testGas();
        testBrake();
        testTurnRight();
        testTurnLeft();
        moveTest();
        //TODO: add and run more tests
    }
}