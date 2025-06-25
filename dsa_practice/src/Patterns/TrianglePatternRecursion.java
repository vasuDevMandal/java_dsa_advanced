package Patterns;

public class TrianglePatternRecursion {

    public static void main(String[] args) {

        triangle(4,0);
    }

    static void triangle(int row, int col){
        if(row == 0){
            return;
        }
//       if block,  col < row will print entire line,
//        in else, block it will move for next line
        if(col < row){

            triangle(row, col+1);
            System.out.print("*");
        }else{

            triangle(row - 1, 0);
            System.out.println();
        }
    }

    static void triangleDown(int row, int col){
        if(row == 0){
            return;
        }
        if(col < row){
            System.out.print("*");
            triangle(row, col+1);
        }else{
            System.out.println();
            triangle(row - 1, 0);
        }
    }



}
