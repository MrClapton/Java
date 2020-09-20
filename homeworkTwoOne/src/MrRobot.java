public class MrRobot implements IBody {

    private String name;
    private int JumpHeight, LengthDistance;

    public MrRobot(String name, int distance, int height) {
        this.name = name;
        this.LengthDistance = distance;
        this.JumpHeight = height;
    }

    @Override
    public void run() {
        System.out.println("Robot " + this.name + " is running " + this.getRunDistance());
    }

    @Override
    public void jump() {
        System.out.println("Robot " + this.name + " is jumping " + this.getJumpHeight());
    }

    @Override
    public int getRunDistance() {
        return this.LengthDistance;
    }

    @Override
    public int getJumpHeight() {
        return this.JumpHeight;
    }
}
