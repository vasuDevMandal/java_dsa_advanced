package BackTracking;

public class Backtrack_1 {
    public static void main(String[] args) {
        boolean[][] board= {
                { true, true, true},
                { true, false, true},
                { true, true, true}
        };
        //it starts for 0,1,2
        allPaths("", board, 0, 0);
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
