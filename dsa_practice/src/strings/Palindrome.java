package strings;

import java.util.Objects;

public class Palindrome {
    public static void main(String[] args) {
        String str = null;
        System.out.println(isPalindrome(str));
    }

    static boolean isPalindrome(String str){
        if(Objects.equals(str, "") || str == null){
            return false;
        }
        char[] arr = str.toCharArray();
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            if(arr[start] == arr[end]){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}
