package TestForAlgorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class Aug27 {

    public static void main(String[] args) {
        Deque<TreeNode> deque = new ArrayDeque<>();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(7);

        System.out.println(widthOfBinaryTree(root));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.offerLast(root);
        int res = 1;
        while(!deque.isEmpty()){

            while(deque.peekLast().val == 101){
                deque.pollLast();
                if(deque.size() == 0){
                    break;
                }
            }
            res = Math.max(res, deque.size());

            int size = deque.size();

            while(size != 0){
                TreeNode cur = deque.pollFirst();
                if(cur.val == 101){
                    deque.offerLast(new TreeNode(101));
                    deque.offerLast(new TreeNode(101));
                    size--;
                    continue;
                }

                if(cur.left == null){
                    deque.offerLast(new TreeNode(101));
                }else if(cur.left != null){
                    deque.offerLast(cur.left);
                }

                if(cur.right == null){
                    deque.offerLast(new TreeNode(101));
                }else if(cur.right != null){
                    deque.offerLast(cur.right);
                }
                size--;
            }
        }
        return res;
    }
}
