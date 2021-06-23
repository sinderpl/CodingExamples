
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTreeRecursive(self, root: TreeNode) -> TreeNode:
        if root is None:
            return root
        temp = root.left
        root.left = self.invertTree(root.right)
        root.right = self.invertTree(temp)
        
        return root

    def invertTreeIterative(self, root: TreeNode) -> TreeNode:
                #Iterative
        if root is None:
            return None
        queue = []
        queue.append(root)
        
        while queue:
            curr = queue.pop()
            temp = curr.left
            curr.left = curr.right
            curr.right = temp
            if  curr.left:
                queue.append(curr.left)
            if curr.right:
                queue.append(curr.right)
            
            
        
        return root