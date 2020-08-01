package LeetCode;

import LeetCode.BSTPreorder.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /* Iterative solution */
//        if (p == null && q == null) return true;
//        else if (p != null && q != null) { ; }
//        else return false;
//        Queue<TreeNode> queueP = new LinkedList<>();
//        queueP.add(p);
//        Queue<TreeNode> queueQ = new LinkedList<>();
//        queueQ.add(q);
//        while (!queueP.isEmpty() || !queueQ.isEmpty()) {
//            if(queueP.isEmpty() || queueQ.isEmpty()) {
//                return false;
//            }
//            TreeNode nodeP = queueP.poll();
//            TreeNode nodeQ = queueQ.poll();
//            if (nodeP.val != nodeQ.val) return false;
//            if (nodeP.left != null && nodeQ.left != null) {
//                queueP.add(nodeP.left);
//                queueQ.add(nodeQ.left);
//            } else if (nodeP.left == null && nodeQ.left == null) { ; }  // Let the cycle continue running
//            else return false;   // Otherwise, difference was found
//            if (nodeP.right != null && nodeQ.right != null) {
//                queueP.add(nodeP.right);
//                queueQ.add(nodeQ.right);
//            } else if (nodeP.right == null && nodeQ.right == null) { ; }
//            else return false;
//        }
//        return true;
        /* Recursive solution */
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        else if (p.val != q.val) return false;
        else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
