package dsa_practice.questions;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(3,3));
    }

    static int count(int r, int c){
        System.out.println("("+ r +","+ c +")");
        if(r==1 || c==1){
            return 1;
        }
        int right = count(r,c-1 );
        int left = count(r-1, c);

        return right + left;
    }
}
