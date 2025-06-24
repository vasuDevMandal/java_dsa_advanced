package Recursion;

public class ArraySorted {
    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 8, 9, 10};
        System.out.println(sorted(arr,0));
    }

//    find if array is sorted or not
    static boolean sorted(int[] arr, int index){

        if(index == arr.length-1){
            return true;
        }
        return arr[index] < arr[index+1] && sorted(arr, index+1);
    }
}
