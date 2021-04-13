package multiplyCounter;

import CounterExercise.CounterExercise;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.doReturn;

public class MultiplyCounterTest {

    @Mock
    CounterExercise ce = new CounterExercise();
    MultiplyCounter mc = new MultiplyCounter();

    @Test
    public void thisShallReturn0(){
        mc.multiply(ce,123123123);
        Assert.assertEquals(0,mc.getValue());
    }

    @Test
    public void voidThisShallReturn40(){
        ce.addvalue(20);
        mc.multiply(ce,2);
        Assert.assertEquals(40,mc.getValue());
    }

    @Test
    public void thisShallReturnminus40(){
        ce.addvalue(20);
        mc.multiply(ce,-2);
        Assert.assertEquals(-40,mc.getValue());
    }

    @Test
    public void thisShallReturn12(){
        CounterExercise counterExercise = Mockito.mock(CounterExercise.class);
        doReturn(12).when(counterExercise).getValue();
        mc.multiply(counterExercise,10);
        Assert.assertEquals(12,counterExercise.getValue());
    }
}
