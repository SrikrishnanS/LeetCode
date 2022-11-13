/* 740. Delete and Earn

You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.
 */
class Solution 
{
    private Map<Integer, Integer> weight = new HashMap<Integer, Integer>();
    public int deleteAndEarn(int[] nums) 
    {
        int  maxval = nums[0];
        int  [] maxWeight;
        int  i;
        // compute total weight for each individual value
        for (i = 0; i < nums.length; ++i)
        {
            weight.put(nums[i], weight.getOrDefault(nums[i], 0) + nums[i]);
            if (nums[i] > maxval)
                maxval = nums[i]; // remember the maximum val in the array
        }
        maxWeight = new int[maxval + 1];

        // initialize base cases
        maxWeight[0] = 0;
        maxWeight[1] = weight.getOrDefault(1, 0);
        
        for (i = 2; i <= maxval; ++i)
        {
            int val = weight.getOrDefault(i, 0);
            // pick this val + val-2, or val-1
            maxWeight[i] = Math.max(maxWeight[i - 1],
                                    maxWeight[i - 2] + val);
        }
        return maxWeight[maxval];
    }
}
