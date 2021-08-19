# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    # This works and uses no extra space complexity but is very slow
    # Complexity of O(n * m)
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if lists == None or len(lists) == 0:
            return None
        
        head = ListNode(-1)
        curr = head
        
        # n
        while len(lists) >= 1:
            index = 0
            currSmall = sys.maxsize
            nodeRef = None
            # m 
            for count, value in enumerate(lists):
                if value and value.val <= currSmall:
                    index = count
                    currSmall = value.val
                    nodeRef = value
            
            if nodeRef:
                curr.next = nodeRef
                curr = curr.next

                lists[index] = nodeRef.next
            if lists[index] == None:
                lists.pop(index)
        # n * m
        
        return head.next


    # This should be a better complexity
    def mergeKLists2(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
            if lists == None or len(lists) == 0:
                return None
            
            head = ListNode(-1)
            curr = head
            
            # n * m space complexity
            while len(lists) >= 1:
                # additional N complexity to remove empty lists
                lists = [item for item in lists if item != None]
                if len(lists) == 0:
                    break
                # Sorting is logN additional on each run 
                lists.sort(key=lambda x: x.val)
                curr.next = lists[0]
                curr = curr.next
                lists[0] = lists[0].next

            # Total
            # ( n * m ) * (n  + logN)
            # 1
            return head.next

    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if lists == None or len(lists) == 0:
            return None
        
        nodes = []
        head = ListNode(-1)
        curr = head
        
        # n * m running complexity
        # n * m space complexity
        for l in lists:
            while l:
                nodes.append(l)
                l = l.next
                
        #Sorting for logN
        nodes.sort(key=lambda x: x.val) # use this instead of sorted for smaller memory footprint
        for k in nodes:
            curr.next = k
            curr = curr.next
        
        #Total
        # (n * m) + logN + n
        # n * m
        
        return head.next