package Recursion;

public class ReverseNumber {
    public static void main(String[] args) {

        System.out.println(reverse(12345));

    }


    static int reverse(int n){
        int digits = (int)Math.log10(n) + 1;//for 100 it's 2, so +1
        return helper(n,digits);
    }
    static int helper(int n, int digits){

        if(n%10 == n){
            return n;
        }

        int rem = n % 10;
        return rem * (int)Math.pow(10,digits-1) + helper(n/10, digits-1);
    }
}
