# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        ptr = head.next
        stack = list()
        
        while ptr:
            stack.append(ptr)
            ptr = ptr.next
        
        end = True
        while stack:
            head.next = stack.pop() if end else stack.pop(0)
            head.next.next = None
            end = not end
            head = head.next
            