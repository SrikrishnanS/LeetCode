/* 1423. Maximum Points You Can Obtain from Cards

There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 */

class Solution 
{
    public int maxScore(int[] cardPoints, int k) 
    {
        int [] leftSum  = new int[k + 1];
        int [] rightSum = new int[k + 1];
        int sum = 0;

        leftSum[0] = 0; // 0 cards from left, sum is 0
        rightSum[0] = 0; // 0 cards from right. sum is 0
        
        // sum from the left [0..k]
        // sum from the right   [k..0]
        for (int i = 1; i <= k; ++i)
        {
            leftSum[i] = leftSum[i - 1] + cardPoints[i - 1];
            rightSum[i] = rightSum[i - 1] + cardPoints[cardPoints.length - i];
        }

        // max sum with i cards from left and k-i cards from right
        for (int i = 0; i <= k; ++i)
            sum = Math.max(sum, leftSum[i] + rightSum[k - i]);

        return sum;
    }
}
