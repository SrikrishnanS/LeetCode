/* 130. Surrounded Regions

Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
class Solution 
{
    public void solve(char[][] board) 
    {
        // first flood fill from borders
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                if ((i *j == 0) || (i == board.length - 1) ||
                    (j == board[0].length - 1))
                    flood(board, i, j, 'O', '.'); // replace 'O' with '.'
        // flip remaining 'O's into 'X's
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
        // flip back '.' into 'O's
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                if (board[i][j] == '.')
                    board[i][j] = 'O';
    }
    private void flood(char[][] board, int r, int c, char src, char dest)
    {
        if (r < 0 || r == board.length ||
            c < 0 || c == board[0].length ||
            board[r][c] != src ||
            board[r][c] == dest)
            return;

        board[r][c] = dest;
        flood(board, r + 1, c, src, dest);
        flood(board, r - 1, c, src, dest);
        flood(board, r, c + 1, src, dest);
        flood(board, r, c - 1, src, dest);
    }
}
