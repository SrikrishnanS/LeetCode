/* 139. Word Break

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
class Solution 
{
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        Set<String> set = new HashSet<String>(wordDict);    
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        return wordBreak(s, set, map);
    }
    
    private boolean wordBreak(String s, Set<String> set,
                              Map <String, Boolean> map)
    {
        Boolean found = false;
        
        found = map.get(s);
        if (found != null)
            return found;
        found = false;
        if (s.equals(""))
        {
            found = true;
        }
        else
        {
            for (int i = 1; i <= s.length(); ++i)
            {
                String left = s.substring(0, i);
                String right = s.substring(i, s.length());

                if (set.contains(left) && wordBreak(right, set, map))
                {
                    found = true;
                    break;
                }
            }
        }
        map.put(s, found);
        return found;
    }
}
