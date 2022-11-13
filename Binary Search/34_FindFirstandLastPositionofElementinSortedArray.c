/*
34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

*/

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

void search(int *nums, int ntot, int left, int right, int target,
            int *minLeft, int *maxRight)
{
    int  mid = left + (int) ((right-left)/2);
    int  val;
    int  mleft = ntot, mright = -1;
    
    if (left < 0 || right == ntot || left > right)
    {
        *minLeft = mleft;
        *maxRight = mright;
        return; // not found
    }
    val = nums[mid];
    
    if (val == target)
    {
        *minLeft = *maxRight = mid;
        if (mid != 0 && nums[mid-1] == target)
        {
            search(nums, ntot, left, mid-1, target, &mleft, &mright);   //search left subtree
            if (mleft != ntot)
                *minLeft = mleft;
        }
        if (mid < ntot-1 && nums[mid+1] == target)
        {
            search(nums, ntot, mid+1, right, target, &mleft, &mright); //search right subtree
            if (mright != -1)
                *maxRight = mright;
        }
    }
    else if (val > target) //go to left subtree
    { 
        search(nums, ntot, left, mid-1, target, &mleft, &mright);
        if (mleft != ntot && mleft < *minLeft)
            *minLeft = mleft;
        if (mright != -1 && mright > *maxRight)
            *maxRight = mright;
    }
    else // go  to right subtree
    {
        search(nums, ntot, mid+1, right, target, &mleft, &mright);       
        if (mright != -1 && mright > *maxRight)
            *maxRight = mright;
        if (mleft != ntot && mleft < *minLeft)
            *minLeft = mleft;
    }
}

int* searchRange(int* nums, int numsSize, int target, int* returnSize)
{
    int *ret = malloc(2 * sizeof(int));
    int  minLeft  = numsSize;
    int  maxRight = -1;
    
    search(nums, numsSize, 0, numsSize - 1, target, &minLeft, &maxRight);
    
    ret[0] = (minLeft == numsSize) ? -1 : minLeft;
    ret[1] = maxRight;
    *returnSize = 2;
    return ret;
}


int binsearch (int *arr, int l, int r, int target)
{
    int m;
    while (l <= r)
    {
        m = (int)((r-l)/2) + l;
        if (target == arr[m])
            return m;
        else if (target > arr[m])
            l = m + 1;
        else
            r = m - 1;
    }
    return -1;
}
