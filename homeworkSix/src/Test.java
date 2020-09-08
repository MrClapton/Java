import java.util.Random;

public class Test {
    protected static final int RunningLimitMin = 200;
    protected static final int RunningLimitMax = 1500;
    protected static final float JumpingLimitMin = 0.2f;
    protected static final float JumpingLimitMax = 3.0f;
    protected static final int SwimmingLimitMin = 10;
    protected static final int SwimmingLimitMax = 600;

    public static void main(String[] args) {

        //методы, определяющие лимиты преодоления препятствий для классов Cat и Dog
        CatRandomRun(RunningLimitMin, RunningLimitMax);
        CatRandomJump(JumpingLimitMin, JumpingLimitMax);
        DogRandomRun(RunningLimitMin, RunningLimitMax);
        DogRandomJump(JumpingLimitMin, JumpingLimitMax);
        DogRandomSwim(SwimmingLimitMin, SwimmingLimitMax);

        //создание объектов cat1 и dog1 с полученными лимитами из методов
        Cat cat1 = new Cat(CatRandomRun(RunningLimitMin, RunningLimitMax), CatRandomJump(JumpingLimitMin, JumpingLimitMax));
        Dog dog1 = new Dog(DogRandomRun(RunningLimitMin,RunningLimitMax), DogRandomJump(JumpingLimitMin,JumpingLimitMax), DogRandomSwim(SwimmingLimitMin,SwimmingLimitMax));

        System.out.println("-----------------------------");
        cat1.run(500);
        cat1.swim(200);
        cat1.jump(1.0f);
        System.out.println("-----------------------------");
        dog1.run(450);
        dog1.jump(1.3f);
        dog1.swim(400);
        System.out.println("-----------------------------");
    }

    private static int DogRandomSwim(int SwimmingLimitMin, int SwimmingLimitMax) {
        Random generator = new Random();
        int result = (SwimmingLimitMin + generator.nextInt(SwimmingLimitMax-SwimmingLimitMin));
        return result;
    }

    private static int DogRandomRun(int RunningLimitMin, int RunningLimitMax) {
        Random generator = new Random();
        return (RunningLimitMin + generator.nextInt(RunningLimitMax - RunningLimitMin));
    }

    private static float DogRandomJump(float JumpingLimitMin, float JumpingLimitMax) {
        Random generator = new Random();
        return (JumpingLimitMin + generator.nextFloat()*JumpingLimitMax);
    }


    private static float CatRandomJump(float JumpingLimitMin, float JumpingLimitMax) {
        Random generator = new Random();
        return (JumpingLimitMin + generator.nextFloat()*JumpingLimitMax);
    }

    private static int CatRandomRun(int RunningLimitMin, int RunningLimitMax) {
        Random generator = new Random();
        int result = (RunningLimitMin + generator.nextInt(RunningLimitMax - RunningLimitMin));
        return result;
    }


}