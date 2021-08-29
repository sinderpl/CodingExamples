"""
# Definition for a Node.
class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""

class Solution:
    def flatten(self, head: 'Node') -> 'Node':
        # if not head:
        #     return None 
        
        res = head
    
        while head:
            nextNode = head.next
            
            if head.child:
                child = self.flatten(head.child)
                head.next = child
                child.prev = head
                
                # if terminal node exists update
                if nextNode:
                    while child.next:
                        child = child.next
                    child.next = nextNode
                    nextNode.prev = child
                head.child = None
            
            head = nextNode
        
        tmp = res
        
        return res