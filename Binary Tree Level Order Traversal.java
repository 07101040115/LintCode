/*
34% Accepted
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
Challenge
Using only 1 queue to implement it.

Tags Expand 
Tree Search Breadth First Search Queue Binary Tree

Thinking process:
1. Non-recursive
Use queue to withhold the parent.
Poll one parent, add this parent’s value to arrayList
Add the children into Arraylist
jump to next level
2. Recursive
use a integer to track levels.
If at a new level, then create a new ArrayList.
At each node, add the node to corresponding level-ArrayList
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
  
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        /* //Non-recurive Iterative way:
        //Use a queue to list elements: each row
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = queue.size();//Limit the size, since the queue is increasing
            for (int i = 0; i < size; i++) {
                TreeNode levelNode = queue.poll();
                list.add(levelNode.val);//Add all the values from this current level
                if (levelNode.left != null) {
                    queue.offer(levelNode.left);
                }
                if (levelNode.right != null) {
                    queue.offer(levelNode.right);                    
                }
            }
            result.add(list);
        }//while
        */

        //Recursive:
        dfs(root, 0, result);
        return result;    
    }
    
    public void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> rst) {
        if (root == null) {
            return;
        }
        if (level >= rst.size()) {
            rst.add(new ArrayList<Integer>());
        }
        rst.get(level).add(root.val);
        dfs(root.left, level + 1, rst);
        dfs(root.right, level + 1, rst);
    }
}

