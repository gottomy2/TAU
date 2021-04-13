package processorExercise;

import java.util.Random;

public class Processor {
    private Random rand = new Random();

    public boolean process() {
        return rand.nextInt() % 2 != 0;
    }
}
