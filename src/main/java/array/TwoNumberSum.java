package array;

import java.util.Arrays;
import java.util.HashSet;

public class TwoNumberSum {
    public static void main(String[] args) {
       int[] array = {-4,5,11,1,-1,8,6,3};
       int target = 10;
        int[] twoNumberSum1 = findTowNumberSum1(array, target);
        int[] twoNumberSum2 = findTowNumberSum2(array, target);
        int[] twoNumberSum3 = findTowNumberSum3(array, target);
        Arrays.stream(twoNumberSum3).forEach(System.out::println);
    }

    /**
     * Bruteforce approach simpple using 2 loops
     * time- o(n2) space- o(1)
     * @param array
     * @param target
     * @return
     */
    private static int[] findTowNumberSum1(int[] array, int target) {
        for (int i=0; i<array.length ; i++){
            int firstElement = array[i];
            for (int j=i+1 ; j<array.length ; j++){
                if( firstElement + array[j] == target){
                    return new int[]{firstElement, array[j]};
                }
            }
        }
        return new int[0];
    }

    /**
     * 2nd approach using Hashing
     * x+y=target -> y=target-x if y present in hashtable then the element will be [x,y], if no then store x in hashtable
     * time- O(n) space- O(n)
     * @param array
     * @param target
     * @return
     */
    private static int[] findTowNumberSum2(int[] array, int target) {
        HashSet<Integer> nums = new HashSet<>();
        for (int i=0; i<array.length; i++){
            int element = target - array[i];
            if(nums.contains(element))
                return new int[]{element, array[i]};
            nums.add(array[i]);
        }
        return new int[0];
    }

    /**
     * 3rd approach Using 2 pointers ahead
     * 1st sort the array after make left pointer in the initial element of array and right pointer in the last element of the array then
     * add first element and 2nd element if is equal to target element then return or if less than target element move to left
     * pointer ahead to right side if is greater than then move right pointer to left side
     * time - O(nlog(n)) space-O(1)
     * @param array
     * @param target
     * @return
     */
    private static int[] findTowNumberSum3(int[] array, int target) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length-1;
        while (left < right){
            int num = array[left] + array[right];
            if(num == target)
                return new int[]{array[left], array[right]};
            else if(num < target)
                left++;
            else
                right--;
        }
        return new int[0];
    }
}
