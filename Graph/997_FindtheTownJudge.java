/* 997. Find the Town Judge

In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 */
class Solution 
{
    public int findJudge(int n, int[][] trust) 
    {
        int[] degrees = new int[n + 1];

        for (int[]pair : trust)
        {
            // pair[0] trusts pair[1]
            ++degrees[pair[1]];
            --degrees[pair[0]];
        }
        
        for (int d = 1; d <=n; ++d)
            if (degrees[d] == n - 1)
                return d;
        return -1;
    }
}
