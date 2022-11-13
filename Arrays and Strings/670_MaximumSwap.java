/*
670. Maximum Swap

You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.

*/

class Solution 
{
    public int maximumSwap(int num)
    {
        char [] numArr = ("" + num).toCharArray();
    
        int []maxIdx = new int[numArr.length];
        
        maxIdx[maxIdx.length - 1] = maxIdx.length - 1;
        for (int i = maxIdx.length - 2; i >= 0; --i)
        {
            if (numArr[i] > numArr[maxIdx[i+1]])
                maxIdx[i] = i;
            else
                maxIdx[i] = maxIdx[i+1];
        }
        for (int i = 0; i < maxIdx.length; ++i)
        {
            if (numArr[maxIdx[i]] != numArr[i])
            {
                char temp = numArr[i];
                numArr[i] = numArr[maxIdx[i]];
                numArr[maxIdx[i]] = temp;
                break;
            }
        }
        return Integer.valueOf(new String(numArr));
    }
}
