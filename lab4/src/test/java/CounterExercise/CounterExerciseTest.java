package CounterExercise;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doReturn;

public class CounterExerciseTest {

    CounterExercise counter = new CounterExercise();

    @Test
    public void thisShallBeZero(){
        Assert.assertEquals(0,counter.getValue());
    }

    @Test
    public void thisShallBeHundred(){
        counter.addvalue(1000);
        Assert.assertEquals(100,counter.getValue());
    }

    @Test
    public void thisShallReturnZero() {
        counter.addvalue(-20);
        Assert.assertEquals(0, counter.getValue());
    }

    @Test
    public void thisShallBeEqua100And0(){
        counter.setValue(2500);
        Assert.assertEquals(100,counter.getValue());
        counter.setValue(-1000);
        Assert.assertEquals(0,counter.getValue());
    }

    @Test
    public void thisShallReturn12(){
        CounterExercise counterExercise = Mockito.mock(CounterExercise.class);
        doReturn(12).when(counterExercise).getValue();
        Assert.assertEquals(12,counterExercise.getValue());
    }
}
