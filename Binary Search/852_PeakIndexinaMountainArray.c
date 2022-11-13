/*
852. Peak Index in a Mountain Array
Let''s call an array arr a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

*/

int peakIndex(int *arr, int l, int r, int arrSize)
{
    int val;
    int m = l + ((r-l)/2);

    if (l < 0 || r == arrSize)
        return -1;
   
    if (l == r)
        return l;    
    if (m-1 < 0 || m+1 == arrSize)
        return m;
    val = arr[m];
    if (val >= arr[m-1] && val >= arr[m+1])
        return m;
    else if (val > arr [m-1])
        return peakIndex(arr, m, r, arrSize);
    else if (val < arr[m-1])
        return peakIndex(arr, l, m, arrSize);
    return m;
}

int peakIndexInMountainArray(int* arr, int arrSize)
{

    int  l = 0;
    int  r = arrSize - 1;
    
    return peakIndex(arr, l, r, arrSize);
}
