/*
716. Max Stack

Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.

Implement the MaxStack class:

MaxStack() Initializes the stack object.
void push(int x) Pushes element x onto the stack.
int pop() Removes the element on top of the stack and returns it.
int top() Gets the element on the top of the stack without removing it.
int peekMax() Retrieves the maximum element in the stack without removing it.
int popMax() Retrieves the maximum element in the stack and removes it. If there is more than one maximum element, only remove the top-most one.

*/

class IntegerNode
{
    Integer value;
    IntegerNode previous;
    IntegerNode next;

    public IntegerNode()
    {
        this(null);
    }

    public IntegerNode(Integer value)
    {
        this.value = value;
    }
}

class IntegerList
{
    IntegerNode head;
    IntegerNode tail;

    public IntegerList()
    {
        this.head = new IntegerNode();
        this.tail = new IntegerNode();

        this.head.next = this.tail;
        this.tail.previous = this.head;
    }

    public void push(IntegerNode node)
    {
        tail.previous.next = node;
        node.previous = tail.previous;
        node.next = tail;
        tail.previous = node;
    }
    public IntegerNode pop()
    {
        IntegerNode node = tail.previous;

        remove(node);
        return node;
    }
    public IntegerNode peek()
    {
        return tail.previous;
    }
    public void remove(IntegerNode node)
    {
        node.previous.next = node.next;
        node.next.previous = node.previous;
        node.next = node.previous = null;
    }
}

class MaxStack
{
    IntegerList stack; // the actual stack
    TreeMap<Integer, List<IntegerNode>> tree;

    public MaxStack()
    {
        stack  = new IntegerList();
        tree  = new TreeMap<Integer, List<IntegerNode>>();
    }

    public void push(int x)
    {
        IntegerNode node = new IntegerNode(x);

        stack.push(node);
        tree.putIfAbsent(x, new LinkedList<IntegerNode>());
        tree.get(x).add(node);
    }

    public int pop()
    {
        IntegerNode       node = stack.pop();
        List<IntegerNode> l    = tree.get(node.value);

        l.remove(l.size() - 1);
        if (tree.get(node.value).isEmpty())
            tree.remove(node.value);

        return node.value;
    }

    public int top()
    {
        return stack.peek().value;
    }

    public int peekMax()
    {
        return tree.lastKey();
    }

    public int popMax()
    {
        int               x    = peekMax(); // max value in the tree
        List<IntegerNode> l    = tree.get(x);
        IntegerNode       node = l.remove(l.size() - 1);

        stack.remove(node);

        if (tree.get(x).isEmpty())
            tree.remove(x);

        return node.value;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */