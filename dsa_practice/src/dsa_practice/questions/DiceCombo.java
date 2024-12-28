package dsa_practice.questions;
//https://www.youtube.com/watch?v=9ByWqPzfXDU&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=34
public class DiceCombo {

    public static void main(String[] args) {
        dice("",4);
    }

    static void dice(String p , int target){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i <= target  ; i++) {
            dice(p+i,target-i);
        }
    }
}
