/*
239. Sliding Window Maximum

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

*/

class Solution
{
    public int[] maxSlidingWindow(int[] arr, int k)
    {
        Deque<Integer> Q = new LinkedList<Integer>();
        int [] result = new int[arr.length - k + 1];

        for (int i = 0; i < arr.length; ++i)
        {
            // maintain Q with 3 most recent elements
            if (!Q.isEmpty() && Q.peekFirst() <= (i - k))
                Q.pollFirst();

            // retain only the maximum value in the window
            // i.e. in decreasing order
            while (!Q.isEmpty() && arr[Q.peekLast()] < arr[i])
                Q.pollLast();

            Q.offerLast(i);

            if (i - k + 1 >= 0)
                result[i - k + 1] = arr[Q.peekFirst()];
        }
        return result;
    }
}
