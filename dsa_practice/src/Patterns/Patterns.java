package Patterns;
//https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/assignments/09-patterns.md
public class Patterns {
    public static void main(String[] args) {

        int n = 4;
        pattern31(n);
    }

    static void pattern31(int n){
        int originalN = n;
        n = 2 * n;
        for (int row = 0; row <= n ; row++) {
            for (int col = 0; col <= n ; col++) {
                int atEveryIndex = originalN - Math.min(Math.min(row,col),Math.min(n - col, n- row));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }

    static void pattern17(int n){
        for (int row = 1; row <= 2* n; row++) {
            int colNum = row > n ? 2*n - row: row;
            for (int space = 0; space < n - colNum; space++) {
                System.out.print(" ");
            }
            for (int col = colNum; col >= 1; col--) {
                System.out.print(col);
            }
            for (int col = 2; col <= colNum; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    static void pattern30(int n){
        for (int row = 1; row <= n; row++) {
            for (int space = 0; space < n - row; space++) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void pattern28(int n){
        for (int row = 1; row < 2*n; row++) {
            int totalColsInRow =  row > n ? 2*n - row : row;

            int numberOfSpaces = n - totalColsInRow;
            for (int i = 1; i <= numberOfSpaces; i++) {
                System.out.print(" ");
            }

            for (int i = 1; i <= totalColsInRow; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n){
        for (int row = 1; row < 2*n; row++) {
            int totalColsInRow =  row > n ? 2*n - row : row;
            for (int i = 1; i <= totalColsInRow; i++) {
                System.out.print(i + "* ");
            }
            System.out.println();
        }
    }

//    * * * *
//    * * * *
//    * * * *
//    * * * *
//    2nd loop: for every row equal no. of cols is required
    static void pattern1(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

//    *
//    * *
//    * * *
//    * * * *
//    2nd loop: for every row, row number == column number
    static void pattern2(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n - row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 1; col <= row+1; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }



}
