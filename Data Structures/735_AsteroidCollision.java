/*
735. Asteroid Collision

We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

*/

class Solution 
{
    public int[] asteroidCollision(int[] asteroids) 
    {
        Stack<Integer> S  =  new Stack<Integer>();

        for (int i = 0; i < asteroids.length; ++i)
        {
            int curr = asteroids[i];
            int prev;

            if (S.isEmpty())
            {
                S.push(curr);
                continue;
            }
            
            prev = S.peek();
            
            if ((prev < 0 && curr < 0) ||
                (prev > 0 && curr > 0)) // same sign
                S.push(curr);
            else if (prev > 0 && curr < 0) // opposite directions
            {
                boolean doPush = false;
                while (!S.isEmpty() && prev > 0 && curr < 0)
                {
                    int sum = prev + curr;

                    if (sum == 0)
                    {
                        S.pop(); // remove prev, net impact = 0
                        doPush = false;
                        break;
                    }
                    else if (sum < 0)
                    {
                        S.pop();
                        prev = !S.isEmpty() ? S.peek() : -1;
                        doPush = true;
                    }
                    else
                    {
                        doPush = false;
                        break;
                    }
                }
                if (doPush)
                    S.push(curr);
            }
            else
                S.push(curr);
        }
        
        // create output
        int end = S.size();
        int[] output = new int[end];
        
        while (!S.isEmpty())
            output[--end] = S.pop();
        
        return output;
    }
}
