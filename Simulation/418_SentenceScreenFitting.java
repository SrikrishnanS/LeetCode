/* 418. Sentence Screen Fitting

Given a rows x cols screen and a sentence represented as a list of strings, return the number of times the given sentence can be fitted on the screen.

The order of words in the sentence must remain unchanged, and a word cannot be split into two lines. A single space must separate two consecutive words in a line.
 */
class Solution 
{
    public int wordsTyping(String[] sentence, int rows, int cols) 
    {
        int r = 1; // current row - 1 based
        int c = 0; // current col - 1 based
        int sentences = 0;
        int []slens = new int[sentence.length];
        
        for (int i = 0; i < sentence.length; ++i)
        {
            slens[i] = sentence[i].length();
            if (slens[i] > cols)
               return 0;
        }
        while (true)
        {
            // find number of rows for 1 sentence
            for (int i = 0; i < sentence.length; ++i)
            {
                int slen = slens[i];
                if (c + slen > cols) // marks end of current row
                {
                    ++r;
                    c = 0;
                    if (r > rows)
                        break;
                }
                // guaranteed to have space for string s
                c += slen;
                if (c < cols)
                    ++c; // some left, so add space              
            }
            if (r > rows)
                break;
            ++sentences;
        }
        return sentences;
    }
}
