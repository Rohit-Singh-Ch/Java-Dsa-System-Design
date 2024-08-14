package array;

import java.util.Arrays;

public class SmallestDifference {
    public static void main(String[] args) {
        int[] a = {-1,5,10,20,28,3};
        int[] b = {26,134,135,15,17};
        System.out.println(smallestDiff(a,b));
    }

    /**
     * X3 = Y5  return smallest difference which is 0
     * X3 < Y5, X1, X2 is smaller than X3 diff X3 - Y5 move X3 to X4
     * X3 < Y5  Y6, Y7 is greater than Y5 diff Y5 - X3 move Y5 to Y6
     * time - O(nlog(n) + mlog(m))
     * @param a
     * @param b
     * @return
     */
    private static int smallestDiff(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int left = 0;
        int right = 0;
        int minValue;
        int maxValue;
        int smallDiff = Integer.MAX_VALUE;
        while (left<a.length && right<b.length){
            int currentDiff = Integer.MAX_VALUE;
            minValue = a[left];
            maxValue = b[right];
            if (a[left] == b[right]) return 0;
            if(a[left] < b[right]){
                currentDiff = b[right] - a[left];
                left++;
            }
            else if(a[left] > b[right]){
                currentDiff = a[left] - b[right];
                right ++;
            }
            if(currentDiff < smallDiff) smallDiff = currentDiff;
            System.out.printf("%d %d %d\n", minValue, maxValue, smallDiff);
        }
        return smallDiff;
    }
}
