/* 746. Min Cost Climbing Stairs


You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.
 */
class Solution 
{
    private Map <Integer, Integer> past = new HashMap<Integer, Integer>();
    private int findMinCost(int[] cost, int pos)
    {
        int min = past.getOrDefault(pos, -1);
        if (pos == 0 || pos == 1)
            return min;
        if (min == -1)
        {
            min = Math.min(findMinCost(cost, pos-1) + cost[pos-1] ,
                           findMinCost(cost, pos-2) + cost[pos-2]);
            past.put(pos, min);
        }
        return min;
    }
    public int minCostClimbingStairs(int[] cost) 
    {
        past.put(0, 0);
        past.put(1, 0);
        return findMinCost(cost, cost.length);
    }
}
