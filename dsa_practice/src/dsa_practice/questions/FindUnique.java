package dsa_practice.questions;

import java.util.Arrays;

public class FindUnique {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,1,3,5};
        unique(arr);
    }

    static void unique(int[] arr){
        int ans=0;

        for (int i = 0; i < arr.length; i++) {
          ans = ans ^ arr[i];
        }
//        for (int ele : arr){
//            ans ^= ele;
//        }

        System.out.println(ans);
    }
}
