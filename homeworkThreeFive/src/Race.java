import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    /*||Fields||*/
    private final ArrayList<Stage> stages;

    /*||Getter||*/
    public ArrayList<Stage> getStages() {
        return stages;
    }

    /*||Constructor||*/
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
