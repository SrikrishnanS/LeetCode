/* 1926. Nearest Exit from Entrance in Maze

You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 */
class Solution
{
    public int nearestExit(char[][] maze, int[] entrance)
    {
        int           nrows  = maze.length;
        int           ncols  = maze[0].length;
        Queue<int[]>  Q      = new LinkedList<int[]>();
        int           nsteps = 1;
        int[][]       moves  = new int[][]{{-1, 0}, {1, 0},
                                           {0, -1}, {0, 1}};
        
        if (maze == null || entrance == null || entrance.length != 2)
            return -1;
        
        maze[entrance[0]][entrance[1]] = '+'; // mark entrance as visited
        Q.offer(entrance); // start with the entrance cell
        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            
            for (int n = 0; n < qSize; ++n)
            {
                int [] cell = Q.poll();
                
                for (int[] move: moves)
                {
                    int r = cell[0] + move[0];
                    int c = cell[1] + move[1];

                    if ((r < 0) || (r == nrows) ||
                        (c < 0) || (c == ncols) ||
                        maze[r][c] == '+')
                        continue; // obstacle, so move on
                    else if ((r * c == 0) ||
                             (r == nrows - 1) || (c == ncols - 1))
                        return nsteps;

                    maze[r][c] = '+'; // mark cell as visited
                    Q.offer(new int[]{r, c});           
                }
            }
            ++nsteps;
        }
        return -1;
    }
}
