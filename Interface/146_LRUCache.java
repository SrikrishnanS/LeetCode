/* 146. LRU Cache

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
 */
class Node
{
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value)
    {
        this(key, value, null);
    }
    public Node(int key, int value, Node next)
    {
        this(key, value, next, null);
    }
    public Node(int key, int value, Node next, Node prev)
    {
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}    
    
class LRUCache
{
    Map <Integer, Node> cache;
    int capacity;
    Node head, tail;

    public LRUCache(int capacity)
    {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.tail = new Node(-1, -1);
        this.head = new Node(-1, -1, this.tail);
        this.tail.prev = head;
    }
    
    private void deleteNode(Node node)
    {
        // remove the node from current position
        node.prev.next = node.next;
        node.next.prev = node.prev; 
    }
    
    private void insertNode(Node node)
    {
        if (node.key != head.next.key)
        {
            // place the node ahead of head
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }
    }

    public int get(int key) 
    {
        Node node = cache.get(key);

        if (node == null)
            return -1;

        if (node.key != head.next.key)
        {
            deleteNode(node);
            insertNode(node);
        }
        return node.value;
    }
    
    public void put(int key, int value) 
    {
        Node node;
        
        if (cache.containsKey(key))
        {
            node = cache.get(key); // cache hit
            node.value = value;
            deleteNode(node);
        }
        else // cache miss
            node = new Node(key, value);

        cache.put(key, node);
        insertNode(node);

        // cache run out of space, evict LRU node
        if (cache.size() > capacity)
        {
            Node n = tail.prev;
            deleteNode(n);
            if (cache.remove(n.key) == null)
                throw new NullPointerException();
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
