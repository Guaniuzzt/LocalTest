package TestForAlgorithm;

public class Maximum_Binary_Tree {

    public static void main(String[] args) {
        int[] array = new int[]{3,2,1,6,0,5};
        TreeNode res = constructMaximumBinaryTree(array);

    }
    public static TreeNode constructMaximumBinaryTree(int[] nums) {

        return insert(nums, 0, nums.length-1);
    }


    public static TreeNode insert(int[] nums, int left, int right){

        if(left > right){
            return null;
        }

        int max = nums[left];
        int index = left;

        for(int i=left; i<=right; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = insert(nums, left, index-1);
        node.right = insert(nums, index+1, right);
        return node;

    }
}
