/*
36. Valid Sudoku

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

*/

class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        Set<Character> set = new HashSet<Character>();
        
        Set<Character>[] boxes = new Set[] { new HashSet<Character>(),
             new HashSet<Character>(), new HashSet<Character>(),
             new HashSet<Character>(), new HashSet<Character>(),
             new HashSet<Character>(), new HashSet<Character>(),
             new HashSet<Character>(), new HashSet<Character>()             
        };
        
        // validate every row
        for (int r = 0; r < 9; ++r)
        {
            set.clear();
            for (int c = 0; c < 9; ++c)
                if (Character.isDigit(board[r][c]) && !set.add(board[r][c]))
                    return false;
        }
        
        // validate every column
        for (int c = 0; c < 9; ++c)
        {
            set.clear();
            for (int r = 0; r < 9; ++r)
                if (Character.isDigit(board[r][c]) && !set.add(board[r][c]))
                    return false;
        }
        
        // validate every box
        for (int r = 0; r < 9; ++r)
        {
            for (int c = 0; c < 9; ++c)
            {
                int box = ((r / 3) * 3) + (c / 3); 
                
                if (Character.isDigit(board[r][c]) && 
                    !boxes[box].add(board[r][c]))
                    return false;
            }
        }
        return true;
    }
}
