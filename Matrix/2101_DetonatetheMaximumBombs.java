/*
2101. Detonate the Maximum Bombs

You are given a list of bombs. The range of a bomb is defined as the area where its effect can be felt. This area is in the shape of a circle with the center as the location of the bomb.

The bombs are represented by a 0-indexed 2D integer array bombs where bombs[i] = [xi, yi, ri]. xi and yi denote the X-coordinate and Y-coordinate of the location of the ith bomb, whereas ri denotes the radius of its range.

You may choose to detonate a single bomb. When a bomb is detonated, it will detonate all bombs that lie in its range. These bombs will further detonate the bombs that lie in their ranges.

Given the list of bombs, return the maximum number of bombs that can be detonated if you are allowed to detonate only one bomb.

*/

class Solution
{
    public int maximumDetonation(int[][] bombs)
    {
        int             n         = bombs.length;
        List<Integer>[] graph     = new List[n];
        Set<Integer>    detonated = new HashSet<Integer>();
        int             maxBombs  = 0;

        // create a directed graph
        for (int i = 0; i < n; ++i)
        {
            int x1 = bombs[i][0];
            int y1 = bombs[i][1];

            long r  = (long)bombs[i][2] * bombs[i][2]; // impact for ith bomb

            for (int j = 0; j < n; ++j)
            {
                if (i == j)
                    continue;

                long  dx = bombs[j][0] - x1;
                long  dy = bombs[j][1] - y1;
                long  d  = (dx * dx) + (dy * dy);

                // ith bomb detonates jth bomb
                if (d <= r)
                {
                    if (graph[i] == null)
                        graph[i] = new ArrayList<Integer>();

                    // j is a child of i
                    graph[i].add(j);
                }
            }
        }
        // detonate all bombs and find number of impacts
        for (int bomb = 0; bomb < n; ++bomb)
        {
            detonated.clear(); // start fresh for each bomb
            maxBombs = Math.max(maxBombs, detonate(graph, bomb, detonated));
        }
        return maxBombs;
    }

    private int detonate (List<Integer>[] graph, int bomb,
                          Set<Integer> detonated)
    {
        List<Integer> bombs = graph[bomb];

        detonated.add(bomb); // this bomb is detonated now

        // detonate all the bombs within impact range
        if (bombs != null)
            for (int b : bombs)
                if (!detonated.contains(b))
                    detonate(graph, b, detonated);

        return detonated.size(); // number of bombs detonated so far
    }
}
