package dsa_practice.questions;

public class CheckArraySortedViaRecursion {
    public static void main(String[] args) {
        int[] arr = { 1,3,0,7,4,6};
        boolean ans = checkSorted(arr,0);
        System.out.println("sorted: " + ans);
    }

    static boolean checkSorted(int[] arr, int index){
        if(index == arr.length -1){
            return true;
        }

        return arr[index] < arr[index+1] && checkSorted(arr,index+1);
    }
}
