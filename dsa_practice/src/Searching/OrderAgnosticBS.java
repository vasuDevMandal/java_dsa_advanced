package Searching;

public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr = {2,4,5,7,8,9};
        int[] arr2 = {9,7,5,4,2,1};

        System.out.println(AgnosticBS(arr2,4));

    }

    static int AgnosticBS(int[] arr, int target){
        int start = 0;
        int end = arr.length -1 ;

//        finding array order
        boolean isAsc = arr[end] > arr[start];

        while(start <= end ){
            int mid = start + (end - start)/2;

            if(arr[mid] == target){
                return mid;
            }
            if(isAsc){
                if(target > arr[mid]){
                    start = mid + 1;
                } else if (target < arr[mid]){
                    end = mid - 1;
                }
            }else{
                if(target < arr[mid]){
                    start = mid + 1;
                } else if (target > arr[mid]){
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
