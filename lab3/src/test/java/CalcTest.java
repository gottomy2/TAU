import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CalcTest {
    private Calc calc;

    @BeforeEach
    public void setUp(){
        calc = new Calc();
    }

    @AfterEach
    public void tearDown(){
        calc = null;
    }

    @Test
    public void calcTest(){
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int sum = calc.sum(array);
        Assertions.assertEquals(55,sum);
    }

    @Test
    public void calcTest2(){
        int[] array = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
        int sum = calc.sum(array);
        Assertions.assertEquals(-55,sum);
    }

    @Test
    public void calcTest3(){
        int[] array = {1,2};
        int sum = calc.sum(array);
        Assertions.assertNotNull(sum);
    }

    @Test
    public void calcTest4(){
        int[] array = {50,20,16,123,41,29};
        try{
            calc.sum(array);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void calcTest5(){
        int[] array = {-50,20,30,8};
        int sum = calc.sum(array);
        Assertions.assertTrue(sum != 0);
    }

    @Test
    public void calcTest6(){
        int sum = calc.sum(null);
        Assertions.assertEquals(0,sum);
    }

    @Test
    public void calcTest7(){
        int[] array = {2,4,6,8,10};
        calc.sum(array);
        Assertions.assertTrue(calc.isSumEven());
    }

    @Test
    public void calcTest8(){
        int[] array = {5,6,6};
        calc.sum(array);
        Assertions.assertFalse(calc.isSumEven());
    }

    @Test
    public void calcTest9(){
        int sum = calc.sum(new int[] {12});
        Assertions.assertNotEquals(20,sum);
    }

    @Test
    public void calcTest10(){
        int sum = calc.sum(new int[] {-100,100});
        Assertions.assertNotSame("0",sum);
    }

    @Test
    public void calcTest11(){
        int mult = calc.mult(10,10);
        Assertions.assertEquals(100,mult);
    }

    @Test
    public void calcTest12(){
        int mult = calc.mult(12,12);
        Assertions.assertEquals(mult % 2, 0);
    }

    @Test
    public void calcTest13(){
        int div = calc.div(100,10);
        Assertions.assertEquals(10,div);
    }

    @Test
    public void calcTest14(){
        int div = calc.div(10,-1);
        Assertions.assertEquals(div / -1, 10);
    }

    @Test
    public void calcTest15(){
        int sub = calc.sub(20,30);
        Assertions.assertTrue(sub < 0);
    }

    @Test
    public void calcTest16(){
        int sub = calc.sub(20,2);
        Assertions.assertEquals(18,sub);
    }

    @Test
    public void calcTest17(){
        int num = (calc.sub(10,9) * calc.mult(5,5));
        Assertions.assertEquals(25,num);
    }

    @Test
    public void calcTest18(){
        calc.setSum(50);
        Assertions.assertEquals(calc.getSum(),50);
    }

    @Test
    public void calcTest19(){
        int[] array = {2,4,6,8,10};
        JSONObject jo = new JSONObject();
        for(int i =0;i<array.length;i++){
            jo.put(Integer.toString(array[i]),i);
        }
        Assertions.assertNotEquals(Arrays.toString(array),jo.toString());
    }

    @Test
    public void calcTest20(){
        int[] array = {2,4,6,8,10};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<array.length;i++){
            map.put(array[i],i);
        }
        JSONObject jo = new JSONObject(map);
        System.out.println(jo);
        Assertions.assertTrue(jo.length() == 5);
    }
}