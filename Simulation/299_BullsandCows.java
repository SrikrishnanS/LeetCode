/* 299. Bulls and Cows

You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

The number of "bulls", which are digits in the guess that are in the correct position.
The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.
 */
class Solution 
{
    public String getHint(String secret, String guess) 
    {
        Map<Character, Integer> secretMap = new HashMap<>();
        int     bulls = 0, cows = 0;
    
        for (char s: secret.toCharArray())
            secretMap.put(s, 1 + secretMap.getOrDefault(s, 0));
        // bulls pass
        for (int i = 0; i < secret.length(); ++i)
        {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            int  gCount = secretMap.getOrDefault(g, 0);
            
            if (s == g)
            {
                ++bulls;
                if (gCount == 1)
                    secretMap.remove(g);
                else
                    secretMap.put(g, gCount - 1);
            }
        }
        // cows pass
        for (int i = 0; i < secret.length(); ++i)
        {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            int  gCount = secretMap.getOrDefault(g, 0);

            if (s != g && gCount > 0)
            {
                ++cows;
                if (gCount == 1)
                    secretMap.remove(g);
                else
                    secretMap.put(g, gCount - 1);
            }
        }
    
        return bulls + "A" + cows + "B";
    }
}
