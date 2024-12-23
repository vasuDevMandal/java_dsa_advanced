package dsa_practice.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
//        List<List<Integer>> outer = new ArrayList<>();
//        outer.add(new ArrayList<>());
//        System.out.println(outer.get(0));
//
//        int[] arr = {1,2,3};
//        List<List<Integer>> ans = subset(arr);
//        System.out.println( ans);

        int[] arr2 = {1,2,2,2};
        List<List<Integer>> ans3 = subsetDuplicate(arr2);
        System.out.println( ans3);

    }

    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());//add 1 empty list on index 0
        for(int num:arr){
            int outerListSize = outer.size();
            for (int i = 0; i < outerListSize; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }


    static List<List<Integer>> subsetDuplicate(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());//add 1 empty list on index 0
        int start = 0;
        int end = 0;
        for(int i = 0; i < arr.length ; i++){
            start = 0;
            //if current and previous element is same, s = e + 1
            if(i>0 && arr[i]==arr[i-1]){
                start = end +1;
            }
            end = outer.size() - 1;
            int outerListSize = outer.size();
            for (int j = start; j < outerListSize; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
