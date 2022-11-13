/* 79. Word Search

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
class Solution
{
    int     nrows;
    int     ncols;
    char [] word;
    private boolean hunt(char[][] board, int r, int c, int offset)
    {
        boolean    found = false;

        if (r < 0 || r == nrows   ||
            c < 0 || c == ncols   ||
            board[r][c] != word[offset])
            return found;

        if (offset + 1 == word.length)
            return true;

        board[r][c] = '?'; // temporarily change
        // character found, continue the hunt for char in next position
        if ((hunt(board, r + 1, c, offset + 1)) ||
            (hunt(board, r, c + 1, offset + 1)) ||
            (hunt(board, r - 1, c, offset + 1)) ||
            (hunt(board, r, c - 1, offset + 1)))
            found = true;
        board[r][c] = word[offset]; // restore
        return  found;
    }

    public boolean exist(char[][] board, String word)
    {
        char     start = word.charAt(0);
        int      i, j;

        this.nrows = board.length;
        this.ncols = board[0].length;
        this.word = word.toCharArray();

        for (i = 0; i < nrows; ++i)
            for (j = 0; j < ncols; ++j)
                if (board[i][j] == start && hunt(board, i, j, 0))
                        return true;
        return false;
    }
}
