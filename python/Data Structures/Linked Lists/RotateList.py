# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    # O(2*N) runtime complexity
    # 0()
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head:
            return None
        if k == 0 or not head.next:
            return head
        
        nodes = []
        ptr = head
        while ptr:
            nodes.append(ptr)
            ptr = ptr.next
        
        shift = k % len(nodes)
        if shift == 0:
            return head
       
        newHead = ptr = ListNode(0, None)
        for idx in range(len(nodes)):
            node = nodes[(idx - shift)]
            ptr.next = node
            
            
            ptr = ptr.next
            
        ptr.next = None
        
        return newHead.next