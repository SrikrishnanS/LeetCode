/*
75. Sort Colors

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.
*/

class Solution 
{
    public void sortColors(int[] nums) 
    {
        int p0 = 0;
        int p2 = nums.length - 1;
        int curr = p0;
        
        while (curr <= p2)
        {
            if (nums[curr] == 0)  // swap p0 and curr

            {
                int temp = nums[p0];
                nums[p0] = nums[curr];
                nums[curr] = temp;
                ++p0;
                ++curr;
            }
            else if (nums[curr] == 2)  // swap p2 and curr
            {
                int temp = nums[p2];
                nums[p2] = nums[curr];
                nums[curr] = temp;
                --p2;
            }
            else
                ++curr; // advance curr
        }
        
    }
}