/* 346. Moving Average from Data Stream

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:

MovingAverage(int size) Initializes the object with the size of the window size.
double next(int val) Returns the moving average of the last size values of the stream.
 */
class MovingAverage 
{
    private Queue<Integer> Q;
    private int maxSize;
    private int sum;
    private int size;
    
    public MovingAverage(int size) 
    {
        Q = new LinkedList<Integer>();
        this.maxSize = size;
        this.sum = 0;
        this.size = 0;
    }
    
    public double next(int val) 
    {
        Q.offer(val);
        sum += val;
        
        if (Q.size() > maxSize)
            sum -= Q.poll();
        else
            ++size;
        return (double) sum / size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
