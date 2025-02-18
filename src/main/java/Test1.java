import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int n = -10;
        int[] arr = new int[]{-10,-15,-1,-16,-8};
//        System.out.println(factorial(n));
        System.out.println(secondLagest(arr));
    }

    private static int factorial(int n) {
        if(n <=0){
            return 1;
        }
         return n * factorial(n-1);
    }

    private static int secondLagest(int[] arr){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int val : arr) {
            if(val > max){
                secondMax = max;
                max = val;
            }else if(val > secondMax && val != max){
                secondMax = val;
            }
        }
        return secondMax;
    }
}

//arr[] = second largest element;

