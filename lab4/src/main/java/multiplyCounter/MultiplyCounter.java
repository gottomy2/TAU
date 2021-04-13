package multiplyCounter;

import CounterExercise.CounterExercise;

public class MultiplyCounter {
    private int value;

    public MultiplyCounter(){
        this.value=0;
    }

    public void multiply(CounterExercise ce, int multiplyer){
        value = ce.getValue()*multiplyer;
    }

    public int getValue() {
        return value;
    }
}
