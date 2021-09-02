# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        if not head or not head.next:
            return None
        if n == 0:
            return head
        
        slow = fast = head
        # Increment the fast pointer up to N if possible
        for _ in range(n):
            fast = fast.next
            
        # If we need to delete the first value in the list
        # this will not cover the edge case where n > len(head)
        if not fast:
            return head.next
        
        # keep going until the end to reach end - nth node
        while fast.next:
            slow = slow.next
            fast = fast.next
        slow.next = slow.next.next
        return head