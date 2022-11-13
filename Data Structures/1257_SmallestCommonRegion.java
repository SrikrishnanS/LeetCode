/*
1257. Smallest Common Region

You are given some lists of regions where the first region of each list includes all other regions in that list.

Naturally, if a region x contains another region y then x is bigger than y. Also, by definition, a region x contains itself.

Given two regions: region1 and region2, return the smallest region that contains both of them.

If you are given regions r1, r2, and r3 such that r1 includes r3, it is guaranteed there is no r2 such that r2 includes r3.

It is guaranteed the smallest region exists.

*/

class Solution
{
    public String findSmallestRegion(List<List<String>> regions,
                                     String region1, String region2)
    {
        Map<String, String> parent = new HashMap<>();
        Set<String> path = new HashSet<>();

        // region -> parent
        for (List<String> list : regions)
            for (int i = 1; i < list.size(); ++i)
                parent.put(list.get(i), list.get(0));

        // get path to region1
        while (region1 != null)
        {
            path.add(region1);
            region1 = parent.get(region1);
        }

        // move up the ladder until common parent found
        while(!path.contains(region2))
            region2 = parent.get(region2);

        return region2;
    }
}
