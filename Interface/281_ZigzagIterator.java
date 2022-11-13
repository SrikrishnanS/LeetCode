/* 281. Zigzag Iterator

Given two vectors of integers v1 and v2, implement an iterator to return their elements alternately.

Implement the ZigzagIterator class:

ZigzagIterator(List<int> v1, List<int> v2) initializes the object with the two vectors v1 and v2.
boolean hasNext() returns true if the iterator still has elements, and false otherwise.
int next() returns the current element of the iterator and moves the iterator to the next element.
 */
public class ZigzagIterator 
{
    List<Integer> L1;
    List<Integer> L2;
    int nextTurn;
    int l1Curr;
    int l2Curr;
    
    public ZigzagIterator(List<Integer> L1, List<Integer> L2) 
    {
        this.L1 = L1;
        this.L2 = L2;
        nextTurn = 1;
        l1Curr = 0;
        l2Curr = 0;
    }
    
    public int next() 
    {
        if (nextTurn == 1 && l1Curr < L1.size())
        {
            if (l2Curr < L2.size())
                nextTurn = 2;
            return L1.get(l1Curr++);
        }
        if (l2Curr < L2.size())
        {
            if (l1Curr < L1.size())
                nextTurn = 1;
            return L2.get(l2Curr++);
        }
        return -1;
    }

    public boolean hasNext() 
    {
        return (l1Curr < L1.size() || l2Curr < L2.size());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
