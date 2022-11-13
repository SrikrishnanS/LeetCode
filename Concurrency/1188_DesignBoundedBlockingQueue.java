/*
1188. Design Bounded Blocking Queue

Implement a thread-safe bounded blocking queue that has the following methods:

BoundedBlockingQueue(int capacity) The constructor initializes the queue with a maximum capacity.
void enqueue(int element) Adds an element to the front of the queue. If the queue is full, the calling thread is blocked until the queue is no longer full.
int dequeue() Returns the element at the rear of the queue and removes it. If the queue is empty, the calling thread is blocked until the queue is no longer empty.
int size() Returns the number of elements currently in the queue.
Your implementation will be tested using multiple threads at the same time. Each thread will either be a producer thread that only makes calls to the enqueue method or a consumer thread that only makes calls to the dequeue method. The size method will be called after every test case.

Please do not use built-in implementations of bounded blocking queue as this will not be accepted in an interview.

*/

class BoundedBlockingQueue
{
    private Queue<Integer> Q;
    private int capacity;

    public BoundedBlockingQueue(int capacity)
    {
        this.Q = new LinkedList<Integer>();
        this.capacity = capacity;
    }

    private synchronized boolean isFull()
    {
        return (this.Q.size() == this.capacity);
    }

    private synchronized boolean isEmpty()
    {
        return this.Q.isEmpty();
    }

    public void enqueue(int element) throws InterruptedException
    {
        synchronized(Q)
        {
            while (this.isFull())
                Q.wait();

            Q.offer(element);
            Q.notifyAll();
        }
    }

    public int dequeue() throws InterruptedException
    {
        synchronized(Q)
        {
            while (this.isEmpty())
                Q.wait();

            int value = Q.poll();
            Q.notifyAll();
            return value;
        }
    }

    public int size()
    {
        synchronized(this)
        {
            return Q.size();
        }
    }
}
