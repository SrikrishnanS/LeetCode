/*
432. All O`one Data Structure

Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.

Implement the AllOne class:

AllOne() Initializes the object of the data structure.
inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".
Note that each function must run in O(1) average time complexity.

*/

class StringNode
{
    private int  count;
    StringNode   previous;
    StringNode   next;

    private      Set<String> set;
    
    public StringNode(int count)
    {
        this.count = count;
        this.set = null;
    }
    public boolean removeKey(String key)
    {
        boolean result = this.set.remove(key);
        
        if (isEmpty())
            this.set = null; // destroy if empty
        
        return result;
    }
    public boolean addKey(String key)
    {
        if (this.set == null)
            this.set = new HashSet<String>();
        
        boolean result = this.set.add(key);
        
        return result;
    }
    // insert node before this node
    public void insertBefore(StringNode node)
    {
        this.previous.next = node;
        node.previous = this.previous;
        this.previous = node;
        node.next = this;
    }
    // insert node after this node
    public void insertAfter(StringNode node)
    {
        node.next = this.next;
        this.next.previous = node;
        this.next = node;
        node.previous = this;
    }
    // unlink this node from the list
    public void unlink()
    {
        this.previous.next = this.next;
        this.next.previous = this.previous;
        this.next = this.previous = null;
    }
    public boolean isEmpty()
    {
        return (this.set == null) || (this.set.isEmpty());
    }
    public String getOne()
    {
        return isEmpty() ? "" : this.set.iterator().next();
    }
}

class AllOne 
{
    // map of string -> count
    private Map<String, Integer> stringMap;
    
    // map of count -> set of strings
    private Map<Integer, StringNode> countMap;
    
    // head and tail of string nodes ordered by count
    private StringNode head;
    private StringNode tail;
    
    public AllOne() 
    {
        // set up DLL
        this.head = new StringNode(Integer.MIN_VALUE);
        this.tail = new StringNode(Integer.MAX_VALUE);
    
        this.head.next = tail;
        this.tail.previous = head;
     
        // setup string counter maps
        this.stringMap = new HashMap<String, Integer>();
        this.countMap = new HashMap<Integer, StringNode>();
    }

    private boolean isEmpty()
    {
        return (this.tail.previous == this.head);
    }
    
    public void inc(String key) 
    {
        int oldCount = this.stringMap.getOrDefault(key, 0);
        int newCount = oldCount + 1;
        
        StringNode previous = this.countMap.get(oldCount);
        StringNode current  = this.countMap.get(newCount);

        if (previous == null)
            previous = this.head; // start from 0
        
        if (current == null)
        {
            current = new StringNode(newCount); // start with count 1
            previous.insertAfter(current); // insert after head
            this.countMap.put(newCount, current); // update new node pointer
        }
        
        // update previous list
        if (previous != this.head)
            previous.removeKey(key);
        // remove previous from list if not needed
        if (previous != this.head && previous.isEmpty())
        {
            previous.unlink();
            this.countMap.remove(oldCount); // remove from count map too
        }

        // update new list
        current.addKey(key);
        this.stringMap.put(key, newCount);
    }
    
    public void dec(String key)
    {
        int oldCount = this.stringMap.getOrDefault(key, 0);
        int newCount = oldCount - 1;
        
        StringNode previous = this.countMap.get(oldCount); // can't be null
        StringNode current  = this.countMap.get(newCount);

        if (current == null)
        {
            current = new StringNode(newCount); // start with count 1
            previous.insertBefore(current); // insert before current
            this.countMap.put(newCount, current); // update new node pointer
        }
        
        // update previous list
        previous.removeKey(key);
        
        // remove previous from list if not needed
        if (previous.isEmpty())
        {
            previous.unlink();
            this.countMap.remove(oldCount); // remove from count map too
        }
        if (newCount == 0)
        {
            current.unlink();
            this.countMap.remove(newCount); // remove from count map too
        }
        
        // update new list
        current.addKey(key);
        this.stringMap.put(key, newCount);
    }
    
    public String getMaxKey() 
    {
        return this.tail.previous.getOne();
    }
    
    public String getMinKey() 
    {
        return this.head.next.getOne();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
