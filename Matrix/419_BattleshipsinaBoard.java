/*  419. Battleships in a Board

Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.

Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).

*/

class Solution 
{
    int nrows;
    int ncols;
    public int countBattleships(char[][] board) 
    {
        int count = 0;
        
        this.nrows = board.length;
        this.ncols = board[0].length;
        
        for (int i = 0; i < nrows; ++i)
            for (int j = 0; j < ncols; ++j)
                if (exploreBattleShip(board, i, j))
                    ++count;
        return count;
    }
    private boolean exploreBattleShip(char [][] board, int r, int c)
    {
        if (r < 0 || r == nrows ||
            c < 0 || c == ncols ||
            board[r][c] == '.')
            return false;

        board[r][c] = '.'; // visited
        exploreBattleShip(board, r + 1, c);
        exploreBattleShip(board, r, c + 1);
        return true;
    }
}
