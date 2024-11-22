import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode118 {
    public static void main(String[] args) {
        Solution118 solution = new Solution118();
        int numRows=5;
        List<List<Integer>> pascalTriangle = solution.generatePascalTriangle(numRows);

        //printing the pascal triangle
        for(List<Integer> row: pascalTriangle){
            System.out.println(row);
        }


    }
}


class Solution118 {
    
    //recursion
    public List<List<Integer>> generatePascalTriangle(int numRows) {
        if(numRows==0){
            return new ArrayList<>();
        }
        if(numRows==1){
            List<List<Integer>> result = new ArrayList<>();
            result.add(Arrays.asList(1));
            return result;
        }

        List<List<Integer>> prevRows = generatePascalTriangle(numRows-1);
        List<Integer> newRow = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            newRow.add(1);
        }
        for(int i=1;i<numRows-1;i++){
            newRow.set(i,prevRows.get(numRows-2).get(i-1)+prevRows.get(numRows-2).get(i));
        }
        prevRows.add(newRow);
        return prevRows;
    }
}




