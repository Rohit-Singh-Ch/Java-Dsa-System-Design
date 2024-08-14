package Pattern;

public class Pattern {
    public static void main(String[] args) {
        pattern1(5);
    }

    /**
     *   *
     *   **
     *   ***
     *   ****
     *   *****
     */
    public static void pattern1(int n){
        int i=1;
        while (i<=n){
            int j=1;
            while (j<=i){
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
