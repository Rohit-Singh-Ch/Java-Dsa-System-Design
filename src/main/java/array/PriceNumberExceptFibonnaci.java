package array;

public class PriceNumberExceptFibonnaci {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int result;
        for (int i=2; i<=100; i++){
            result = a + b;
            if(result == i){
                a = b;
                b = result;
                continue;
            }
            System.out.println(i);
        }
    }
}

//0 1 1 2 3 5 8 13