package array;

import java.util.*;

public class FourNumberSum {
    public static void main(String[] args) {
        int[] array = {7,6,4,-1,1,2};
        int target = 16;
        int[][] result = fourNumberSum(array, target);
        for (int i=0; i<result.length ;i++){
            for (int i1 : result[i]) {
                System.out.println(i1);
            }
        }
    }

    /**
     * we have find the P + Q = target (P=x+y, Q=z+k) then we are going to check Q = target - P => Q = target - (x+y) here,
     * x fixed and moved ahead after x and keep on adding to check is present in HashTable or not if present then
     * add to the result [Q, x, y], if not present then move ahead after reaches last element then iterate before x value and add
     * to the hashtable  value (key, value) => (x+Y), [y,x]
     * @param array
     * @param target
     * @return
     */
    private static int[][] fourNumberSum(int[] array, int target) {
        Map<Integer,List<List<Integer>>> auxArray = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i =1; i< array.length-1; i++){
            //traversing to find Q and generate P = x+y
            for (int j=i+1; j<array.length; j++){
                int x = array[i];
                int y = array[j];
                int currentSum = x + y; //P
                int difference = target - currentSum;
                 if(auxArray.containsKey(difference)){
                     auxArray.get(difference).forEach(e -> {
                         List<Integer> temp = new ArrayList<>();
                         temp.addAll(e); temp.add(x); temp.add(y);
                         result.addAll(Collections.singleton(temp));
                     });
                 }
            }

            //traverse before i and generate Q(hashMap)
            for (int k=0; k<i; k++){
                int currentSum = array[i] + array[k];
                List<Integer> temp = new ArrayList<>();
                temp.add(array[k]);
                temp.add(array[i]);
                auxArray.put(currentSum, Collections.singletonList(temp));
            }
        }
       // result.stream().forEach(System.out::println);
        return result.stream().map(e -> e.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}
