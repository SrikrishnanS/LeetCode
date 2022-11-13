/*
289. Game of Life

According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

*/

class Solution
{
    private int getNeighbors(int[][] board, int i, int j)
    {
        int      neighbors = 0;
        int      nrows  = board.length;
        int      ncols  = board[0].length;
        int [][] moves  = new int[][]
                            {{-1, -1}, {-1, 0}, {0, -1}, {-1, 1},
                             {1, 1}, { 1, 0}, {0, 1}, {1, -1}};

        for (int [] move : moves)
        {
            int x = i + move[0];
            int y = j + move[1];

            if (x < 0 || x == nrows ||
                y < 0 || y == ncols)
                continue;

            if (board[x][y] == 1)
                ++neighbors;
        }
        return neighbors;
    }
    public void gameOfLife(int[][] board)
    {
        int      nrows  = board.length;
        int      ncols  = board[0].length;
        int [][] result = new int[nrows][ncols];

        // find neighbors
        for (int i = 0; i < nrows; ++i)
            for (int j = 0; j < ncols; ++j)
            {
                int neighbors = getNeighbors(board, i, j);

                if (board[i][j] == 1)
                {
                    // (1) Any live cell with fewer than two live neighbors
                    //     dies as if caused by under-population.
                    if (neighbors < 2)
                        result[i][j] = 0;
                    // (2) Any live cell with two or three live neighbors
                    //     lives on to the next generation.
                    else if (neighbors == 2 || neighbors == 3)
                        result[i][j] = 1;
                    // (3) Any live cell with more than three live
                    //     neighbors dies, as if by over-population.
                    else if (neighbors > 3)
                        result[i][j] = 0;
                }
                // (4) Any dead cell with exactly three live neighbors
                //     becomes a live cell, as if by reproduction.
                else if (neighbors == 3)
                        result[i][j] = 1;
            }
        // copy the result back to board
        for (int i = 0; i < nrows; ++i)
            for (int j = 0; j < ncols; ++j)
                board[i][j] = result[i][j];
    }
}
