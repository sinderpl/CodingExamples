# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == None or head.next == None:
            return head
        
        res = head
        
        lastOdd = head
        firstEven = head.next
        
        ptr1 = head
        ptr2 = head.next
        
        counter = 1
        
        while ptr1 and ptr2:

            if counter % 2 == 0:
                ptr1.next = ptr2.next
                lastOdd = ptr1
                ptr1 = ptr2.next
                if ptr1 != None:
                    ptr2.next = ptr1.next
                    ptr2 = ptr1.next
            counter += 1
        lastOdd.next = firstEven
        
        return res
        