package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subset(arr));

        int[] arr2 = {1,2,3,2};
        System.out.println(subsetDuplicates(arr2));
    }

    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());
        for(int num : arr){
            int n = outerList.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internalList = new ArrayList<>(outerList.get(i));
                internalList.add(num);
                outerList.add(internalList);
            }
        }
        return outerList;
    }

    //for array with duplicates
    static List<List<Integer>> subsetDuplicates(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());

        int start = 0;
        int end = 0;

        for(int i = 0; i < arr.length; i++){
            start = 0;
            //if previous and current element is same, s = e + 1
            if(i > 0 && arr[i] == arr[i-1]){
                start = end + 1;
            }
            end = outerList.size() - 1;
            int n = outerList.size();
            for (int j = start; j < n; j++) {
                List<Integer> internalList = new ArrayList<>(outerList.get(j));
                internalList.add(arr[i]);
                outerList.add(internalList);
            }
        }
        return outerList;
    }
}
