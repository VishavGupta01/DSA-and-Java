public class backtrackingAssignment {
    public static void main(String[] args) {

    }

    //Question 1: Rat in a Maze
    // You are given a starting position for a rat which is stuck in a maze at an initial point (0, 0) (the maze can be thought of as a 2-dimensional plane). The maze is provided in the form of a square matrix of order N x N, where:
    // Cells with value 0 represent blocked locations.
    // Cells with value 1 represent open/available paths that the rat can take to reach its destination.
    // The rat's destination is at the bottom-right corner of the maze, i.e., at (N - 1, N - 1).
    // Task:
    // Find all the possible paths that the rat can take to reach from the source (0, 0) to the destination (N - 1, N - 1) in the maze.
    // Movement Directions:
    // The possible directions the rat can take to move in the maze are:
    // 'U' (up) - move to (x, y - 1)
    // 'D' (down) - move to (x, y + 1)
    // 'L' (left) - move to (x - 1, y)
    // 'R' (right) - move to (x + 1, y)
    public static int ratMaze(int[][] maze, int row, int col, int x, int y) {
        // Base Case
        if (row == x && col == y) {
            return 1;
        } else if (row > x || col > y || row < 0 || col < 0) {
            return 0;
        }
        if (!pathAvailable(maze, row, col)) {
            
        }
        // UP:
        ratMaze(maze, row, col-1, x, y);

        return totalWays;
    }

    public static boolean pathAvailable(int[][] maze, int row, int col) {
        if (maze[row][col] == 0) {
            return false;
        }
        return true;
    }
}
