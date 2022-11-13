/*
827. Making A Large Island

You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

*/

class Solution
{
    private int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int largestIsland(int[][] grid)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int                   n = grid.length;
        int                   id = 2; // id for an island
        Set<Integer>          next = new HashSet<Integer>();
        int                   maxArea = 0;
        int                   water = 0;

        // find all distinct islands and flood with an id
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == 1)
                    flood(grid, i, j, n, id++, map);
                else if (grid[i][j] == 0)
                    ++water;
        // all 1s, so return area
        if (water == 0)
            return (n * n);

        // examine the neighbors of water cells and compute
        // the maximum area possible by turning it to land
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == 0)
                {
                    int area = 1; // atleast 1, due to flip of 0
                    next.clear();
                    // gather unique neighboring ids
                    for (int[] m : moves)
                    {
                        int r = i + m[0];
                        int c = j + m[1];

                        if (r < 0 || r == n ||
                            c < 0 || c == n ||
                            grid[r][c] == 0)
                            continue; // not valid neighbor

                        next.add(grid[r][c]);
                    }
                    // find area of current expanded island
                    for (int k : next)
                        area += map.get(k);
                    // update max area
                    maxArea = Math.max(maxArea, area);
                }
        return maxArea;
    }

    private void flood(int[][]grid, int r, int c, int n, int id,
                       Map<Integer, Integer> map)
    {
        if (r < 0 || r == n ||
            c < 0 || c == n ||
            grid[r][c] != 1) // not land, or already visited
            return;

        grid[r][c] = id; // record island id in the cell
        map.put(id, map.getOrDefault(id, 0) + 1); // record area

        // flood reachable neighbors too
        for (int[] m : moves)
            flood(grid, r + m[0], c + m[1], n, id, map);
    }
}
