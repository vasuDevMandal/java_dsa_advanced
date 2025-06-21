package Recursion;

public class Nto1 {

    public static void main(String[] args) {

        nto1Rev(5);
    }

    static void nto1(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        nto1(n-1);
    }

    static void nto1Rev(int n){
        if(n==0){
            return;
        }

        nto1Rev(n-1);
        System.out.println(n);
    }
}
