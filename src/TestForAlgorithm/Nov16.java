package TestForAlgorithm;

public class Nov16 {

    public static void main(String[] args) {
        int[] array = new int[]{0,2,1};
        System.out.println(isIdealPermutation(array));
    }

    public static boolean isIdealPermutation(int[] nums) {

        if(nums.length == 1) return true;
        int n = nums.length;
        int[] dp = new int[n];
        int part = 0;
        int all = 0;
        for(int i=n-2; i>=0; i--){
            if(nums[i] > nums[i+1]){
                part++;
                dp[i] = dp[i+1] + 1;
            }else{
                dp[i] = dp[i+1];
            }
            all += dp[i];
        }

        if(all == part) return true;
        else return false;


    }
}
