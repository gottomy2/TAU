package zad1;

public class Sum {
    public int sum;
    public boolean sumIsSet;
    public int sum(int[] arr){
        if(arr != null){
            int sum = 0;
            for (int j : arr) {
                sum += j;
            }
            if(sum>60)
                throw new IndexOutOfBoundsException("Throw Exception");

            sumIsSet = true;
            this.sum=sum;
            return sum;
        }
        else{
            sumIsSet = false;
            return 0;
        }
    }

    public boolean isSumEven(){
        if(sum%2==0)
            return true;
        return false;
    }
}
