/*
120. Triangle

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

*/

class Solution 
{
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int nrows = triangle.size();

        for (int i = 1; i < nrows; ++i)
        {
            List<Integer> p  = triangle.get(i - 1);
            List<Integer> l  = triangle.get(i);
            int psize        = p.size(); // previous row
            int lsize        = l.size(); // current row
            
            for (int j = 0; j < lsize; ++j)
            {
                int val = l.get(j);
                int min = Integer.MAX_VALUE;
                
                Integer a = (j == 0) ? null : p.get(j - 1);
                Integer b = (j >= psize) ? null : p.get(j);
                
                if (a != null)
                    min = a;
                if (b != null)
                    min = Math.min(min, b);
                
                l.set(j, val + min);
            }
        }
        return Collections.min(triangle.get(nrows - 1));
    }
}
