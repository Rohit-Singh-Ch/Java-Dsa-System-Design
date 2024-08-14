package array;

import java.util.Arrays;

public class MoveElementToEnd {
    public static void main(String[] args) {

        int[] array = {2,1,2,2,2,3,4,2};
        int move = 2;

        int[] result = moveToEnd(array, move);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] moveToEnd(int[] array, int move) {

        int i = 0;
        int j = array.length-1;

        while (i<j){
            if(array[j] == move) { // to tackle this situation[1,3,2,2,2,2,2]  move to j till it reach 3
                j--;
                continue;
            }
            if(array[i] == move){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            i++;
        }
        return array;
    }
}
