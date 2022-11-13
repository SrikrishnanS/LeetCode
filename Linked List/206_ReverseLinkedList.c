/* 206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode *reverse(struct ListNode* node, struct ListNode** newHead)
{
    struct ListNode *tail;
    if (node->next == NULL)
    {
        *newHead = node;
        return node;
    }
    tail = reverse(node->next, newHead);
    tail->next = node;
    node->next = NULL;
    return node;
}

struct ListNode* reverseList(struct ListNode* head)
{
    struct ListNode *newHead = head;
    if (head != NULL)
        reverse(head, &newHead);
    return newHead;
}