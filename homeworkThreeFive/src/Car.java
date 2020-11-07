import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {

    /*||Fields(1.static,2.static init,3.private)||*/
   /*1.*/ private static int COUNT_OF_CARS;
    private static final AtomicInteger pos;

  /*2.*/  static {
        COUNT_OF_CARS = 0;
        pos = new AtomicInteger(0);
    }
    /*3.*/
    private Race race;
    private int speed;
    private String name;
    private final CyclicBarrier barrier;

    /*||Getters||*/
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    /*||Constructor||*/
    public Car(Race race, int speed, CyclicBarrier barrier) {
        this.race = race;
        this.speed = speed;
        COUNT_OF_CARS++;
        this.name = "Участник № " + COUNT_OF_CARS;
        this.barrier = barrier;
    }

    /*||Overridden method RUN||*/
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            barrier.await();                                // Ждем готовности всех машин
            barrier.await();                                // Ждем зеленого сигнала - сообщения о старте гонки
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            if (pos.addAndGet(1) == 1) {          // Выигрывает машина, первая дошедшая до этого блока
                System.out.printf("%s WIN THE RACE!!!\n", this.getName());
            }
            barrier.await();                                // Ждем других гонщиков
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/*
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static CyclicBarrier cb;

    public static void setCb(CyclicBarrier cb) {
        Car.cb = cb;
    }

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        //System.out.println(this.name + " " + this.race + " " + this.speed);
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
    }
}

class StartMessage implements Runnable {
    @Override
    public void run() {
        System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка началась!!!");
    }
}


*/
