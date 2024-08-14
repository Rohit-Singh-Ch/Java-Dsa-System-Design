package array;

/**
 * Monotonic array means if an array is in non-increasing or non-decreasing direction
 */
public class MonotonicArray {

    public static void main(String[] args) {
        int[] array = {1,1,1,2,3,3,4,5};
        System.out.println(isMonotonic1(array));
    }

    private static boolean isMonotonic1(int[] array) {

        boolean nonIncreasing = true;
        boolean nonDeceasing = true;
        for (int i=1; i< array.length; i++){
            if(array[i] < array[i-1]) nonDeceasing = false;
            if (array[i] > array[i-1]) nonIncreasing = false;
        }
        if(nonDeceasing || nonIncreasing) return false;
        return true;
    }


    private static boolean isMonotonic(int[] array) {

        if(array.length <= 2) return true;
        int direction = array[1] - array[0];
        for (int i=2; i< array.length; i++){
            if(direction == 0){
                direction = array[i] - array[i-1];
                continue;
            }

            if(isBreakDirection(direction, array[i-1], array[i])) return false;
        }
        return true;
    }

    //direction -ve decrease, +ve increasing
    //direction is -ve then difference should be -ve for decreasing direction
    //direction is +ve then difference should be -ve for increasing direction
    private static boolean isBreakDirection(int direction, int previousElement, int currentElement) {
        int difference = currentElement - previousElement;
        if(direction > 0) return  difference < 0; //direction increasing then for break difference should be increasing
        return difference > 0;
    }


}
