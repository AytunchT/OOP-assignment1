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


    private static void testGas() {
        Saab95 car = new Saab95();
        double currentSpeed = car.getCurrentSpeed();
        car.gas(0.5);
        double increment = car.getCurrentSpeed();
        boolean result = currentSpeed < increment;
        reportResult("Gas is working", result);
    }

    private static void testBrake(){
            Saab95 car = new Saab95();
            double currentSpeed = car.getCurrentSpeed();
            car.gas(0.5);
            double increment = car.getCurrentSpeed();
            car.brake(0.2);
            double decrement = car.getCurrentSpeed();
            boolean result = currentSpeed < decrement & decrement < increment;
            reportResult("brake is working", result);
    }

    private static void testTurnRight(){
        Saab95 car = new Saab95();
        car.turnRight();
        int direction = car.getDirection();
        boolean result = direction == 1;
        reportResult("turning right is working", result);
        }

    private static void testTurnLeft(){
        Saab95 car = new Saab95();
        car.turnLeft();
        int direction = car.getDirection();
        boolean result = direction == 3;
        reportResult("turning left is working", result);
    }


    static void main() {
        testTurbo();
        testGas();
        testBrake();
        testTurnRight();
        testTurnLeft();
        //TODO: add and run more tests
    }
}