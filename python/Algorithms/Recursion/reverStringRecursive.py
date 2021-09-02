class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        if s:
            curr = s.pop(0)
            self.reverseString(s)
            s.append(curr)
        