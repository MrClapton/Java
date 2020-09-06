public class Cat extends Animal {

    //поля класса(для кота 2 поля, т.к. не умеет плавать)
    protected int RunningLimit;
    protected float JumpingLimit;

    //конструктор класса
    public Cat(int RunningLimit, float JumpingLimit) {
        this.RunningLimit = RunningLimit;
        this.JumpingLimit = JumpingLimit;
    }

    //методы класса, которые переопределяют методы родительского класса
    @Override
    void run(int RunningObstacle) {
        System.out.println("RunningObstacle to cat1 = " + RunningObstacle);
        System.out.println("RunningLimit to cat1 = " + this.RunningLimit);
        String result = (RunningObstacle <= this.RunningLimit) ? "Cat run: true!" : "Cat run: false!";
        System.out.println(result);
        System.out.println();
    }

    @Override
    void jump(float JumpingObstacle) {
        System.out.println("JumpingObstacle to cat1 = " + JumpingObstacle);
        System.out.println("JumpingLimit to cat1 = " + this.JumpingLimit);
        String result = (JumpingObstacle <= this.JumpingLimit) ? "Cat jump: true!" : "Cat jump: false!";
        System.out.println(result);
        System.out.println();
    }

    @Override
    void swim(int SwimmingObstacle) {
        String result = "Cat swim: false!";
        System.out.println(result);
        System.out.println();
    }
}
