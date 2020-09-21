import java.util.Random;

public class Treadmill extends Obstacle{
   private int length;

   public Treadmill(String name, int length) {
      super(name);
      this.length = length;
   }

    public int getLength() {
        return length;
    }

    @Override
    protected boolean moving(IBody actions) {
        System.out.println("Treadmill " + super.getName() + " length: " + this.length);

        actions.run();

        if(getLength() <= actions.getRunDistance()) {
            System.out.println("Run success!");
            return true;
        } else {
            System.out.println("Unsuccessful run");
            return false;
        }
    }
}
