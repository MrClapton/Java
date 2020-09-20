import java.util.Random;

public interface IBody {

    //сигнатуры методов, которые отвечают за бег и прыжки участников
    void run();
    void jump();

    int getRunDistance();
    int getJumpHeight();
}
