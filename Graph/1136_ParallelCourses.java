/*
1136. Parallel Courses

You are given an integer n, which indicates that there are n courses labeled from 1 to n. You are also given an array relations where relations[i] = [prevCoursei, nextCoursei], representing a prerequisite relationship between course prevCoursei and course nextCoursei: course prevCoursei has to be taken before course nextCoursei.

In one semester, you can take any number of courses as long as you have taken all the prerequisites in the previous semester for the courses you are taking.

Return the minimum number of semesters needed to take all courses. If there is no way to take all the courses, return -1.

*/

class Solution
{
    public int minimumSemesters(int n, int[][] relations)
    {
        Queue<Integer>  Q       = new LinkedList<Integer>();
        List<Integer>[] graph   = new List[n + 1];
        int []          degree  = new int[n + 1];
        int             courses = 0; // courses taken
        int             semesters = 0;

        // create an access friendly graph
        for (int[] pair : relations)
        {
            // pair[0]  -->  pair[1]
            if (graph[pair[0]] == null)
                graph[pair[0]] = new ArrayList<>();

            graph[pair[0]].add(pair[1]);
            ++degree[pair[1]];
        }

        // add root nodes to Q initially
        for (int i = 1; i <= n; ++i)
            if (degree[i] == 0)
                Q.offer(i);

        while (!Q.isEmpty())
        {
            int qSize = Q.size();

            while ((qSize--) > 0) // prune next level of root nodes
            {
                int node = Q.poll();

                ++courses; // this course can be taken now

                if (graph[node] != null)
                    for (int child : graph[node])
                        if (--degree[child] == 0)
                            Q.offer(child);
            }
            ++semesters;
        }
        return (courses == n) ? semesters : -1;
    }
}
