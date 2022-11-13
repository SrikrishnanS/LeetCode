/*
1213. Intersection of Three Sorted Arrays

Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.

*/

class Solution 
{
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) 
    {
        List<Integer> result = new ArrayList<Integer>();
        int p1 = 0, p2 = 0, p3 = 0;
    
        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length)
        {
            if (arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3])
            {
                result.add(arr1[p1]);
                ++p1;
                ++p2;
                ++p3;
            }
            else
            {
                int min = Math.min(arr1[p1], Math.min(arr2[p2], arr3[p3]));
                
                if (arr1[p1] == min)
                    ++p1;
                else if (arr2[p2] == min)
                    ++p2;
                else
                    ++p3;                
            }
        }
        return result;
    }
}
