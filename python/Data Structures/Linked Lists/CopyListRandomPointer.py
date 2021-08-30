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
        








        def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return None
        
        newHead = ptr = Node(0, None, None)
        tempPtr = head
        
        # Inject new nodes in between the old ones
        while tempPtr:
            newNode = Node(tempPtr.val, tempPtr.next, tempPtr.random)
            tempPtr.next = newNode
            tempPtr = newNode.next
        
        # Extract new nodes into their own structure
        # Another pass needed to clean up the old nodes
        tempPtr = head
        while tempPtr:
            newCopy = tempPtr.next
            oldNext = tempPtr.next.next
            ptr.next = newCopy
            newCopy.random = newCopy.random.next if newCopy.random else None
            tempPtr = tempPtr.next.next
            ptr = ptr.next
        
        ptr.next = None
            
        return newHead.next