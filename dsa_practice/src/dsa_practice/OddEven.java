package dsa_practice;

public class OddEven {

    public static void main(String[] args) {
        int num = 111;
        System.out.println("is odd: " + isOdd(num));
    }

   static boolean isOdd(int num){
        return ((num & 1) == 1);
    }



}
