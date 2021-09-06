# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        tempNextNext = head.next.next
        next = head.next
        tmpHead = head
        
        head.next.next = head
        head = head.next
        head.next.next = self.swapPairs(tempNextNext)
        
        return head