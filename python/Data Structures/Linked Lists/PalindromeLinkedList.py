# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if not head:
            return False
        
        isPalindrome = False
        listSize = 0
        
        temp = head
        nums = list()
        while temp:
            nums.append(temp.val)
            temp = temp.next
        
        mid = len(nums) // 2
        while len(nums) != mid:
            curr = nums.pop()
            if curr != head.val:
                return False
            head = head.next
        
        
        return True