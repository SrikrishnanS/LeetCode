/* 490. The Maze

There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return true if the ball can stop at the destination, otherwise return false.

You may assume that the borders of the maze are all walls (see examples).
 */
class Solution 
{
    public boolean hasPath(int[][] maze, int[] start, int[] destination) 
    {
        return canRoll(maze, start, destination,
                       new boolean[maze.length][maze[0].length]);
    }
    
    private boolean canRoll(int [][]maze, int[] start, int []destination,
                         boolean[][]visited)
    {
        int  x = start[0];
        int  y = start[1];
        int  row, col;

        if (x == destination[0] &&
            y == destination[1])
            return true;
        else if (visited[x][y])
            return false;

        visited[x][y] = true; // mark cell as visited

        // roll all the way to the left (slide column)
        col = y;
        while (col >= 0 && maze[x][col] != 1)
            --col;

        if (canRoll(maze, new int[]{x, col + 1}, destination, visited))
            return true;

        // roll all the way to the right (slide column)
        col = y;
        while (col < maze[0].length && maze[x][col] != 1)
            ++col;

        if (canRoll(maze, new int[]{x, col - 1}, destination, visited))
            return true;

        // roll all the way to the top (slide row)
        row = x;
        while (row >= 0 && maze[row][y] != 1)
            --row;

        if (canRoll(maze, new int[]{row + 1, y}, destination, visited))
            return true;

        // roll all the way to the bottom (slide row)
        row = x;
        while (row < maze.length && maze[row][y] != 1)
            ++row;

        if (canRoll(maze, new int[]{row - 1, y}, destination, visited))
            return true;

        return false;
    }
}
