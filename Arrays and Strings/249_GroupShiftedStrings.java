/*
249. Group Shifted Strings

We can shift a string by shifting each of its letters to its successive letter.

For example, "abc" can be shifted to be "bcd".
We can keep shifting the string to form a sequence.

For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" -> ... -> "xyz".
Given an array of strings strings, group all strings[i] that belong to the same shifting sequence. You may return the answer in any order.

*/

class Solution 
{
    private String getKey(String s)
    {
        StringBuilder sb = new StringBuilder("|");
        for (int i = 1; i < s.length(); ++i)
        {
            int diff  = (s.charAt(i) - s.charAt(i-1) + 26) % 26;
            sb.append(diff + "|");
        }
        return new String(sb);
    }
    
    
    public List<List<String>> groupStrings(String[] strings) 
    {
        List<List<String>> results = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strings)
        {
            String key = getKey(s);
            List<String> l = map.get(key);
            
            if (l == null)
            {
                l = new ArrayList<String>();
                map.put(key, l);
            }
            l.add(s);
        }
        for (String key : map.keySet())
            results.add(map.get(key));
        
        return results;
    }
}
