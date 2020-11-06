import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    /*||Fields||*/
    private final Semaphore semaphore;

    /*||Constructor||*/
    Tunnel() {
        semaphore = new Semaphore(MainClass.COUNT_OF_CARS / 2);
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    /*||Overridden method go||*/
    @Override
    public void go(Car c) {
        /*try {*/
        try {
            System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
            semaphore.acquire();//заезд в тоннель
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(c.getName() + " закончил этап: " + description);
            semaphore.release();//выезд из тоннеля
        }
       /* } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}


/*
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore smp;
    public Tunnel(int maxCars) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        smp = new Semaphore(maxCars);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smp.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/
