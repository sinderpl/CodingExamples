"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return None
        
        newHead = ptr = Node(0, None, None)
        
        # Additional O(n) space complexity
        hashMap = dict()
        
        # O(N) runtime
        while head:
            nodeCopy = None
            nodeCopyRandom = None
            
            #Check if our original head is already created
            if head in hashMap:
                nodeCopy = hashMap.get(head)
            else:
                nodeCopy = Node(head.val, None, None)
                hashMap[head] = nodeCopy
            
            if head.random:
                if head.random in hashMap:
                    nodeCopyRandom = hashMap.get(head.random)
                else:
                    nodeCopyRandom = Node(head.random.val, None, None)
                    hashMap[head.random] = nodeCopyRandom
                    
            nodeCopy.random = nodeCopyRandom
            ptr.next = nodeCopy
            
            # Move the counters
            ptr = ptr.next
            head = head.next
            
        return newHead.next
        