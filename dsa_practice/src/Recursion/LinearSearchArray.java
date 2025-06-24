package Recursion;

import java.util.ArrayList;

public class LinearSearchArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,6,7,8};
        System.out.println(search(arr,0,6));
        System.out.println(findIndex(arr,0,6));

//        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ans = findIndexList(arr,0,6,new ArrayList<>());
        System.out.println(ans);

        ArrayList<Integer> ans2 = findAllIndex(arr,0,6);
        System.out.println(ans2);

    }

//    return list without argument
    static ArrayList<Integer> findAllIndex(int[] arr, int index, int target){

        ArrayList<Integer> list = new ArrayList<>();

        if(index == arr.length -1){
            return list;
        }
        if(target == arr[index]){
            list.add(index);
        }

        ArrayList<Integer> ansFromBelowCalls = findAllIndex(arr,index+1, target);

        list.addAll(ansFromBelowCalls);

        return list;
    }

    static boolean search(int[] arr, int index, int target){

//        if(target == arr[index]){
//            return true;
//        }
        if(index == arr.length -1){
            return false;
        }
        return target == arr[index] || search(arr,index+1, target);
    }

    static int findIndex(int[] arr, int index, int target){
        if(index == arr.length -1){
            return -1;
        }
        if(target == arr[index]){
            return index;
        }else{
            return findIndex(arr,index+1, target);
        }

    }

    static ArrayList<Integer> findIndexList(int[] arr, int index, int target, ArrayList<Integer> list){
        if(index == arr.length -1){
            return list;
        }
        if(target == arr[index]){
            list.add(index);
        }
        return  findIndexList(arr,index+1, target,list);

    }
}
