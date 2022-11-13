/* 498. Diagonal Traverse

Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 */
class Solution 
{
    int index;
    public int[] findDiagonalOrder(int[][] mat) 
    {
        int nelems = mat.length * mat[0].length;
        int [] result = new int[nelems];    
    
        int r = 0, c = 0;
        for (int i = 0; i < nelems; ++i)
        {
            result[i] = mat[r][c];
            if ((r + c) % 2 == 0) // diagonal up
            {
                if (c == mat[0].length - 1)
                    ++r;
                else if (r == 0)
                    ++c;
                else
                {
                    --r;
                    ++c;
                }
            }
            else // diagonal down
            {
                if (r == mat.length - 1)
                    ++c;
                else if (c == 0)
                    ++r;
                else
                {
                    ++r;
                    --c;
                }
            }
        }
        return result;
    }
}
