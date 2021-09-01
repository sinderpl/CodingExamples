# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        if not head or not head.next or n == 0:
            return None
        # if head and n == 1:
        #     return None
        # if head.next and 
        
        # lastN = list()
        
        slow = head
        fast = head.next
#         while fast and n > 0:
        
#             fast = fast.next
#             n -= 1
        
        c = 0
        for _ in range(n):
            fast = fast.next
            if not fast:
                break
        
        print("fast ",fast)
        print("c",c)
        
        if not fast:
            return head.next
        
        while fast.next:
            slow = slow.next
            fast = fast.next
        
        slow.next = slow.next.next
        print(head)
        return head