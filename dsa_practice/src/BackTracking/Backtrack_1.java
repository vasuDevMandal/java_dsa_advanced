package BackTracking;

import java.sql.Array;
import java.util.Arrays;

public class Backtrack_1 {
    public static void main(String[] args) {
        boolean[][] board= {
                { true, true, true},
                { true, true, true},
                { true, true, true}
        };
        //it starts for 0,1,2
//        allPaths("", board, 0, 0);//form loop , error

//        System.out.println("\n\n------ \n backtrack \n------\n");
//        allPathsBackTrack("", board, 0, 0);

        int[][] path = new int[board.length][ board[0].length];
        allPathsBackTrackPrint("", board, 0,0, path, 1);

    }

    static void allPathsBackTrackPrint(String path, boolean[][] maze, int r, int c, int[][] pathArr, int step){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            pathArr[r][c] = step;
            for (int[] arr: pathArr){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(path + '\n');
            return;
        }

        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false;
        pathArr[r][c] = step;

        if(r < maze.length - 1){
            allPathsBackTrackPrint(path + "D",maze , r+1, c, pathArr, step+1);
        }
        if(c < maze[0].length - 1){
            allPathsBackTrackPrint(path + "R" ,maze , r, c+1, pathArr, step+1);
        }
        if(r > 0){
            allPathsBackTrackPrint(path + "U" ,maze , r-1, c, pathArr, step+1);
        }
        if(c > 0){
            allPathsBackTrackPrint(path + "L" ,maze , r, c-1, pathArr, step+1);
        }

        maze[r][c] = true;
        pathArr[r][c] = 0;
    }

    static void allPathsBackTrack(String path, boolean[][] maze, int r, int c){

        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(path);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        // this block is part of my current path
        maze[r][c] = false;

        if(r < maze.length - 1){
            allPathsBackTrack(path + "D",maze , r+1, c);
        }
        if(c < maze[0].length - 1){
            allPathsBackTrack(path + "R" ,maze , r, c+1);
        }
        if(r > 0){
            allPathsBackTrack(path + "U" ,maze , r-1, c);
        }
        if(c > 0){
            allPathsBackTrack(path + "L" ,maze , r, c-1);
        }

        /* This is the line, when function is over
        * so before the function gets removed,
        * also remove the changes that are made by that function
        * */

        maze[r][c] = true;

    }

    static void allPaths(String path, boolean[][] maze, int r, int c){

        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(path);
            return;
        }

        if(!maze[r][c]){
            return;
        }
        if(r < maze.length - 1){
            allPaths(path + "D",maze , r+1, c);
        }
        if(c < maze[0].length - 1){
            allPaths(path + "R" ,maze , r, c+1);
        }
        if(r > 0){
            allPaths(path + "U" ,maze , r-1, c);
        }
        if(c > 0){
            allPaths(path + "L" ,maze , r, c-1);
        }
    }
}
