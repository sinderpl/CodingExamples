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




    # Space efficient solution using recursion
    def flattenRecursive(self, head: 'Node') -> 'Node':
        if not head:
            return None
        
        while head:
            nextNode = head.next
            if head.child:
                childEnd = self.flattenRecursive(head.child)
                
                #  link the beginning of the child list
                head.next = head.child
                head.child.prev = head
                head.child = None
                
                # Link the end of the child list 
                # only if another node exists
                # Otherwise we return the tail to be linked at a upper level
                if nextNode:
                    nextNode.prev = childEnd
                    childEnd.next = nextNode
                else:
                    return childEnd
                
            # we make sure to return the last node
            if not nextNode:
                return head
            else:
                head = nextNode
        
        # We should never reach here
        return None
    
    # O(N + M + len(m[x]))runtime where N is each node
    # Constant space complexity
    def flatten(self, head: 'Node') -> 'Node':
        self.flattenRecursive(head)
        return head