 def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        
        slow = fast = head
        
        # Find the middle of a linked list
        # o(n)
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        
        prev = None
        curr = slow.next
        # Reverse second half
        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        slow.next = None
        
        print(head)
        print(prev)
        
        # merge the two lists
        head1, head2 = head, prev
        
        while head2:
            next = head1.next
            head1.next = head2
            
            # swap the ordering around so they swap 
            head1 = head2
            head2 = next