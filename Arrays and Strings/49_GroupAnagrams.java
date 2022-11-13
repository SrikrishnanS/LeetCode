/*
49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*/

class Solution 
{
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        Map<String, List<String>> map = new HashMap<>();
        int [] count;
        
        for (String s: strs)
        {
            String        k;
            StringBuilder sb = new StringBuilder();
            List<String>  list;
         
            count = new int[26];
            
            for (char ch : s.toCharArray())
                count[ch - 'a']++;
            
            for (char ch = 'a'; ch <= 'z'; ++ch)
                if (count[ch - 'a'] > 0)
                    for (int i = 0; i < count[ch - 'a']; ++i)
                        sb.append(ch);
        
            k = new String(sb);
            list = map.get(k);
            if (list == null)
            {
                list = new ArrayList<String>();
                map.put(k, list);
            }
            list.add(s);
        }
        return  new ArrayList<>(map.values());
    }
}
