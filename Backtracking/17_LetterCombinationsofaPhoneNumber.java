/* 17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 */
class Solution 
{
    private char[] getLetters(char n)
    {
        char [] letters = null;
        switch (n)
        {
            case '2':
                letters = new char[]{'a', 'b', 'c'};
                break;
            case '3':
                letters = new char[]{'d', 'e', 'f'};
                break;
            case '4':
                letters = new char[]{'g', 'h', 'i'};
                break;
            case '5':
                letters = new char[]{'j', 'k', 'l'};
                break;
            case '6':
                letters = new char[]{'m', 'n', 'o'};
                break;
            case '7':
                letters = new char[]{'p', 'q', 'r', 's'};
                break;
            case '8':
                letters = new char[]{'t', 'u', 'v'};
                break;
            case '9':
                letters = new char[]{'w', 'x', 'y', 'z'};
                break;
        }
        return letters;
    }    
    
    private void letterCombinations (String digits, int start, int end,
                                     StringBuilder sb, List<String> L)
    {
        if (start == end)
        {
            L.add(sb.toString());
            return;
        }
        for (char ch : getLetters(digits.charAt(start)))
        {
            sb.append(ch);
            letterCombinations(digits, start + 1, end, sb, L);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public List<String> letterCombinations(String digits) 
    {
        List<String> L = new ArrayList<>();
        
        if (digits.length() == 0)
            return L;

        letterCombinations(digits, 0, digits.length(), new StringBuilder(), L);
        return L;
    }
}
