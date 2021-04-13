package CounterExercise;

public class CounterExercise {
    private int value;

    public CounterExercise(){
        this.value = 0;
    }

    public void addvalue(int v){
        value += v;
        check(value);
    }

    public void subvalue(int v){
        value -= v;
        check(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        check(value);
    }

    public void check(int value){
        if(value > 100)
            setValue(100);
        if(value < 0)
            setValue(0);
    }
}
