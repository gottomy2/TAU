package zad1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SumTest {
    private Sum sumT;

    @BeforeEach
    public void setUp(){
        sumT = new Sum();
    }

    @AfterEach
    public void tearDown(){
        sumT = null;
    }

    @Test
    public void sumTest(){
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int sum = sumT.sum(array);
        Assertions.assertEquals(55,sum);
    }

    @Test
    public void sumTest2(){
        int[] array = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
        int sum = sumT.sum(array);
        Assertions.assertEquals(-55,sum);
    }

    @Test
    public void sumTest3(){
        int[] array = {1,2};
        int sum = sumT.sum(array);
        Assertions.assertNotNull(sum);
    }

    @Test
    public void sumTest4(){
        int[] array = {50,20,16,123,41,29};
        try{
            sumT.sum(array);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void sumTest5(){
        int[] array = {-50,20,30,8};
        sumT.sum(array);
        Assertions.assertTrue(sumT.sumIsSet);
    }

    @Test
    public void sumTest6(){
        int sum = sumT.sum(null);
        Assertions.assertEquals(0,sum);
    }

    @Test
    public void sumTest7(){
        int[] array = {2,4,6,8,10};
        sumT.sum(array);
        Assertions.assertTrue(sumT.isSumEven());
    }

    @Test
    public void sumTest8(){
        int[] array = {5,6,6};
        sumT.sum(array);
        Assertions.assertFalse(sumT.isSumEven());
    }

    @Test
    public void sumTest9(){
        int sum =sumT.sum(new int[] {12});
        Assertions.assertNotEquals(20,sum);
    }

    @Test
    public void sumTest10(){
        int sum = sumT.sum(new int[] {-100,100});
        Assertions.assertNotSame("0",sum);
    }
}