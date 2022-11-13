/*
605. Can Place Flowers

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

*/

class Solution
{
    public boolean canPlaceFlowers(int[] flowerbed, int n)
    {
        int i = 0;

        while (n > 0 && i < flowerbed.length)
        {
            if (flowerbed[i] == 0) // not planted
            {
                boolean left = (i == 0 || flowerbed[i - 1] == 0);
                boolean right = (i == flowerbed.length - 1 ||
                                 flowerbed[i + 1] == 0);

                if (left && right)
                {
                    --n;
                    ++i; // skip next spot
                }
            }
            ++i;
        }
        return (n == 0);
    }
}
