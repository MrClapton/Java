import java.util.Random;

public class Human implements IBody {
    private String name;
    private int JumpHeight, LengthDistance;

    public Human(String name, int distance, int height) {
        this.name = name;
        this.JumpHeight = height;
        this.LengthDistance = distance;
    }

    @Override
    public void run() {
        System.out.println("Human " + this.name + " is running " + this.getRunDistance());
    }

    @Override
    public void jump() {
        System.out.println("Human " + this.name + " is jumping " + this.getJumpHeight());
    }

    @Override
    public int getRunDistance() {
        return this.LengthDistance;
    }

    public int getJumpHeight() {
        return this.JumpHeight;
    }


}
