import javax.swing.*;
import java.util.Random;

public class ObstacleRoad {
    public static void main(String[] args) {
        Random generator = new Random();
        IBody[] bodies = new IBody[3];

        int distance = generator.nextInt(20000);
        int height = generator.nextInt(3000);
        bodies[0] = new Human("Human1", distance, height);

        distance = generator.nextInt(10000);
        height = generator.nextInt(5000);
        bodies[1] = new Cat("Cat1", distance, height);

        distance = generator.nextInt(28000);
        height = generator.nextInt(2000);
        bodies[2] = new MrRobot("Robot1", distance, height);


        Obstacle[] obstacles = new Obstacle[5];

        boolean isRun;
        int max = 8000;

        for (int i=0;i< obstacles.length; i++) {
            distance = (int)(Math.random() * ++max) + 2000;
            isRun = generator.nextBoolean();

            if (isRun) {
                obstacles[i] = new Treadmill("Treadmill " + i, distance);
            } else {
                obstacles[i] = new TheWall("The Wall " + i, distance);
            }
        }

        for (int i = 0; i < bodies.length; i++) {
            boolean result = true;
            for (int j = 0; j < obstacles.length; j++) {
                //result = obstacles[i].moving(bodies[i]);
                result = obstacles[j].moving(bodies[i]);

                if (!result) {
                    break;
                }
            }
            if (result) {
                System.out.println("Success!");
                System.out.println("------------------");
            } else {
                System.out.println("Unsuccessfully!");
                System.out.println("-------------------");
            }
        }
    }
}
