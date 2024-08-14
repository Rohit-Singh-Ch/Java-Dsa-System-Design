package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpringTraverse {
    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},
                        {12,13,14,5},
                        {11,16,15,6},
                        {10,9,8,7}};
        int[] result = spiralTraverseByRecursive(array);
//        for (int i=0;i<4;i++){
//            for (int j=0;j<4;j++){
//                System.out.print(array[i][j] + " ");
//            }
//            System.out.println();
//        }
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] spiralTraverseByRecursive(int[][] array) {
        List<Integer> result = new ArrayList<>();
        int startRow = 0, startCol = 0;
        int endRow = array.length-1;
        int endCol = array[0].length-1;
        recursiveTraverse(array, startRow, endRow, startCol, endCol, result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void recursiveTraverse(int[][] array, int startRow, int endRow, int startCol, int endCol, List<Integer> result) {
        if (startRow <= endRow && startCol <= endCol){
            for (int col=startCol; col<=endCol; col++) result.add(array[startRow][col]);
            for (int row=startRow+1; row<=endRow; row++) result.add(array[row][endCol]);
            for (int col=endCol-1; col>=startCol; col--) result.add(array[endRow][col]);
            for (int row=endRow-1; row>startRow; row--) result.add(array[row][startCol]);

            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
    }

    private static int[] spiralTraverse(int[][] array) {
        List<Integer> result = new ArrayList<>();
        int startRow = 0, startCol = 0;
        int endRow = array.length-1;
        int endCol = array[0].length-1;

        while (startRow <= endRow && startCol <= endCol){
            for (int col=startCol; col<=endCol; col++) result.add(array[startRow][col]);
            for (int row=startRow+1; row<=endRow; row++) result.add(array[row][endCol]);
            for (int col=endCol-1; col>=startCol; col--) result.add(array[endRow][col]);
            for (int row=endRow-1; row>startRow; row--) result.add(array[row][startCol]);

            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }


}
