/*
360. Sort Transformed Array

Given a sorted integer array nums and three integers a, b and c, apply a quadratic function of the form f(x) = ax2 + bx + c to each element nums[i] in the array, and return the array in a sorted order.

*/

class Solution
{
    public int[] sortTransformedArray(int[] nums, int a, int b, int c)
    {
        int l = 0, r = nums.length - 1;
        int [] sorted = new int[nums.length];
        int end = a >= 0 ? nums.length - 1 : 0;

        // parabola curve, if a > 0, upward curve, else downward
        while (l <= r)
        {
            int v1 = f(nums[l], a, b, c);
            int v2 = f(nums[r], a, b, c);

            if (a >= 0)
            {
                if (v1 > v2)
                {
                    sorted[end--] = v1;
                    ++l;
                }
                else
                {
                    sorted[end--] = v2;
                    --r;
                }
            }
            else
            {
                if (v1 > v2)
                {
                    sorted[end++] = v2;
                    --r;
                }
                else
                {
                    sorted[end++] = v1;
                    ++l;
                }
            }

        }
        return sorted;
    }

    private int f(int x, int a, int b, int c)
    {
        return (a * x * x) + (b * x) + c;
    }
}
