35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

int searchInsert0(int *nums, int left, int right, int target)
{
    int middle = left + ((int)(right-left)/2);

    if (left == right)
    {
        if (nums[left] >= target)
            return left;
        else if (nums[left] < target)
            return left+1;
    }
    if (nums[middle] == target)
        return middle;
    else if (nums[middle] > target)
    {
        if (middle == left)
            return middle;
        else
            return searchInsert0(nums, left, middle-1, target);
    }
    else if (nums[middle] < target)
    {
        if (middle == right)
            return middle+1;
        else
            return searchInsert0(nums, middle+1, right, target);
    }
    return middle;
}

int searchInsert(int* nums, int numsSize, int target)
{
    return searchInsert0(nums, 0, numsSize-1, target);
}