/*
811. Subdomain Visit Count

A website domain "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com" and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

A count-paired domain is a domain that has one of the two formats "rep d1.d2.d3" or "rep d1.d2" where rep is the number of visits to the domain and d1.d2.d3 is the domain itself.

For example, "9001 discuss.leetcode.com" is a count-paired domain that indicates that discuss.leetcode.com was visited 9001 times.
Given an array of count-paired domains cpdomains, return an array of the count-paired domains of each subdomain in the input. You may return the answer in any order.

*/

class Solution
{
    public List<String> subdomainVisits(String[] cpdomains)
    {
        Map<String, Integer> domain = new HashMap<>();
        List<String> result = new ArrayList<>();

        // parse domain strings to map
        for (String s : cpdomains)
            processDomain(s, domain);

        // add values to results list
        for (Map.Entry<String, Integer> e : domain.entrySet())
            result.add(e.getValue() + " " + e.getKey());

        return result;
    }

    private void processDomain(String s, Map<String, Integer> domain)
    {
        String [] pieces = s.split(" ");
        int       count  = Integer.parseInt(pieces[0]);
        String[]  parts  = pieces[1].split("\\.");
        String    d      = "";

        for (int i = parts.length - 1; i >= 0; --i)
        {
            d = (i == parts.length - 1) ? parts[i] : parts[i] + "." + d;
            // update the count
            domain.put(d, domain.getOrDefault(d, 0) + count);
        }
    }
}
