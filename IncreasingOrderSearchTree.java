/* 
https://leetcode.com/problems/increasing-order-search-tree/

Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.
Example 1:

Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

Example 2:

Input: root = [5,1,7]
Output: [1,null,5,null,7]
 

Constraints:

The number of nodes in the given tree will be in the range [1, 100].
0 <= Node.val <= 1000
*/

class IncreasingOrderSearchTree {
    ArrayList<Integer> values = new ArrayList<Integer>();
    public TreeNode increasingBST(TreeNode root) {
        traverseNodes(root);
        TreeNode node = new TreeNode(values.get(0));
        TreeNode curNode = node;
        for(int i = 1; i < values.size(); i ++) {
            curNode.right = new TreeNode(values.get(i));
            curNode = curNode.right;
        }
        return node;
    }
    
    public void traverseNodes(TreeNode node) { //in order traversal
        if(node == null) 
            return;
        traverseNodes(node.left);
        values.add(node.val);
        traverseNodes(node.right);
    }
}