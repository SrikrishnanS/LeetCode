/* 430. Flatten a Multilevel Doubly Linked List

You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.

Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.

Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution 
{
    public Node flatten(Node head) 
    {
        Stack<Node> S = new Stack<Node>();
        Node last = null, curr;
        
        S.push(head);
        while (!S.isEmpty())
        {
            curr = S.pop();
            
            if (curr == null)
                continue;

            curr.prev = last;
            if (last != null)
                last.next = curr;
            // push next first and then child
            // as child should be on top of stack
            S.push(curr.next);
            S.push(curr.child);
            curr.child = null;
            last = curr;
        }
        return head;
    }
}
