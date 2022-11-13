/*
1337. The K Weakest Rows in a Matrix

You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

*/

class Row
{
    int  soldiers;
    int  row;
    
    public Row(int soldiers, int row)
    {
        this.soldiers = soldiers;
        this.row = row;
    }
}

class Solution 
{
    // index of first 0 is the sum
    private int getSum(int [] arr)
    {
        int l = 0, r = arr.length;
        
        while (l < r)
        {
            int m = l + ((r - l)/2);
        
            if (arr[m] == 0)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
    
    public int[] kWeakestRows(int[][] matrix, int k) 
    {
        int []      result  =  new int[k];
        Queue<Row>  Q;
        
        // max-heap
        Q =  new PriorityQueue<>((r1, r2) -> {
                 if (r1.soldiers == r2.soldiers)
                     return r2.row - r1.row;
                 else
                     return r2.soldiers - r1.soldiers;
             });

        for (int i = 0; i < matrix.length; ++i)
        {
            int soldiers = 0;
            
            soldiers = getSum(matrix[i]);

            Q.offer(new Row(soldiers, i));
            if (Q.size() > k)
                Q.poll();
        }

        while (!Q.isEmpty())
            result[--k] = Q.poll().row;

        return result;
    }
}