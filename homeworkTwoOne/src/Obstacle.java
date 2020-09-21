public abstract class Obstacle {
    private String name;

    public Obstacle(String name) {
        this.name = name;
    }

    protected abstract boolean moving(IBody action);

    public String getName() {
        return name;
    }
}
