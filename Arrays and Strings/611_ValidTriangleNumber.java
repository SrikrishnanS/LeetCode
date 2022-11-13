/*
611. Valid Triangle Number

Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

*/

class Solution
{
    public int triangleNumber(int[] nums)
    {
        int triangles = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i)
        {
            int k = i + 2;
            if (nums[i] == 0)
                continue;
            for (int j = i + 1; j < nums.length - 1; ++j)
            {
                int sum = nums[i] + nums[j];
                while (k < nums.length && sum > nums[k])
                    ++k;

                triangles += k - j - 1;
            }
        }
        return triangles;
    }
}
