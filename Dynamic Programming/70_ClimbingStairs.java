/* 70. Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
class Solution 
{
    Map <Integer, Integer> nsteps = new HashMap<Integer, Integer>();
    private int climbStairs0(int n)
    {
        int ns = nsteps.getOrDefault(n, 0);
        if (ns == 0)
        {
            ns = climbStairs(n-1) + climbStairs(n-2);
            nsteps.put(n, ns);
        }
        return ns;
    }
    public int climbStairs(int n) 
    {
        nsteps.put(1, 1);
        nsteps.put(2, 2);
        return climbStairs0(n);
    }
}
