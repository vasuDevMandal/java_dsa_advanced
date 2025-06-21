package Recursion;

public class FibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(fibo(3));
    }

//    prints the nth fibonacci number
    static int fibo(int n){
        if(n < 2){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
}
