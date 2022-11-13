/*
743. Network Delay Time

You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

*/

class Solution
{
    public int networkDelayTime(int[][] times, int n, int k)
    {
        List<int[]> [] G      = new List[n+1]; // graph model
        Queue<int[]>   Q      = new LinkedList<int[]>();
        int[]          ttr    = new int[n+1]; // time to receive
        int            maxttr = 0;

        Arrays.fill(ttr, Integer.MAX_VALUE); // 100 is the maximum value

        // create an access friendly graph and latency map
        for (int[] t : times)
        {
            if (G[t[0]] == null)
                G[t[0]] = new ArrayList<int[]>(); // create it the first time

            G[t[0]].add(new int[]{t[1], t[2]});
        }

        // visit nodes starting from k
        Q.offer(new int[]{k, 0}); // <node#, time> pair
        while (!Q.isEmpty())
        {
            int[]  t = Q.poll();
            int node = t[0]; // node number
            int time = t[1]; // time to reach node

            // we have reached k ->...-> node
            ttr[node] = Math.min(ttr[node],  time);
            if (G[node] != null)
                for (int []pair : G[node])
                {
                    int x     = pair[0];
                    int delta = pair[1];
                    // there is an edge from node to x
                    if (ttr[x] > delta + ttr[node])
                        Q.offer(new int[]{x, ttr[node] + delta});
                }
        }

        // find the maximum time to receive
        for (int t = 1; t < ttr.length; ++t)
            maxttr = Math.max(maxttr, ttr[t]);
        return maxttr == Integer.MAX_VALUE ? -1 : maxttr;
    }
}
