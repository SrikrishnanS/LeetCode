/*
295. Find Median from Data Stream

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.

*/

class MedianFinder 
{
    Queue<Integer> minQ, maxQ;
    public MedianFinder() 
    {
        minQ = new PriorityQueue<Integer>((a, b) -> a - b);
        maxQ = new PriorityQueue<Integer>((a, b) -> b - a);
    }
    
    public void addNum(int num) 
    {
        maxQ.offer(num);
        minQ.offer(maxQ.poll());
        
        if (minQ.size() > maxQ.size()) // balancing
            maxQ.offer(minQ.poll());
    }
    
    public double findMedian()
    {
        return (maxQ.size() > minQ.size()) 
                ? maxQ.peek() 
                : ((minQ.peek() + maxQ.peek()) / 2.0); 
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */