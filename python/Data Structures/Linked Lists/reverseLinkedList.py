# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # if head.next == None:
        #     return head
        
        prev = None
        curr = head
        
        while curr != None:
            # tmp = curr.next
            # curr.next = prev
            # tmp.next = curr
            # curr = tmp
            
            temp = head
            print("temp", temp)
            head.next = curr.next
            curr.next = head
            # curr = curr.next
            
            print("HeadAfterNext", head)
            print("CurrAfterNext", curr)
            
            head = curr
            print("head", head)
            curr = temp.next
            print("curr", curr)
            
            curr2 = head
            while curr2 != None:
                print(curr2.val)
                curr2 = curr2.next
            print("-------------")
            
            
            
            # nextNode = curr.next
            
            
        return head
        