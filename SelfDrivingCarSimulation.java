public class SelfDrivingCarSimulation {

    // Car class representing a self-driving car
    public static class Car {
        private double x;      // Car's x position
        private double y;      // Car's y position
        private double angle;  // Car's current orientation (in degrees)
        private double speed;  // Car's speed (m/s)

        public Car(double x, double y, double angle, double speed) {
            this.x = x;
            this.y = y;
            this.angle = angle;
            this.speed = speed;
        }

        // Move the car in the current direction
        public void move(double deltaTime) {
            x += speed * Math.cos(Math.toRadians(angle)) * deltaTime;
            y += speed * Math.sin(Math.toRadians(angle)) * deltaTime;
        }

        // Update the car's orientation
        public void turn(double deltaAngle) {
            angle += deltaAngle;
        }

        // Set the car's speed
        public void setSpeed(double newSpeed) {
            this.speed = newSpeed;
        }

        // Get the car's current position
        public String getPosition() {
            return String.format("Position: (%.2f, %.2f)", x, y);
        }

        // Get the car's current speed
        public String getSpeed() {
            return String.format("Speed: %.2f m/s", speed);
        }

        // Get the car's current direction
        public String getAngle() {
            return String.format("Angle: %.2f degrees", angle);
        }
    }

    // Sensor class to simulate obstacle detection
    public static class Sensor {
        // Simulate the detection of an obstacle by distance in meters
        public double detectObstacle(double carX, double carY, double angle) {
            // For simplicity, we'll return a random value representing distance to an obstacle
            return Math.random() * 100;  // Distance between 0 and 100 meters
        }
    }

    // PathPlanner class to calculate the next direction towards a target
    public static class PathPlanner {
        private double targetX, targetY;

        public PathPlanner(double targetX, double targetY) {
            this.targetX = targetX;
            this.targetY = targetY;
        }

        // Simple algorithm to get the next direction towards the target
        public double calculateSteeringAngle(double carX, double carY, double carAngle) {
            double angleToTarget = Math.toDegrees(Math.atan2(targetY - carY, targetX - carX));
            double steeringAngle = angleToTarget - carAngle;

            // Normalize the steering angle to between -180 and 180 degrees
            if (steeringAngle > 180) {
                steeringAngle -= 360;
            } else if (steeringAngle < -180) {
                steeringAngle += 360;
            }

            return steeringAngle;
        }
    }

    // Main simulation class
    public static void main(String[] args) {
        // Create the car, sensor, and path planner
        Car car = new Car(0, 0, 0, 10);  // Start at (0, 0), facing 0 degrees (east), moving at 10 m/s
        Sensor sensor = new Sensor();
        PathPlanner pathPlanner = new PathPlanner(100, 100);  // Target is at (100, 100)

        // Simulate for 100 seconds
        for (int t = 0; t < 100; t++) {
            // Check for obstacles using the sensor
            double obstacleDistance = sensor.detectObstacle(car.x, car.y, car.angle);
            System.out.println("Obstacle Distance: " + obstacleDistance + " meters");

            // If obstacle is too close, stop the car (this is very simplified logic)
            if (obstacleDistance < 5) {
                System.out.println("Obstacle detected! Stopping the car.");
                car.setSpeed(0);
            } else {
                // Calculate the steering angle towards the target
                double steeringAngle = pathPlanner.calculateSteeringAngle(car.x, car.y, car.angle);
                car.turn(steeringAngle);  // Adjust car's direction
                car.setSpeed(10);  // Maintain speed
            }

            // Move the car
            car.move(1);  // Move the car for 1 second

            // Output car status
            System.out.println(car.getPosition() + " | " + car.getSpeed() + " | " + car.getAngle());
        }
    }
}

