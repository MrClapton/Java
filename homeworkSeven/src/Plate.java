public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("Amount of food in the bowl: " + food);
    }

    public void decreaseFood(int appetite) {
        this.food -= appetite; // food = food - appetite;
    }


    public void increaseFood(int feedVolume) {
        this.food += feedVolume;
    }
}
