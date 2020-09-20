import java.util.Random;

public class TheWall extends Obstacle{
    private int height;

    public TheWall(String name, int height) {
        super(name);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    protected boolean moving(IBody actions) {
        System.out.println("Wall " + super.getName() + " height: " + this.height);

        actions.jump();

        if (getHeight() <= actions.getJumpHeight()) {
            System.out.println("Jump success!");
            return true;
        } else {
            System.out.println("Unsuccessful jump");
            return false;
        }
    }
}
