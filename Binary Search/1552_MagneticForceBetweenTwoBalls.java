/*
1552. Magnetic Force Between Two Balls

In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.

Rick stated that magnetic force between two different balls at positions x and y is |x - y|.

Given the integer array position and the integer m. Return the required force.

*/

class Solution
{
    public int maxDistance(int[] position, int max)
    {
        int l, r;
        Arrays.sort(position);

        l = 1; // minimum
        r = position[position.length - 1] - position[0]; // maximum

        while (l < r)
        {
            int m = r - (r - l)/2;

            if (getNumBalls(position, m, max) >= max)
                l = m; // satisfies, find upper bound
            else
                r = m - 1;
        }
        return l;
    }

    private int getNumBalls(int[] pos, int distance, int max)
    {
        int previous = pos[0]; // start at pos[0]
        int count = 1; // 1st ball placed

        for (int i = 1; i < pos.length; ++i)
            if (pos[i] - previous >= distance)
            {
                ++count;
                previous = pos[i];
            }

        return count;
    }
}
