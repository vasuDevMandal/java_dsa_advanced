package dsa_practice.questions;
//https://youtu.be/fzip9Aml6og?list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&t=2122
public class OddEven {

    public static void main(String[] args) {
        int num = 111;
        System.out.println("is odd: " + isOdd(num));
    }

   static boolean isOdd(int num){
        return ((num & 1) == 1);
    }



}
