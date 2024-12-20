package dsa_practice.questions;

public class FindRightMostSetBit {
    public static void main(String[] args) {
        int val = 0b100100;

        int ans = findRMSetBit(val);

        System.out.println("ans: "+ ans);
    }

    static int findRMSetBit(int n){
        int position = 1;
        while ((n & 1) == 0) {
            n = n >> 1;
            position++;
        }
        return position;
    }
}
