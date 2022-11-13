/* 55. Jump Game

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.
 */
class Solution 
{
    public boolean canJump(int[] nums) 
    {
        boolean [] canJump = new boolean[nums.length];
        int i, j;
        
        // Start with the hope that last index is reachable
        canJump[nums.length - 1] = true;
        for (i = nums.length - 2; i >= 0; --i)
        {
            // find last index reachable from current index
            // handle overflow case too
            int lastIdx = Math.min(i + nums[i], nums.length - 1);
            
            // if this step is reachable, i+1 to lastIdx are reachable too
            for (j = i + 1; j <= lastIdx; ++j)
            {
                if (canJump[j]) // if one of the steps in the range is
                                // reachable from here, then this index is
                {               // also reachable.
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[0];
    }
}
