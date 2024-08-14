package array;

public class findMaxSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,-5,2,3,-6,1,2,3,0,4,5,-6,7,1};
//        System.out.println(maxSubArray(arr, arr.length));
        System.out.println(maxSubArrayInMul(arr, arr.length));
    }

    /*
     * given and array which have +ve and -ve values.find sub-array with max sum possible.
     * {-1,-5,2,3,-6,1,2,3,0,4,5,-6,7,1}
     * */
    private static int maxSubArrayInMul(int[] arr, int n) {
        int max_so_far=0, pos_val=0, neg_val=0;
        for (int i=0; i<n; i++){
            pos_val = (pos_val != 0) ? pos_val * arr[i] : arr[i];
            neg_val = (neg_val != 0) ? neg_val * arr[i] : arr[i];

            if(neg_val > 0) {
                pos_val = neg_val;
                neg_val = neg_val * -1;
            }
            if( pos_val > max_so_far) max_so_far = pos_val;
        }
        return max_so_far;
    }

    /*
    * given and array which have +ve and -ve values.find sub-array with max sum possible.
    * {2,3,-6,4,1,5,-1,2,3,-8,-9,3}
    * */
    private static int maxSubArray(int[] arr, int n) {
        int max_so_far=0, curr_val=0, start=-1,end=-1;
        for (int i=0; i<n ;i++){
            curr_val += arr[i];

            if (max_so_far < curr_val){
                max_so_far = curr_val;
//                start = n -i +1;
//                end=i;
            }

            if(curr_val < 0) {
                curr_val = 0;
            }
        }
        System.out.println("start-index "+ start + " endIndex " + end);
        return max_so_far;
    }
}
