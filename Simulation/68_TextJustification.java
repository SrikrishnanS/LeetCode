/* 68. Text Justification

Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word''s length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
 */
class Solution 
{
    public List<String> fullJustify(String[] words, int maxWidth) 
    {
        List<String>[]   list    = new List[words.length];
        int [] lenMap = new int[words.length];
        
        int curIdx = 0;
        int            curlen  = 0;
        List<String> result = new ArrayList<String>();
        
        // first spread out the words for each line
        for (int i = 0; i < words.length; ++i)
        {
            String w = words[i];
            if (curlen + w.length() > maxWidth)
            {
                ++curIdx;
                curlen = 0;
            }
                
            curlen += w.length() + 1; // add length to include space at end
                
            if (list[curIdx] == null)
                list[curIdx] = new ArrayList<String>();

            list[curIdx].add(w);
            lenMap[curIdx] += w.length();
        }
        
        for (int i = 0; i <= curIdx; ++i)
        {
            List<String> l = list[i];
            StringBuilder sb = new StringBuilder();
            int spaces = maxWidth - lenMap[i]; // spaces to add
            int each = spaces / (l.size() == 1 ? 1 : l.size()-1);
            int left = spaces % (l.size() == 1 ? 1 : l.size()-1);
            for (int j = 0; j < l.size(); ++j)
            {
                String s = l.get(j);
                sb.append(s);
                if (i < curIdx && (j == 0 || j != l.size()-1))
                {
                    for (int n = 0; n < each; ++n)
                        sb.append(" ");
                    if (left > 0)
                    {
                        sb.append(" ");
                        --left;
                    }
                }
                else if (i == curIdx && j != l.size() - 1)
                    sb.append(" ");
            }
            if (i == curIdx)
            {
                each = maxWidth - sb.length();
                for (int n = 0; n < each; ++n)
                    sb.append(" ");
            }
            result.add(new String(sb));
        }
        return result;
    }
}
