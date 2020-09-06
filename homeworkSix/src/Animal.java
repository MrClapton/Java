//абстрактный класс "Животное", от которого будет происходить наследование
public abstract class Animal {

    public Animal() {
    }

    abstract void run(int RunningObstacle);
    abstract void jump(float JumpingObstacle);
    abstract void swim(int SwimmingObstacle);
}

