# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        newHead = None
        curr = None
        prev = None

        while head != None:
            if head.val == val:
                if prev != None:
                    prev.next = None
            else:
                if newHead == None:
                    newHead = head
                if prev != None:
                    prev.next = head
                else:
                    prev = head
            head = head.next
        
        return newHead
        
        