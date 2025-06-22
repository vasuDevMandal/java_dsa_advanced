package Recursion;

public class NumOfStepsToZero {
    public static void main(String[] args) {
        System.out.println(steps(2));
    }

    static int steps(int n){
        return helper(n,0);
    }

    static int helper(int n, int steps){
        if(n==0){
            return steps;
        }

        if(n%2 == 0){
            return helper(n/2, steps+1);
        }

        return helper(n-1,steps+1);
    }
}
