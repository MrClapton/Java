
public abstract class Stage {
    /*||Fields||*/
     int length;
     String description;

    /*||Getter||*/
    public String getDescription() {
        return description;
    }

    /*||Abstract method||*/
    public abstract void go(Car c);
}
