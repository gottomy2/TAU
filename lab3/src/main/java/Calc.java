import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Calc {
    private int sum;

    public int sum(int[] arr){
        if(arr != null){
            int sum = 0;
            for (int j : arr) {
                sum += j;
            }
            if(sum>60)
                throw new IndexOutOfBoundsException("Throw Exception");
            this.sum=sum;
            return sum;
        }
        else{
            return 0;
        }
    }

    public int mult(int a, int b){
        return a*b;
    }

    public int div(int a, int b){
        return a/b;
    }

    public int sub(int a, int b){
        return a-b;
    }

    public boolean isSumEven(){
        return sum % 2 == 0;
    }
}
