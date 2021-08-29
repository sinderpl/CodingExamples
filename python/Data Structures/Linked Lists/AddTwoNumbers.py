# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        if not l1:
            return l2
        if not l2:
            return l1
        
        result = ListNode()
        head = result
        carryOver = 0
        
        while l1 or l2:
            currTotal = carryOver
            if l1:
                currTotal += l1.val
                l1 = l1.next
            if l2:
                currTotal += l2.val
                l2 = l2.next
            
            if currTotal > 9:
                carryOver = currTotal - 9
                currTotal = 0
            else:
                carryOver = 0
            
            head.next = ListNode(currTotal)
            head = head.next
        
        if carryOver != 0:
            head.next = ListNode(carryOver)
            head = head.next
        
        
        
        return result.next
        