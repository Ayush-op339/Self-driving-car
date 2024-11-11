Self-Driving Car Simulation
This project simulates a basic self-driving car in Java. The car moves towards a target while detecting obstacles and adjusting its path accordingly. It demonstrates fundamental concepts like car movement, sensor simulation, and path planning, and can be extended to incorporate more advanced features like machine learning, advanced math, and visualization.
Features
Car Movement: The car's position and speed are updated based on its orientation and movement logic.
Sensor Simulation: A basic obstacle detection sensor that returns random values simulating distance to obstacles.
Path Planning: The car uses a simple algorithm to calculate and adjust its steering angle to move towards a target (100, 100).
Obstacle Avoidance: If an obstacle is detected too close (less than 5 meters), the car stops.
Logging and Visualization (Optional): Basic logging using SLF4J and Logback, and optional visualization with JFreeChart and TensorFlow integration for future enhancements.
Prerequisites
Java 8 or later: Ensure you have Java 8 or a newer version installed.
Maven: You will need Maven to manage dependencies and build the project.
Future Enhancements
This project can be extended in a number of ways:

Improved Path Planning: Implement algorithms like A*, RRT, or dynamic path planners to handle obstacles and traffic better.
Sensor Integration: Integrate real sensors like LIDAR or cameras, and process sensor data to detect objects and make decisions.
Machine Learning: Use TensorFlow or other libraries to integrate deep learning models for object detection and classification (e.g., pedestrians, traffic signs).
Collision Avoidance: Implement more complex obstacle avoidance techniques, such as lane change and braking.
Visualization: Add real-time visualization of the car's path, environment, and decision-making process using libraries like JFreeChart or JavaFX.
Unit Testing: Write unit tests to validate the logic of the Car, Sensor, and PathPlanner classes.
