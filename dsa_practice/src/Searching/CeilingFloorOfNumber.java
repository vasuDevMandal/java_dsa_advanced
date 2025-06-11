package Searching;

public class CeilingFloorOfNumber {
//    ceiling = smallest element in array that is greater than or = target
//floor = greatest number smaller or equal to target
    public static void main(String[] args) {
        int[] arr = {2,4,6,7,9,8,98};

        System.out.println(ceiling(arr, 99));
        System.out.println(floor(arr, 2));
    }

    static int ceiling(int[] arr, int target){
        if(target > arr[arr.length - 1]){
            return -1;
        }
        int start = 0;
        int end = arr.length -1;

        int mid;
        while (start <= end){

            mid = start + (end -start) /2;

            if(target > arr[mid]){
                start = mid +1;
            } else if( target < arr[mid]){
                end = mid -1;
            }else if (arr[mid] == target){
                return arr[mid];
            }else{
                return arr[mid +1];
            }
        }
        return arr[start];
    }

    static int floor(int[] arr, int target){
        if(target < arr[0]){
            return -1;
        }
        int start = 0;
        int end = arr.length -1;

        int mid;
        while (start <= end){

            mid = start + (end -start) /2;

            if(target > arr[mid]){
                start = mid +1;
            } else if( target < arr[mid]){
                end = mid -1;
            }else if (arr[mid] == target){
                return arr[mid];
            }else{
                return arr[mid +1];
            }
        }
        return arr[end];
    }


}
