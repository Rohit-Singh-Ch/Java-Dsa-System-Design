package array;

public class LongestPeak {

    public static void main(String[] args) {
      int[] array = {1,2,3,3,4,0,10,6,5,-1,-3,2,3};

      int longestPeak = longestPeak(array);
        System.out.println(longestPeak);
    }

    /**
     * first find the peak of the element by comparing left and right element
     * after fond peak element compare separately left and then right index
     * then initialize the cursor i with right element cause no peak element present until right index
     * time - o(n), space - n(1)
     * @param array
     * @return
     */
    private static int longestPeak(int[] array) {
        int longestPeak = 0;
        int i = 1;
        while (i< array.length-1) {
            boolean isPeak = array[i-1] < array[i] && array[i] > array[i+1];
            if(!isPeak) {
                i++;
                continue;
            }
            int leftIndex = i-1;
            while (leftIndex > 0 && array[leftIndex] > array[leftIndex-1]){
                leftIndex--;
            }
            int rightIndex = i+1;
            while (rightIndex < array.length && array[rightIndex] > array[rightIndex+1]){
                rightIndex++;
            }
            int currentLength = rightIndex - leftIndex + 1;
            longestPeak = Math.max(currentLength, longestPeak);
            i = rightIndex + 1;
        }
        return longestPeak;
    }
}
