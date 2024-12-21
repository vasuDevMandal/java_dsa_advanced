package dsa_practice.questions;

public class RecursionPatternTriangle {

    public static void main(String[] args) {

        triangle2(5,0);
    }

    static void triangle1(int row, int col){
    //bottom up - top down
        if(row == 0){
            return;
        }

        if(col < row){
            System.out.print("* ");
            triangle1(row, col +1);
        }else{
            System.out.println();
            triangle1(row - 1, 0 );
        }
    }


    static void triangle2(int row, int col){
        //top up - bottom down
        if(row == 0){
            return;
        }

        if(col < row){
            triangle2(row, col +1);
            System.out.print("* ");
        }else{
            triangle2(row - 1, 0 );
            System.out.println();
        }
    }

}
