package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
//        System.out.println(count(3,3));
//        printPath("", 3, 3);
//        System.out.println(getPaths("", 3, 3));

//        getPathDiagonal("", 3 , 3);

        boolean[][] board= {
            { true, true, true},
            { true, false, true},
            { true, true, true}
        };
        //it starts for 0,1,2
        pathWithObstacle("", board, 0, 0);

    }

    static void pathWithObstacle(String path, boolean[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(path);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r < maze.length - 1){
            pathWithObstacle(path + "D",maze , r+1, c);
        }
        if(c < maze[0].length - 1){
            pathWithObstacle(path + "R" ,maze , r, c+1);
        }
    }

    static void getPathDiagonal(String path, int r, int c){
//        base case if we are at destination
        if(r == 1 && c == 1){
            System.out.println(path);
            return;
        }
        //diagonal
        if(r>1 && c >1){
            getPathDiagonal(path + "_digonal" ,r-1, c-1);
        }
//        move down if not on last row
        if(r > 1){
           getPathDiagonal(path + "_down",r-1, c);
        }

//        move right if not on last column
        if(c > 1){
           getPathDiagonal(path + "_right" ,r, c-1);
        }
    }

    static List<String> getPaths( String path, int r, int c){
        //base condition
        if(r==1 && c ==1){
            List<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }
        List<String> result = new ArrayList<>();
        //move down
        if(r > 1){
            result.addAll(getPaths(path + "D", r-1, c));
        }
        //move right
        if(c > 1){
            result.addAll(getPaths(path + "R", r, c -1));
        }
        return result;
    }

    static void printPath(String path, int r, int c){
//        base case if we are at destination
        if(r == 1 && c == 1){
            System.out.println(path);
            return;
        }
//        move down if not on last row
        if(r > 1){
            printPath(path + "D",r-1, c);
        }
//        move right if not on last column
        if(c > 1){
            printPath(path + "R" ,r, c-1);
        }
    }

    static int count(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }
        int left = count(r-1, c);
        int right = count(r, c-1);
        return left + right;
    }


}
