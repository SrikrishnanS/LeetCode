/*
341. Flatten Nested List Iterator

You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.

Implement the NestedIterator class:

NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
int next() Returns the next integer in the nested list.
boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
Your code will be tested with the following pseudocode:

initialize iterator with nestedList
res = []
while iterator.hasNext()
    append iterator.next() to the end of res
return res
If res matches the expected flattened list, then your code will be judged as correct.

*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> 
{
    private Stack<NestedInteger> S;

    public NestedIterator(List<NestedInteger> nestedList) 
    {
        this.S = new Stack<NestedInteger>();
        unpackList(S, nestedList);
    }

    private void unpackList(Stack<NestedInteger> S, List<NestedInteger> l)
    {
        for (int i = l.size() - 1; i >= 0; --i)
            if (l.get(i).isInteger() ||
                !l.get(i).getList().isEmpty())
                S.push(l.get(i));
    }

    @Override
    public boolean hasNext() 
    {
        while (!S.isEmpty() && !S.peek().isInteger())
        {
            NestedInteger i = S.pop();
            
            unpackList(S, i.getList());
        }
        return !S.isEmpty();
    }

    @Override
    public Integer next() 
    {
        if (!hasNext())
            return null;
        
        return S.pop().getInteger();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
