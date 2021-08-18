# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        newHead = None
        prev = head

        while head != None:
            if head.val == val:
                prev.next = head.next
            else:
                if newHead == None:
                    newHead = head
                prev = head
            head = head.next 
        
        return newHead