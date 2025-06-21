package Recursion;

public class SumOfDigits {
    public static void main(String[] args) {

        System.out.println(sum(1236));
    }

    static int sum(int n){
        if(n%10 == n){
            return n;
        }
        int num = n%10;//take last digit
        n = n/10;//reduce n by removing last digit

        return sum(n) + num;
    }
}
