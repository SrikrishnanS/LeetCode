/*
33. Search in Rotated Sorted Array
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
*/

int search(int* arr, int numsSize, int target)
{
    int l = 0, r = numsSize - 1;
    int m;
    if (l < numsSize-1 && arr[l] > arr[l+1]) // first element
        m = l;
    else
        while (l <= r)
        {
            m = (int)((r-l)/2) + l;

            if (arr[m] == target)
                return m;
            if (m < numsSize-1 && arr[m] > arr[m+1])
                break;
            if (arr[m] >= arr[l])
                l = m + 1;
            else
                r = m-1;
        }
    // now m+1 is the index of rotation
    // value is in sorted range 0-m or m+1 to r
   
    if (target >= arr[0]) // search in left sub array
        return binsearch(arr, 0, m, target);
    else // search in right sub array
        return binsearch(arr, m+1, numsSize - 1, target);
}

OR:

int search(int* arr, int numsSize, int target)
{
    int  l = 0, r = numsSize - 1;
    int  m;
    
    while (l <= r)
    {
        m = l + (int)((r-l)/2);
        
        if (arr[m] == target)
            return m;
        if (arr[m] >= arr[l]) // left subarray is non-rotated
        {
            if (target >= arr[l] && target < arr[m])
                r = m-1;
            else
                l = m+1;
        }
        else                 // right subarray is non-rotated
        {
            if (target > arr[m] && target <= arr[r])
                l = m+1;
            else
                r = m-1;
        }
    }
    return -1;
}
