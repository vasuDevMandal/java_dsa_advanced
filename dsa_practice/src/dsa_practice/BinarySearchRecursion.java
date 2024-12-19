package dsa_practice;

public class BinarySearchRecursion {

    public static void main(String[] args) {

        int[] arr = {-2,0,2,3,6,8,9,13,35,45,67,78,89,90};
        int ans = search(arr,90,0, arr.length-1);
        System.out.println("index: " + ans);
    }

    static int search(int[] arr,int target,int s, int e ){

        if(s>e){
            return -1;
        }

        int m = s + (e - s)/2;

        if(arr[m] == target){
            return m;
        }

        if( arr[m] > target){
            return  search(arr,target, s , m-1);
        }

        return  search(arr,target , m+1, e);


    }
}
