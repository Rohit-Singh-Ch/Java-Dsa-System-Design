package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static void main(String[] args) {
        int[] array = {12,3,1,2,-6,5,-8,6};
        int target = 0;
        int[][] result = threeNumSum(array, target);
       // System.out.println(result.length);
        for (int i=0; i<result.length ;i++){
            for (int i1 : result[i]) {
                System.out.println(i1);
            }

        }
    }

    /**
     * sort the array then find currentSum = CurrentNum + left + right
     * if currentSum equal to target then move both left and right pointer ahead
     * if currrentSum smaller than target then move left ahead to right
     * if currentSum greater than target then move right ahead to left
     * @param array
     * @param target
     * @return
     */

    private static int[][] threeNumSum(int[] array, int target) {
       List<List<Integer>> result = new ArrayList<>();
       Arrays.sort(array);
        for (int i=0; i< array.length-2; i++){
            int left = i+1;
            int right = array.length-1;

            while (left < right){
                int currentNum = array[i];
                int currentSum = currentNum + array[left] + array[right];
                if(currentSum == target) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(currentNum); temp.add(array[left]); temp.add(array[right]);
                    result.add(temp);
                    left++;
                    right--;
                }
                else if(currentSum < target) left++;
                else right--;
            }
        }
        System.out.println(result);
        return result.stream().map(e -> e.stream().mapToInt(i->i).toArray()).toArray(int[][]::new);
    }
}
