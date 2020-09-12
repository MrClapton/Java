public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public boolean eat(Plate plate) {
        if (plate.getFood() < this.getAppetite()) {
            System.out.println("There is little food in the bowl - " + plate.getFood() + " | for the cat " + this.getName());
            return false;
        } else {
            plate.decreaseFood(appetite);
            this.setSatiety(true);
            return true;
        }
    }

    public String catInfo() {
       return (this.toString());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                '}';
    }
}
