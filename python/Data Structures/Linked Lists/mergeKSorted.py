# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if lists == None:
            return None
        
        head = ListNode(-1)
        curr = head
        
        while len(lists) >= 1:
            print(lists)
            print("----------")
            index = 0
            currSmall = sys.maxsize
            nodeRef = None
            
            for count, value in enumerate(lists):
                print("val", value.val, "comparison", currSmall)
                if value and value.val <= currSmall:
                    print("current smallest value" , value.val)
                    index = count
                    currSmall = value.val
                    nodeRef = value
            
            curr.next = nodeRef
            curr = curr.next
            
            lists[index] = nodeRef.next
            if lists[index] == None:
                lists.pop(index)
            
        
        return head.next