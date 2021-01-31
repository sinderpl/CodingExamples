/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> counters = new HashMap<>();
        int maxMode = 0;
        maxMode = iterateNode(root, counters, maxMode);
        
        ArrayList<Integer> modes = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : counters.entrySet()){
            if(entry.getValue() == maxMode){
                modes.add(entry.getKey());
            }
        }
        
        int[] arr = new int[modes.size()];
        int curr = 0;
        for(int key : modes){
            arr[curr] = key;
            curr++;
        }
        return arr;
    }
    
    public int iterateNode(TreeNode root, HashMap<Integer, Integer> counters, int maxMode){
        if(root != null){
            if(counters.containsKey(root.val)){
                counters.put(root.val, counters.get(root.val)+1); 
            } else {
                counters.put(root.val, 1); 
            }
            maxMode = Math.max(maxMode, counters.get(root.val));
            maxMode = Math.max(maxMode, iterateNode(root.left, counters, maxMode));
            maxMode = Math.max(maxMode, iterateNode(root.right, counters, maxMode));    
        }
        return maxMode;
    }
}