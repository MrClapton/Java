public class Dog extends Animal {

    //поля класса
    protected int RunningLimit;
    protected float JumpingLimit;
    protected int SwimmingLimit;

    //конструктор класса
    public Dog(int RunningLimit, float JumpingLimit, int SwimmingLimit) {
        this.RunningLimit = RunningLimit;
        this.JumpingLimit = JumpingLimit;
        this.SwimmingLimit = SwimmingLimit;
    }

    //методы класса, которые переопределяют методы родительского класса
    @Override
    void run(int RunningObstacle) {
        System.out.println("RunningObstacle to dog1 = " + RunningObstacle);
        System.out.println("RunningLimit to dog1 = " + this.RunningLimit);
        String result = (RunningObstacle <= this.RunningLimit) ? "Dog run: true!" : "Dog run: false!";
        System.out.println(result);
        System.out.println();
    }

    @Override
    void jump(float JumpingObstacle) {
        System.out.println("JumpingObstacle to dog1 = " + JumpingObstacle);
        System.out.println("JumpingLimit to dog1 = " + this.JumpingLimit);
        String result = (JumpingObstacle <= this.JumpingLimit) ? "Dog jump: true!" : "Dog jump: false!";
        System.out.println(result);
        System.out.println();
    }

    @Override
    void swim(int SwimmingObstacle) {
        System.out.println("SwimmingObstacle to dog1 = " + SwimmingObstacle);
        System.out.println("SwimmingLimit to dog1 = " + this.SwimmingLimit);
        String result = (SwimmingObstacle <= this.SwimmingLimit) ? "Dog swim: true!" : "Dog swim: false!";
        System.out.println(result);
        System.out.println();
    }
}