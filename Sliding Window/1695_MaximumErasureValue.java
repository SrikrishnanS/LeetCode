/*
1695. Maximum Erasure Value

You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

*/

class Solution
{
    public int maximumUniqueSubarray(int[] nums)
    {
        Set<Integer> seen = new HashSet<Integer>();
        int start = 0, end = 0;
        int score = 0, maxScore = 0;

        while (end < nums.length)
        {
            while (seen.contains(nums[end]))
            {
                seen.remove(nums[start]);
                score -= nums[start];
                ++start;
            }

            score += nums[end];
            seen.add(nums[end]);
            maxScore = Math.max(maxScore, score);
            ++end;
        }
        return maxScore;
    }
}
