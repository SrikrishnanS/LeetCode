/*
11. Container With Most Water

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

*/

#define min(a, b) \
  ((a) < (b) ? (a) : (b))

#define max(a, b) \
  ((a) > (b) ? (a) : (b))

int maxArea(int* height, int heightSize)
{
    int left = 0, right = heightSize - 1, maxArea = 0;
    
    while (left < right)
    {
        maxArea = max(maxArea, (right - left) * min(height[left], height[right]));
        if (height[left] < height[right])
            ++left;
        else
            --right;
    }
    return maxArea;
}
